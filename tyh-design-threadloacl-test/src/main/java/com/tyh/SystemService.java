package com.tyh;

import com.tyh.ThreadLoacl.SystemSession;
import com.tyh.common.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: SystemService
 * @Author: 青衣醉
 * @Date: 2023/5/31 10:32 上午
 */
@Service
@Slf4j
public class SystemService {

    public void sayHello() {
        UserSession userSession = SystemSession.getUserSession ();
        log.info (Thread.currentThread ().getName ()+"sayHello="+userSession.getName ()+":"+userSession.getPassword ());

        userSession.setPassword (userSession.getPassword()+"dsdsds");
        UserSession userSession2 = SystemSession.getUserSession ();
        log.info (Thread.currentThread ().getName ()+"sayHello="+userSession2.getName ()+":"+userSession2.getPassword ());
    }
}
