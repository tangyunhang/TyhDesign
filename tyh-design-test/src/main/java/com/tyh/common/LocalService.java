package com.tyh.common;

import com.tyh.interf.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description: LocalService
 * @Author: 青衣醉
 * @Date: 2023/4/28 4:34 下午
 */
@Service
@Slf4j
public class LocalService{
    private static final ThreadLocal currentUser = ThreadLocal.withInitial(() -> null);

    public void forward() {
        String s = Thread.currentThread ().getName () + ":" + currentUser.get ();
        System.out.println (s);
    }

    @Async("asyncServiceExecutor")
    public void executeAsync(){
        log.info("start executeAsync");

        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");

        log.info("end executeAsync");
    }

}
