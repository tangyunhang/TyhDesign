package com.tyh;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Value;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: AuthToken
 * @Author: 青衣醉
 * @Date: 2023/4/23 2:26 下午
 */
public class AuthToken {
    private static final long EXPIRE_TIME_INTERVAL = 1*60*1000;
    private static final String SPLIT = "&";
    //附加超时可配
    @Value ("${tyh.auth.outTime}")
    private Long outTime;
    private String token;
    private long createTime;
    private long  expireTimeInterval = outTime!= null?outTime:EXPIRE_TIME_INTERVAL;

    public AuthToken(String token,long createTime){
        this.token = token;
        this.createTime= createTime;
    }

    public AuthToken(String token,long createTime,long expireTimeInterval){
        this.token = token;
        this.createTime= createTime;
        this.expireTimeInterval = expireTimeInterval;
    }

    public static AuthToken create(String url, Map<String, Object> map){
        StringBuilder sb = new StringBuilder (url);
         map.entrySet ().forEach (mp->{
             sb.append (SPLIT).append (mp.getKey ()).append (mp.getValue ());
         });
        System.out.println ("url="+sb.toString ());
         String token = MD5Utils.md5 (sb.toString ());
         return new AuthToken (token,(long)map.get ("timeTamp"));
    }

    public String getToken(){
        return this.token;
    }

    public boolean isExpired(){
        return System.currentTimeMillis ()>createTime+expireTimeInterval;
    }

    public boolean match(AuthToken authToken){
        return this.token.equals (authToken.getToken ());
    }
}
