package com.cjh.common.log.weibo.like.query;

import com.cjh.common.log.weibo.like.common.InnerResult;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:35 下午
 * @description
 */
public interface QueryStrategy {

    InnerResult<Boolean> queryIsLiked(int uid ,int statusId);
}
