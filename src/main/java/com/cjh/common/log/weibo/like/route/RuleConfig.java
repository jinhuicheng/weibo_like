package com.cjh.common.log.weibo.like.route;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 4:13 下午
 * @description
 */
public class RuleConfig {

  /**
   * 各逻辑机房配置 room01A:100;room01B:0;room02A:50:room02B:50 ,用户流量切换，分流发布，容灾
   */
  private String roomListConfigStr;


  public String getRoomListConfigStr() {
    return roomListConfigStr;
  }

  public void setRoomListConfigStr(String roomListConfigStr) {
    this.roomListConfigStr = roomListConfigStr;
  }
}
