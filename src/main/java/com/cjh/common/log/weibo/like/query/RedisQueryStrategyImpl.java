package com.cjh.common.log.weibo.like.query;

import com.cjh.common.log.weibo.like.common.Constants;
import com.cjh.common.log.weibo.like.common.InnerResult;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:46 下午
 * @description 近半年热数据查询缓存服务
 */
@Service
public class RedisQueryStrategyImpl implements QueryStrategy{

  /*缓存客户端*/
  @Resource
  private Jedis redisClient;


  @Override
  public InnerResult<Boolean> queryIsLiked(int uid, int statusId) {

    //redis查询 用户uid是否对微博statusId点过赞
    String result=redisClient.get(Constants.builderUserLikePrefix(uid, statusId));
    if (StringUtils.equals(result,"1")){
      return new InnerResult<Boolean>(true);
    }

    //布隆过滤器查询是否存在该key , 防止缓存穿透
    boolean isExist=queryBooleanFilter(uid,statusId);
    if (!isExist){
      return new InnerResult<>(false);
    }

    //查询数据库
    if (1 <= queryNumFromDB()){
      return new InnerResult<Boolean>(true);
    }

    return new InnerResult<>(false);
  }


  /**
   * 布隆过滤器 略
   * @param uid
   * @param statusId
   * @return
   */
  private boolean queryBooleanFilter(int uid, int statusId) {
    return false;
  }


  /**
   * 查询DB中的数据 略
   * @return
   */
  private int queryNumFromDB() {
    return 1;
  }


}
