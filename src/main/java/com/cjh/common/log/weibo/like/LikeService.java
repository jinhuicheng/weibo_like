package com.cjh.common.log.weibo.like;

import com.cjh.common.log.weibo.like.common.BusinessException;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 4:36 下午
 * @description
 */
public interface LikeService {

  /**
   * 点赞
   * @param uid 用户id
   * @param statusId 微博id
   */
  void like(int uid, int statusId);

  /**
   * 查询是否点过赞
   * @param uid 用户id
   * @param statusId 微博id
   * @return 是否点过
   */
  boolean isLiked(int uid, int statusId) throws BusinessException;
}
