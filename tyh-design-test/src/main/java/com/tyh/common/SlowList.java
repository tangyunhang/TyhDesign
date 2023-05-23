package com.tyh.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Description: SlowList
 * @Author: 青衣醉
 * @Date: 2023/5/12 9:26 上午
 */
@Slf4j
@Controller
@RequestMapping("/slowList")
public class SlowList {

    private List<Integer> data = new ArrayList<> ();
    private int a = 0;

    //不涉及共享资源的慢方法
    private void slow() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    //错误的加锁方法
    @GetMapping("wrong")
    public Integer wrong() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            //加锁粒度太粗了
            synchronized (this) {
                slow();
                data.add(i);
            }
        });
        log.info("took:{}", System.currentTimeMillis() - begin);
        return data.size();
    }
    //错误的加锁方法
    @GetMapping("obj")
    public Integer obj() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            synchronized (this) {
                slow();
                a = a++;
            }
        });
        log.info("took:{}", System.currentTimeMillis() - begin);
        return data.size();
    }


    //正确的加锁方法
    @GetMapping("right")
    public Integer right() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            slow();
            //只对List加锁
            synchronized (data) {
                data.add(i);
            }
        });
        log.info("{},took:{}", Thread.currentThread ().getName (), System.currentTimeMillis() - begin);
        return data.size();
    }

}
