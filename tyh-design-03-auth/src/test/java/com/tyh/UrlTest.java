package com.tyh;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * @Description: UrlTest
 * @Author: 青衣醉
 * @Date: 2023/4/23 3:37 下午
 */
public class UrlTest {
    public static void main(String[] args) {
        String urlString = "https://www.example.com/path/to/resource?appId=tyh1&passWord=value2#fragment";
        getOriginalUrl();
    }
    @Test
    public static void getOriginalUrl(){
        HashMap params = new HashMap ();
        long currentTimeMillis = System.currentTimeMillis ();
        String url = "https://www.example.com/path/to/resource/";
        params.put ("appId", "tyh");
        params.put ("timeTamp",currentTimeMillis);
        params.put ("password","222");

        AuthToken serverAuthToken = AuthToken.create (url, params);
        StringBuilder sb = new StringBuilder ("https://www.example.com/path/to/resource/");

        ApiAuthenticatorImpl apiAuthenticator = new ApiAuthenticatorImpl (new XXXCredentialStorageImpl ());
        String s = sb.append ("?")
                .append ("appId")
                .append ("=")
                .append ("tyh")
                .append ("&")
                .append ("token")
                .append ("=")
                .append (serverAuthToken.getToken ())
                .append ("&")
                .append ("timeTamp")
                .append ("=")
                .append (currentTimeMillis).toString ();

        apiAuthenticator.auth (url);

    }
}
