package com.tyh.config;

import com.tyh.exec.VisiableThreadPoolTaskExecutor;
import com.tyh.properties.ExecutorProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: ExecutorConfig
 * @Author: 青衣醉
 * @Date: 2023/5/23 10:49 上午
 */
@Configuration
@EnableAsync
@EnableConfigurationProperties(ExecutorProperties.class)
@Slf4j
public class ExecutorConfiguration {

    @Autowired
    private ExecutorProperties properties;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor ();
        //配置核心线程数
        executor.setCorePoolSize(properties.getCorePoolSize ());
        //配置最大线程数
        executor.setMaxPoolSize(properties.getMaxPoolSize ());
        //配置队列大小
        executor.setQueueCapacity(properties.getQueueCapacity ());
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(properties.getNamePrefix ());

        executor.setKeepAliveSeconds (properties.getKeepAliveTime ());

        executor.setAllowCoreThreadTimeOut (properties.isAllowCoreThreadTimeOut ());

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
