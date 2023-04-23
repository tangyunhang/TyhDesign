package com.tyh;

import java.util.HashMap;

/**
 * @Description: ApiAuthenticatorImpl
 * @Author: 青衣醉
 * @Date: 2023/4/23 4:26 下午
 */
public class ApiAuthenticatorImpl implements ApiAuthenticator {

    private CredentialStorage credentialStorage;
    public ApiAuthenticatorImpl(){
        this.credentialStorage = new XXXCredentialStorageImpl ();
    }
    public ApiAuthenticatorImpl(CredentialStorage credentialStorage){
        this.credentialStorage = credentialStorage;
    }
    @Override
    public void auth(String url) {
         ApiRequest api = ApiRequest.createFromFullUrl (url);
        auth (api);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId ();
        String baseUrl = apiRequest.getBaseUrl ();
        String tonken = apiRequest.getTonken ();
        long timetemp = apiRequest.getTimetemp ();

        AuthToken clentAuthToken = new AuthToken (tonken,timetemp);
        String password = credentialStorage.getAppIdByPassword (appId);
        HashMap params = new HashMap ();
        params.put ("appId", apiRequest.getAppId ());
        params.put ("timeTamp", apiRequest.getTimetemp ());
        params.put ("password",password);

        AuthToken serverAuthToken = AuthToken.create (baseUrl, params);
        if (serverAuthToken.isExpired ()) {
            throw new RuntimeException("Token is expired.");
        }
        if (!serverAuthToken.match (clentAuthToken)){
            throw new RuntimeException("Token verfication failed.");
        }
    }
}
