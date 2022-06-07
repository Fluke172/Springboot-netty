package com.cssf;

import com.cssf.netty.NettyServer;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class WulianwangApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args)  throws Exception{
        ApplicationContext context = new SpringApplicationBuilder(WulianwangApplication.class).run(args);

        NettyServer nettyServer = context.getBean(NettyServer.class);
        nettyServer.start();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
