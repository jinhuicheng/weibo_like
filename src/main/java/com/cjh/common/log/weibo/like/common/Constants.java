package com.cjh.common.log.weibo.like.common;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 5:44 下午
 * @description
 */
public class Constants {

  public static final String USER_LIKE_STATUS_PREFIX="u_like_s_";


  public static final String STATUS_LIKED_PREFIX="s_liked_";



  public static String builderStatusLikedPrefix(int statusId){

    return STATUS_LIKED_PREFIX+statusId;

  }

  public static String builderUserLikePrefix(int uid,int statusId){
    return USER_LIKE_STATUS_PREFIX + uid+"_"+statusId;
  }
}
