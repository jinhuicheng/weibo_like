package com.cjh.common.log.weibo.like.common;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:35 下午
 * @description
 */
public class InnerResult<T> {
  private T result;
  private String resultCode;
  private boolean isSuccess;

  public InnerResult(T result) {
    this.result = result;
    this.resultCode="success";
    this.isSuccess=true;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }
}
