package com.tyh.configuration;

import com.tyh.configuration.interf.Updater;
import com.tyh.source.ConfigSource;

/**
 * @Description: RedisConfig配置中心
 * @Author: 青衣醉
 * @Date: 2023/4/27 2:04 下午
 */
public class RedisConfig implements Updater {
    private ConfigSource configSource;
    //配置中心（比如zookeeper）
    private String address;
    private int timeout;
    private int maxTotal;
    private int maxWaitMillis;
    private int maxIdle;
    private int minIdle;
    public RedisConfig(ConfigSource configSource){
        this.configSource = configSource;
    }
    private String getAddress() {
        return address;
    }

    @Override
    public void update() {
        System.out.println ("更新RedisConfig配置");
    }
}
