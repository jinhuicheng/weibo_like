package com.cjh.common.log.util;

import java.util.Random;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:02 下午
 * @description
 */
public class NumUtil {

  private static final Random random=new Random(10);

  public static int getRandomNum(){
    return random.nextInt();
  }

}
