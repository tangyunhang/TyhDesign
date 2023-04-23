package com.tyh;


public interface ApiAuthenticator {
    public void  auth(String url);
    public void  auth(ApiRequest apiRequest);
}
