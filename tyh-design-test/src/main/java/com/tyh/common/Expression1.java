package com.tyh.common;

/**
 * @Description: Expression1
 * @Author: 青衣醉
 * @Date: 2023/5/22 1:46 下午
 */
public class Expression1 {

    public static void withdrawMoney(double amount) throws InsufficientBalanceException {
        double balance = 0;
        if (amount > balance) {
            throw new InsufficientBalanceException("余额不足");
        }
        // 执行取款操作
    }

    public static void main(String[] args) {
        try {
            withdrawMoney(1);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace ();
        }
    }
}
