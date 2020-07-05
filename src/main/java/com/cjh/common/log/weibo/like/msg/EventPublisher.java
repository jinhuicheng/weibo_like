package com.cjh.common.log.weibo.like.msg;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 4:49 下午
 * @description 发送消息
 */
public class EventPublisher extends DefaultMQProducer {

  @Override
  public SendResult send(Message msg) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
    return super.send(msg);
  }
}
