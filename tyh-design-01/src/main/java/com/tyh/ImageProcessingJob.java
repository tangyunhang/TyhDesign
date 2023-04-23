package com.tyh;

import com.tyh.common.AliyunImageStore;
import com.tyh.common.ImageStore;
import com.tyh.common.PrivateImageStore;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

/**
 * @Description: ImageProcessingJob
 * @Author: 青衣醉
 * @Date: 2023/4/19 5:54 下午
 */
public class ImageProcessingJob {

    @Autowired
    ImageStore imageStore;
    private static final String BUCKET_NAME = "ai_images_bucket";
    //...省略其他无关代码...
    public void process() {
        Image image = null;
        //处理图片，并封装为Image对象
        imageStore.upload(image, BUCKET_NAME); }

}
