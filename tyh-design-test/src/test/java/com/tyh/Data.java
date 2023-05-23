package com.tyh;

import lombok.Getter;

/**
 * @Description: Data
 * @Author: 青衣醉
 * @Date: 2023/5/11 5:26 下午
 */
public class Data {
    @Getter
    private static int counter = 0;

    public static int reset() {
        counter = 0;
        return counter;
    }

    public synchronized void wrong() {
        counter++;
    }
}
