package com.cjh.common.log.weibo.like.route;

import java.util.Map;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 4:32 下午
 * @description
 */
public class RouteRequest {
  private int uidRouteValue;
  private byte[] requestBody;
  private String targetAppName;
  private Map<String, String> headerMap;
  private boolean isPre;
}
