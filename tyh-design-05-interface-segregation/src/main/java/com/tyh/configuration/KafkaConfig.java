package com.tyh.configuration;

import com.tyh.configuration.interf.Updater;
import com.tyh.configuration.interf.Viewer;
import com.tyh.source.ConfigSource;

import java.util.Map;

/**
 * @Description: KafkaConfig配置中心
 * @Author: 青衣醉
 * @Date: 2023/4/27 2:04 下午
 */
public class KafkaConfig implements Updater , Viewer {
    private ConfigSource configSource;
    //配置中心（比如zookeeper）
    private String address;
    private int timeout;
    private int maxTotal;
    private int maxWaitMillis;
    private int maxIdle;
    private int minIdle;
    public KafkaConfig(ConfigSource configSource){
        this.configSource = configSource;
    }
    private String getAddress() {
        return address;
    }

    @Override
    public void update() {
        System.out.println ("更新kafkaConfig配置");
    }

    @Override
    public String outputInPlainText() {
        System.out.println ("输出kafkaConfig配置");
        return "输出kafkaConfig配置";
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
