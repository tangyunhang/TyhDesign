package com.tyh;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Description: Atomic
 * @Author: 青衣醉
 * @Date: 2023/5/9 5:11 下午
 */
public class Atomic {
    @Test
    public void template(){
        /*ForkJoinPool forkJoin = new ForkJoinPool(10);
        ConcurrentHashMap freqs = new ConcurrentHashMap<> (10);
        AtomicInteger atomicInteger = new AtomicInteger(0); // 创建AtomicInteger对象，初始化值为0
        final int[] integer = {0}; // 创建int类型变量，初始化值为0
        forkJoin.execute (()->{
            System.out.println (Thread.currentThread().getName()+"i= " + integer[0]);
            integer[0] = integer[0] + 1;
            System.out.println (Thread.currentThread().getName()+"i= " + integer[0]);
        });
        forkJoin.execute (()->{
            integer[0] = integer[0] + 1;
        });
        //IntStream.rangeClosed (1,10).forEach(i->integer[0]++);
        forkJoin.shutdownNow ();
        System.out.println ("integer="+integer[0]);*/
        System.out.println ("ffffffffffffffffffffffffffffffffffffffffffffffff");
    }
}
