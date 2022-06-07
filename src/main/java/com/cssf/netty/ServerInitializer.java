package com.cssf.netty;

import com.cssf.pojo.TestBean;
import com.cssf.service.TestService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/10 - 05 -10 - 19:55
 * @Description: com.cssf.netty
 * @Version: 1.0
 */
@ChannelHandler.Sharable
@Component
public class ServerInitializer extends ChannelInitializer {
    @Resource
    private MyDecoder myDecoder;
    @Resource
    private MyEncoder myEncoder;
    @Resource
    private TestService testService;
    @Resource
    private MyService myService;

    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline().addLast("log",new LoggingHandler(LogLevel.INFO));
//        channel.pipeline().addLast(new MyHandler());
        channel.pipeline().addLast("encoder",myEncoder);
        channel.pipeline().addLast("decoder",myDecoder);
//        channel.pipeline().addLast("myservice",myService);
    }

}
