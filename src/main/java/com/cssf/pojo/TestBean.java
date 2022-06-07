package com.cssf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/25 - 05 -25 - 9:20
 * @Description: com.cssf.pojo
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBean {
    protected int id;
    protected float data;
    protected Timestamp time;



    public TestBean(float data, Timestamp time) {
        this.data = data;
        this.time = time;
    }
}
