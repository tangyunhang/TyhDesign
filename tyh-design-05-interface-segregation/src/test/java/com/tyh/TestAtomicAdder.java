package com.tyh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description: TestAtomicAdder
 * @Author: 青衣醉
 * @Date: 2023/4/27 5:37 下午
 */
public class TestAtomicAdder {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(1000);

        final int NUM = 1000000;
        LongAdder cnt = new LongAdder();
        for (int i = 0; i < NUM; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    cnt.increment();
                }
            };
            service.execute(r);
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(cnt.longValue());
    }
}
