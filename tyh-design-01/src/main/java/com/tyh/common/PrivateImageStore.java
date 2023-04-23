package com.tyh.common;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;

/**
 * @Description: PrivateImageStore
 * @Author: 青衣醉
 * @Date: 2023/4/19 5:53 下午
 */
@Slf4j
public class PrivateImageStore implements ImageStore{
    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        //...上传图片到私有云...
        // ...返回图片的url...
        log.info ("上传图片到私有云");
        return null;
    }

    @Override
    public Image download(String url) {
        return null;
    }

    private void createBucketIfNotExisting(String bucketName) {
        // ...创建bucket...
        // ...失败会抛出异常..
    }
}
