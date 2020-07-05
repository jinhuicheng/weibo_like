package com.cjh.common.log.weibo.like.route;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 11:22 上午
 * @description 用户请求路由转发client
 */
public interface RouteClient {

  /**
   * 路由信息初始化 同时回调业务方更新业务方本地的路由信息
   * @param ruleConfig 配置
   */
   void init(RuleConfig ruleConfig);

  /**
   * 路由计算
   * @param routeRequest 路由请求
   * @return 目标逻辑机房或目标机器
   */
   String route(RouteRequest routeRequest);

}
