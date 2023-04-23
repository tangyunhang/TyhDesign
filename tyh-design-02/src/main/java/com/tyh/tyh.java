package com.tyh;

import com.tyh.interf.tyh01;
import com.tyh.interf.tyh02;

/**
 * @Description: tyh
 * @Author: 青衣醉
 * @Date: 2023/4/20 3:08 下午
 *
 */
public class tyh implements tyh01 , tyh02 {
    @Override
    public void t2() {
        System.out.println ("说调用t2");
    }

    @Override
    public void t1() {
    }

    @Override
    public void defaultMethod() {

    }

}
