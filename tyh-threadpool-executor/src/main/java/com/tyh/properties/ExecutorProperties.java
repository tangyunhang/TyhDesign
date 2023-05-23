package com.tyh.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: ExecutorProperties
 * @Author: 青衣醉
 * @Date: 2023/5/23 11:06 上午
 */
@Data
@ConfigurationProperties("async.executor.thread")
public class ExecutorProperties {
    //核心线程数
    private int corePoolSize;
    //最大线程数
    private int maxPoolSize;
    //队列大小
    private int queueCapacity;
    //线程池中的线程的名称前缀
    private String namePrefix;

}
