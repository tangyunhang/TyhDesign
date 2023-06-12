package com.tyh.filter;


import com.tyh.ThreadLoacl.SystemSession;
import com.tyh.ThreadLoacl.SystemSession2;
import com.tyh.common.UserSession;
import org.apache.catalina.connector.RequestFacade;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Description: SystemFilter
 * @Author: 青衣醉
 * @Date: 2023/5/30 5:51 下午
 */
@WebFilter
public class SystemFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException(request + " not HttpServletRequest");
        }
        if (!(response instanceof HttpServletResponse)) {
            throw new ServletException(request + " not HttpServletResponse");
        }
        if(null!= SystemSession.getSession ()){
            SystemSession.removeSession ();
            SystemSession2.removeSession ();
        }
        UserSession userSession = UserSession.builder ()
                .name (((RequestFacade) request).getHeader ("userName"))
                .password (((RequestFacade) request).getHeader ("password"))
                .build ();
        SystemSession.setSession (userSession);
        SystemSession2.init(String.valueOf (Math.random ()),userSession);
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }
}
