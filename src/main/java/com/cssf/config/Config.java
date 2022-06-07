package com.cssf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther:Fluke Kuang
 * @Date: 2022/5/10 - 05 -10 - 19:36
 * @Description: com.cssf.config
 * @Version: 1.0
 */
@Component
public class Config {
    public static int serverPort;
    @Value("8080")
    public void setStationPort(int stationPort){
        Config.serverPort = stationPort;
    }
}
