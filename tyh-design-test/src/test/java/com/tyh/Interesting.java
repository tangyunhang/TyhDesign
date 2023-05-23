package com.tyh;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Interesting
 * @Author: 青衣醉
 * @Date: 2023/5/10 5:46 下午
 */

@Slf4j
public class Interesting {

    volatile int a = 1;
    volatile int b = 1;

    public  void add() {
        log.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public synchronized void compare() {
        log.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false吗？
            }
        }
        log.info("compare done");
    }
}