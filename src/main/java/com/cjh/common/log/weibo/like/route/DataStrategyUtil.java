package com.cjh.common.log.weibo.like.route;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 11:44 下午
 * @description
 */
public class DataStrategyUtil {

  /**
   * 通过statusId中的时间戳解析出查询服务路由策略
   * @param statusId 微博id
   * @return 查询路由策略
   */
  public static DataStrategy parseDataStrategyByStatusId(int statusId) {

    //parse id ，解析时间戳，判断冷热服务

    // 如果是半年之前的则返回  return DataStrategy.COLD ;
    // 如果是半年之内的则返回  return DataStrategy.HOT ;

    return DataStrategy.HOT;
  }
}
