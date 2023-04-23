package com.tyh.common;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;

/**
 * @Description: AliyunImageStore
 * @Author: 青衣醉
 * @Date: 2023/4/19 5:50 下午
 */
@Slf4j
public class AliyunImageStore implements ImageStore {
    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        String accessToken = generateAccessToken();
        //...上传图片到阿里云... //...返回图片在阿里云上的地址(url)...
        log.info ("上传图片到阿里云");
        return accessToken;
    }

    @Override
    public Image download(String url) {
        return null;
    }

    private void createBucketIfNotExisting(String bucketName) {
        // ...创建bucket...
        // ...失败会抛出异常..

        }
    private String generateAccessToken() {
    // ...根据accesskey/secrectkey等生成access token
     return null;
    }
}
