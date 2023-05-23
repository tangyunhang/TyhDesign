package com.tyh;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @Description: WrongData
 * @Author: 青衣醉
 * @Date: 2023/5/11 5:25 下午
 */
@Slf4j
public class WrongData {

    @Test
    public void wrong() {
        System.out.println ("Counter="+Data.getCounter());

        Data.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, 1000000).parallel().forEach(i -> new Data().wrong());

        System.out.println ("Counter="+Data.getCounter());

        Data data = new Data ();
        //多线程循环一定次数调用Data类不同实例的wrong方法
       /* IntStream.rangeClosed(1, 1000000).parallel().forEach(i -> data.wrong());
        System.out.println ("Counter2="+Data.getCounter());*/
    }
}
