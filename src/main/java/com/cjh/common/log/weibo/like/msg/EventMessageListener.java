package com.cjh.common.log.weibo.like.msg;

import java.util.List;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 4:52 下午
 * @description 接收点赞消息，操作入库
 */
public class EventMessageListener implements MessageListenerConcurrently {


  private TransactionTemplate transactionTemplate;

  @Override
  public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

    transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction(TransactionStatus transactionStatus) {

        //step1:insert 用户点赞数据

        //step2:更新 redis 布隆过滤器，防止查询缓存时效时的数据穿透

        //step3: update 微博被点赞个数

        // ....

        return null;
      }
    });

    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
  }
}
