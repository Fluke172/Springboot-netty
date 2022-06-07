package com.cssf.mapper;

import com.cssf.pojo.TestBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/25 - 05 -25 - 9:27
 * @Description: com.cssf.mapper
 * @Version: 1.0
 */
@Mapper
public interface TestMapper {
    void insertData(TestBean testBean);

    List<TestBean> queryAll();
}
