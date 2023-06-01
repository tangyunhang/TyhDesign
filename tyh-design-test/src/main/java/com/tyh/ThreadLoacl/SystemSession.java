package com.tyh.ThreadLoacl;

/**
 * @Description: SystemSession
 * @Author: 青衣醉
 * @Date: 2023/5/30 5:30 下午
 */
public class SystemSession {
    private static ThreadLocal<UserSession> local = new ThreadLocal<UserSession>();
    public static UserSession getUserSession() {
        return local.get();
    }
    public static void setUserSession(UserSession userSession) {
        local.set(userSession);
    }
}
