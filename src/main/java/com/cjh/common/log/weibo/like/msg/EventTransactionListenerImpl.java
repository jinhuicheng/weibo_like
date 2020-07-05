package com.cjh.common.log.weibo.like.msg;

import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 6:48 下午
 * @description 事务消息回查接口
 */
@Service
public class EventTransactionListenerImpl implements TransactionListener {

  /*缓存客户端*/
  @Resource
  private Jedis redisClient;


  @Override
  public LocalTransactionState executeLocalTransaction(Message message, Object o) {
    String uid=message.getUserProperty("uid");
    String statusId=message.getUserProperty("statusId");

    //分支逻辑1 ： 查询缓存中是否有对应记录，如果缓存中数据正常，说明可以继续投递 ，return LocalTransactionState.COMMIT_MESSAGE;

    //分支逻辑2 ： 否则抛弃消息  return LocalTransactionState.ROLLBACK_MESSAGE

    return LocalTransactionState.UNKNOW;
  }

  @Override
  public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
    return null;
  }
}
