package com.cssf.service;

import com.cssf.mapper.TestMapper;
import com.cssf.pojo.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/25 - 05 -25 - 9:38
 * @Description: com.cssf.service
 * @Version: 1.0
 */
@Service
public class TestServiceImp implements TestService{
    @Autowired
    private TestMapper testMapper;
    @Override
    public void insertData(TestBean testBean) {
        testMapper.insertData(testBean);
    }

    @Override
    public List<TestBean> queryAll() {
        return testMapper.queryAll();
    }
}
