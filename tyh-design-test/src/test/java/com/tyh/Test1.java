package com.tyh;

import java.math.BigDecimal;

/**
 * @Description: Test1
 * @Author: 青衣醉
 * @Date: 2023/6/29 10:29 上午
 */
public class Test1 {

    public static void main(String[] args){
        BigDecimal decimal = BigDecimal.ZERO;
        BigDecimal decimal1 = null;

        System.out.println (decimal1 == null ? BigDecimal.ZERO : decimal1 );
    }
}
