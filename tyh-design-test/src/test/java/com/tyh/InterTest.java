package com.tyh;

import java.util.concurrent.ForkJoinPool;

/**
 * @Description: InterTest
 * @Author: 青衣醉
 * @Date: 2023/5/10 5:47 下午
 */
public class InterTest {

    public static void main(String[] args){
        while (true) {
            main1();
        }

    }


    public static void main1(){
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }
}
