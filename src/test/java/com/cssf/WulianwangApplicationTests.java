package com.cssf;

import com.cssf.pojo.TestBean;
import com.cssf.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class WulianwangApplicationTests {
    @Autowired
    private TestService testService;
    @Test
    void contextLoads() {
        int aa = Integer.parseInt("aa", 16);
        System.out.println(aa);
        Date date  =  new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        testService.insertData(new TestBean(12,timestamp));
    }

}
