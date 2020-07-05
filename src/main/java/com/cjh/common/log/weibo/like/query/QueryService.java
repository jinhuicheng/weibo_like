package com.cjh.common.log.weibo.like.query;

import com.cjh.common.log.weibo.like.route.DataStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * @author chengjinhui
 * @version 1.0.0
 * @date 2020/7/5 10:33 下午
 * @description
 */
public class QueryService extends ApplicationObjectSupport {

  public QueryContext getQueryContext(DataStrategy strategy,int uid ,int statusId){
    ApplicationContext applicationContext=getApplicationContext();

    QueryStrategy queryStrategy=applicationContext.getBean(strategy.name(),QueryStrategy.class);

    QueryContext context=applicationContext.getBean("queryContext",QueryContext.class);
    context.setQueryContext(queryStrategy,uid,statusId);
    return context;
  }
}
