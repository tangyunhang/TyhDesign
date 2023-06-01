package com.tyh.controller;

import com.tyh.SystemService;
import com.tyh.ThreadLoacl.SystemSession;
import com.tyh.common.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: SystemController
 * @Author: 青衣醉
 * @Date: 2023/5/30 5:33 下午
 */
@Controller
@RequestMapping("/system")
@Slf4j
public class SystemController {

    @Autowired
    SystemService systemService;

    @GetMapping("/login")
    public String Longin(HttpServletRequest httpServletRequest){
        UserSession userSession = SystemSession.getUserSession ();
            new Thread ();
        log.info (Thread.currentThread ().getName ()+"Longin="+userSession.getName () + ":" + userSession.getPassword ());
        systemService.sayHello ();
        return "system/login";
    }
    @RequestMapping("time")

    public String context(HttpServletRequest httpServletRequest){
        return "system/time";
    }
}
