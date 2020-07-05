package com.cjh.common.log.weibo.like.query;

import com.cjh.common.log.weibo.like.common.InnerResult;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:37 下午
 * @description
 */
public class QueryContext {

  private QueryStrategy queryStrategy;
  private int uid;
  private int statusId;

  public void  setQueryContext(QueryStrategy queryStrategy, int uid, int statusId) {
    this.queryStrategy = queryStrategy;
    this.uid = uid;
    this.statusId = statusId;
  }

  public InnerResult<Boolean> queryIsLiked(){
    return queryStrategy.queryIsLiked(uid,statusId);
  }

}
