package com.tyh;

/**
 * @Description: AtomicIntegerTest
 * @Author: 青衣醉
 * @Date: 2023/5/10 9:36 下午
 */
import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);
        int normalInt = 0;
        Atomic atomic1 = new Atomic ();
        atomic1.template ();
        Atomic atomic = new Atomic () {
            @Override
            public void template() {
                System.out.println ("dd");
            }
        };
        atomic.template ();
    }

}

