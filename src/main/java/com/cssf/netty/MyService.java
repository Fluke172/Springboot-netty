package com.cssf.netty;

import com.cssf.pojo.TestBean;
import com.cssf.service.TestService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/10 - 05 -10 - 20:53
 * @Description: com.cssf.netty
 * @Version: 1.0
 */

@Component
public class MyService extends SimpleChannelInboundHandler<Float> {
    @Autowired private TestService testService;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Float aFloat) throws Exception {
        Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        testService.insertData(new TestBean(aFloat,t));
    }
}
