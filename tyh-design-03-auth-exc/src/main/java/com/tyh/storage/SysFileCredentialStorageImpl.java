package com.tyh.storage;

import java.io.*;

/**
 * @Description: SysFileCredentialStorageImpl
 * @Author: 青衣醉
 * @Date: 2023/4/23 4:40 下午
 */
public class SysFileCredentialStorageImpl implements CredentialStorage {

    @Override
    public String getAppIdByPassword(String appid) {
        File file = new File ("/Users/tangyunhang/Studying/TyhDesign/tyh-design-03-auth/src/main/resources/authAppIdPass");
        try(InputStreamReader reader = new InputStreamReader (new FileInputStream (file),"GBK")) {
        //  try(InputStreamReader reader = new InputStreamReader (new FileInputStream)
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return null;
    }

}
