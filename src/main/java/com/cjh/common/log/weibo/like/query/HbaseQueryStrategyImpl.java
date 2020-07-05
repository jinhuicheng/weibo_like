package com.cjh.common.log.weibo.like.query;

import com.cjh.common.log.weibo.like.common.InnerResult;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:46 下午
 * @description 历史较冷数据直接查询服务
 */
public class HbaseQueryStrategyImpl implements QueryStrategy{

  @Override
  public InnerResult<Boolean> queryIsLiked(int uid, int statusId) {
    //略。。。
    return null;
  }
}
