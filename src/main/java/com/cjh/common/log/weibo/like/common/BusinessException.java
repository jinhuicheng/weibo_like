package com.cjh.common.log.weibo.like.common;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:44 下午
 * @description
 */
public class BusinessException extends Exception {

  /**
   * Constructs a new exception with the specified detail message.  The cause is not initialized, and may subsequently be initialized by a call to
   * {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
   */
  public BusinessException(String message) {
    super(message);
  }
}
