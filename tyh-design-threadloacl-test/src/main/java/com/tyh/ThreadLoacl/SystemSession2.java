package com.tyh.ThreadLoacl;

import com.tyh.common.UserSession;

/**
 * @Description: SystemSession
 * @Author: 青衣醉
 * @Date: 2023/5/30 5:30 下午
 */

public class SystemSession2 {
    private String sessionId;
    private UserSession userSession;
    private static ThreadLocal<SystemSession2> local = new ThreadLocal<SystemSession2>(){
        protected SystemSession2 initialValue() {
            return new SystemSession2 ();
        }
    };


    public static SystemSession2 init(String sessionId,UserSession userSession){
        SystemSession2 systemSession2 = getSystemSession();
        systemSession2.sessionId=sessionId;
        systemSession2.userSession = userSession;
        return systemSession2;
    }
    public static SystemSession2 getSystemSession() {
        return local.get();
    }
    public static void removeSession() {
        local.remove ();
    }
    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
    public UserSession getUserSession() {
        return userSession;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}