package com.cssf.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/10 - 05 -10 - 19:39
 * @Description: com.cssf.config
 * @Version: 1.0
 */
@Component
public class SpringUtils implements ApplicationContextAware {
    //这个方法可以拿到spring容器里面的bean，为集成netty里面的bean
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext =  applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

}
