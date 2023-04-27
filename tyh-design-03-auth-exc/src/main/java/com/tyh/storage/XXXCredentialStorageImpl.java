package com.tyh.storage;

import java.util.HashMap;

/**
 * @Description: SysFileCredentialStorageImpl
 * @Author: 青衣醉
 * @Date: 2023/4/23 4:40 下午
 */
public class XXXCredentialStorageImpl implements CredentialStorage {
    private static HashMap<String,String> hashMap;

    static {
        hashMap = new HashMap ();
        hashMap.put ("tyh","222");
    }

    @Override
    public String getAppIdByPassword(String appid) {
        return hashMap.get (appid);
    }

}
