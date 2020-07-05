package com.cjh.common.log.weibo.like.msg;

import org.apache.rocketmq.common.message.Message;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 6:47 下午
 * @description
 */
public class EventUtil {

  public static Message builderTransactionMsg(int uid, int statusId) {

    return new Message("topic","{uid:123;statusId:456}".getBytes());

  }
}
