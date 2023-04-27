package com.tyh.openicator;


import com.tyh.api.ApiRequest;

public interface ApiAuthenticator {
    public void  auth(String url);
    public void  auth(ApiRequest apiRequest);
}
