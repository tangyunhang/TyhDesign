package com.tyh.common;

/**
 * @Description: InsufficientBalanceException
 * @Author: 青衣醉
 * @Date: 2023/5/22 1:47 下午
 */
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message){
        super(message);
    }
}
