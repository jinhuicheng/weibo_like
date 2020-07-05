package com.cjh.common.log.weibo.like;

import static com.cjh.common.log.util.NumUtil.getRandomNum;
import static com.cjh.common.log.weibo.like.common.Constants.builderStatusLikedPrefix;
import static com.cjh.common.log.weibo.like.common.Constants.builderUserLikePrefix;

import com.cjh.common.log.weibo.like.common.BusinessException;
import com.cjh.common.log.weibo.like.common.InnerResult;
import com.cjh.common.log.weibo.like.msg.EventPublisher;
import com.cjh.common.log.weibo.like.msg.EventUtil;
import com.cjh.common.log.weibo.like.query.QueryContext;
import com.cjh.common.log.weibo.like.query.QueryService;
import com.cjh.common.log.weibo.like.route.DataStrategy;
import com.cjh.common.log.weibo.like.route.DataStrategyUtil;
import javax.annotation.Resource;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 4:41 下午
 * @description
 */
@Service
public class LikeServiceImpl implements LikeService{

  /*缓存客户端*/
  @Resource
  private Jedis redisClient;

  /*消息发送客户端*/
  @Resource
  private EventPublisher eventPublisher;

  @Resource
  private QueryService  queryService;

  /**
   * 点赞
   *
   * @param uid      用户id
   * @param statusId 微博id
   */
  @Override
  public void like(int uid, int statusId) {

    // 查询用户是否已经关注过微博，只查缓存
    String redisKey = builderUserLikePrefix(uid, statusId);

    // 如果已经存在，则直接返回，或者 执行删除点赞记录的逻辑
    boolean ifExist = redisClient.exists(redisKey);
    if (ifExist) {
      return;
    }

    // 用户点赞微博
    redisClient.set(redisKey, "1", "nx", "ex", 60 * 60 * 24 * 30 * 6 + getRandomNum());

    // 当前微博被点赞数更新
    redisClient.incr(builderStatusLikedPrefix(statusId));


    try {
      // 发送消息 执行落库操作，事务型保证数据一致性
      Message msg = EventUtil.builderTransactionMsg(uid, statusId);
      eventPublisher.sendMessageInTransaction(msg, null);

    } catch (MQClientException e) {
      e.printStackTrace();
    }
  }


  /**
   * 查询是否点过赞
   *
   * @param uid      用户id
   * @param statusId 微博id
   * @return 是否点过
   */
  @Override
  public boolean isLiked(int uid, int statusId) throws BusinessException {
    //解析当前微博id中的时间戳信息，获取查询服务路由策略
    DataStrategy strategyTag= DataStrategyUtil.parseDataStrategyByStatusId(statusId);

    //根据路由策略获取对应的查询服务
    QueryContext context= queryService.getQueryContext(strategyTag,uid,statusId);

    //执行查询
    InnerResult<Boolean> result=context.queryIsLiked();

    if (result==null || !result.isSuccess()){
      throw new BusinessException("抱歉，网络繁忙请稍后重试");
    }

    return result.getResult();
  }



}
