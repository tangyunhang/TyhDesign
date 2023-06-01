package com.tyh.common;

import com.tyh.ioc.ClassA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: LocalController
 * @Author: 青衣醉
 * @Date: 2023/4/28 4:31 下午
 */
@RestController
@RequestMapping(value = "/list")
public class LocalController {


    private static final ThreadLocal currentUser = ThreadLocal.withInitial(() -> null);

    @Autowired
    private LocalService localService;

 /*   @Autowired
    public LocalController(LocalService localService) {
        this.localService = localService;
    }*/

    @RequestMapping(value = "/local")
    public String local() {
        String s = Thread.currentThread ().getName () + ":" + currentUser.get ();
        currentUser.set("local");
        System.out.println (currentUser.get ());
        String s1 = Thread.currentThread ().getName () + ":" + currentUser.get ();
         localService.executeAsync();
        return s+"/n"+s1;
    }

    public static void main(String[] args) {
        // 创建多个线程并启动
        Thread thread1 = new Thread(() -> {
            // 线程1独立地访问和修改自己的对象副本
            ClassA classA = new ClassA ();
            classA.setInteger (1);
            System.out.println("Thread 1 Count: " + classA.getInteger ()); // 输出: Thread 1 Count: 1
        });

        Thread thread2 = new Thread(() -> {
            // 线程2独立地访问和修改自己的对象副本
            // 线程1独立地访问和修改自己的对象副本
            ClassA classA = new ClassA ();
            //classA.setInteger (1);
            System.out.println("Thread 2 Count: " + classA.getInteger ()); // 输出: Thread 2 Count: 1
        });

        thread1.start();
        thread2.start();
    }
}
