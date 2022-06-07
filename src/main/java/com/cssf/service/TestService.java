package com.cssf.service;

import com.cssf.pojo.TestBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/25 - 05 -25 - 9:37
 * @Description: com.cssf.service
 * @Version: 1.0
 */
public interface TestService {
    void insertData(TestBean testBean);

    List<TestBean> queryAll();
}
