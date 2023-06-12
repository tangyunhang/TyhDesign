package com.tyh.concurrent;

import com.tyh.exec.VisiableThreadPoolTaskExecutor;
import com.tyh.properties.ExecutorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @Description: Executors
 * @Author: 青衣醉
 * @Date: 2023/6/12 4:10 下午
 */
public class Executors {

    @Autowired
    private ExecutorProperties properties;

    public static ThreadPoolTaskExecutor newFixedThreadPool() {
        VisiableThreadPoolTaskExecutor taskExecutor = new VisiableThreadPoolTaskExecutor ();
        return taskExecutor;
    }

    public static ThreadPoolTaskExecutor newFixedThreadPool(int corePoolSize) {
        VisiableThreadPoolTaskExecutor taskExecutor = new VisiableThreadPoolTaskExecutor ();
        taskExecutor.setCorePoolSize (corePoolSize);
        return taskExecutor;
    }

    public static ThreadPoolTaskExecutor newFixedThreadPool(ThreadFactory threadFactory) {
        VisiableThreadPoolTaskExecutor taskExecutor = new VisiableThreadPoolTaskExecutor ();
        taskExecutor.setThreadFactory (threadFactory);
        return taskExecutor;
    }

    public static ThreadPoolTaskExecutor newFixedThreadPool(int corePoolSize,ThreadFactory threadFactory) {
        VisiableThreadPoolTaskExecutor taskExecutor = new VisiableThreadPoolTaskExecutor ();
        taskExecutor.setCorePoolSize (corePoolSize);
        taskExecutor.setThreadFactory (threadFactory);
        return taskExecutor;
    }

    public static  ThreadPoolTaskExecutor newFixedThreadPool(int corePoolSize,int maxPoolSize,int queueCapacity,
                                                     String namePrefix, int keepAliveTime,boolean isAllowCoreThreadTimeOut,
                                                     ThreadFactory threadFactory,RejectedExecutionHandler rejectedExecutionHandler) {
        VisiableThreadPoolTaskExecutor taskExecutor = new VisiableThreadPoolTaskExecutor ();
        //配置核心线程数
        taskExecutor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        taskExecutor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        taskExecutor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        taskExecutor.setThreadNamePrefix(namePrefix);

        taskExecutor.setKeepAliveSeconds (keepAliveTime);

        taskExecutor.setAllowCoreThreadTimeOut (isAllowCoreThreadTimeOut);

        taskExecutor.setThreadFactory (threadFactory);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        taskExecutor.setRejectedExecutionHandler(rejectedExecutionHandler!= null? rejectedExecutionHandler: new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        taskExecutor.initialize();
        return taskExecutor;
    }


}
