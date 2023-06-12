package com.tyh.ThreadLoacl;

import com.tyh.common.UserSession;

/**
 * @Description: SystemSession
 * @Author: 青衣醉
 * @Date: 2023/5/30 5:30 下午
 */
public class SystemSession {
    private static ThreadLocal<UserSession> local = new ThreadLocal<UserSession>();
    public static UserSession getSession() {
        return local.get();
    }
    public static void setSession(UserSession userSession) {
        local.set(userSession);
    }

    public static void removeSession() {
        local.remove ();
    }
}
