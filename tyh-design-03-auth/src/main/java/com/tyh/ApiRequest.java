package com.tyh;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: ApiRequest
 * @Author: 青衣醉
 * @Date: 2023/4/23 2:54 下午
 */
public class ApiRequest {
    private String baseUrl;
    private String appId;
    private String token;
    private long timeTamp;

    public ApiRequest(String baseUrl,String appId,String token,long timeTamp){
        this.baseUrl =baseUrl;
        this.appId = appId;
        this.timeTamp = timeTamp;
        this.token = token;
    }
    public static ApiRequest createFromFullUrl(String url){
        String[] split = url.split ("\\?");
        if (split.length==1){
            throw new RuntimeException ("无效请求");
        }
        String baseUrl = split[0];
        Map<String, String> params = Arrays.stream (split[1].split ("&"))
                .map (m -> m.split ("="))
                .collect (Collectors.toMap (arr -> arr[0], arr -> arr[1]));
        String appId = params.get ("appId");
        String token = params.get ("token");
        long timeTamp = Long.valueOf (params.get ("timeTamp"));
        return new ApiRequest (baseUrl,appId,token,timeTamp);

    }
   public String getTonken (){
        return this.token;
    }
   public String getAppId(){
        return this.appId;
    }
    public String getBaseUrl(){
       return this.baseUrl;
    }
    public long getTimetemp(){
      return this.timeTamp;
    }

}
