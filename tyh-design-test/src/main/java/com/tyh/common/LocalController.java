package com.tyh.common;

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
}
