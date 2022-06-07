package com.cssf.controller;

import com.alibaba.fastjson.JSON;
import com.cssf.pojo.TestBean;
import com.cssf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/25 - 05 -25 - 9:40
 * @Description: com.cssf.controller
 * @Version: 1.0
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/show")

    public String queryAll(){
        List<TestBean> testBeans = testService.queryAll();
        String s = JSON.toJSONString(testBeans);
        return s;
    }
}
