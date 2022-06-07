package com.cssf.netty;

import com.cssf.pojo.TestBean;
import com.cssf.service.TestService;
import com.cssf.service.TestServiceImp;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/10 - 05 -10 - 21:18
 * @Description: com.cssf.netty
 * @Version: 1.0
 */


@Component
public class MyDecoder extends ByteToMessageDecoder {

    @Autowired
    private  TestService testService ;

//    public static MyDecoder myDecoder;
//    public  MyDecoder(){}
//    @PostConstruct
//    public void init(){
//        if(myDecoder==null)
//        myDecoder = new MyDecoder();
//        if(myDecoder.testService==null)
//        myDecoder.testService = new TestServiceImp();
//    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
//        System.out.println(bytes.toString());
        String s = bytesToHexString(bytes);
        int countt = 0;
        int count = 0;
        for(int i =0; s.length() != 2 ; i++){
            String data = s.substring(0,2); //11

            int tdata  = Integer.valueOf(data,16);
            count += tdata; //11
            countt++; // 1
            s = s.substring(2); //22

//            list.add(data);
        }
//        list.add(s);
        int tdata =Integer.valueOf(s,16);
        count += tdata;
        countt ++;
        System.out.println("你多长：" +countt);
//        System.out.println(list.size());
        float data = count / countt;
        list.add(data);
        Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        testService.insertData(new TestBean(data,t));


        System.out.println(data);
        System.out.println("接收到的数据: "+ list);

    }


    public String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static String toHexString1(byte[] b) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < b.length; ++i) {
            buffer.append(toHexString1(b[i]));
        }
        return buffer.toString();
    }

    public static String toHexString1(byte b) {
        String s = Integer.toHexString(b & 0xFF);
        if (s.length() == 1) {
            return "0" + s;
        } else {
            return s;
        }
    }


}
