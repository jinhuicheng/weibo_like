package com.cjh.common.log.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/6/11 9:40 下午
 * @description
 */
public class NamedThreadFactory implements ThreadFactory {

  static final AtomicInteger poolNumber = new AtomicInteger(1);
  final AtomicInteger threadNumber = new AtomicInteger(1);
  final ThreadGroup group;
  final String namePrefix;
  final boolean isDaemon;

  public NamedThreadFactory(String name) {
    this(name, false);
  }

  public NamedThreadFactory(String prefix, boolean daemon) {
    SecurityManager s = System.getSecurityManager();
    group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    namePrefix = prefix + "-" + poolNumber.getAndIncrement() + "-thread-";
    isDaemon = daemon;
  }

  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
    t.setDaemon(isDaemon);
    if (t.getPriority() != Thread.NORM_PRIORITY) {
      t.setPriority(Thread.NORM_PRIORITY);
    }

    return t;
  }
}
