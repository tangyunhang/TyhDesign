package com.tyh;

import com.tyh.common.ImageStore;
import lombok.SneakyThrows;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

/**
 * @Description: ImageController
 * @Author: 青衣醉
 * @Date: 2023/4/19 6:00 下午
 */
@Controller
@RequestMapping("image")
public class ImageController {
    private static final String BUCKET_NAME = "ai_images_bucket";
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ImageStore imageStore;

    @Autowired
    private ApplicationContext applicationContext;

    @Value ("${tyh.imageStore}")
    private String imageStoreName;
    @Autowired
    private BeanFactory beanFactory;

    /**
     * 通过spring依赖注入，在ImageStoreConfig，创建bean时，控制存储位置
     **/
    @GetMapping("upLoad")
    public void upLoadImage(){
        Image image = null;
        //处理图片，并封装为Image对象
        imageStore.upload(image, BUCKET_NAME);
    }

    /**
     * 通过配置文件，+ 反射
     **/
    @SneakyThrows
    @GetMapping("upLoad2")
    public void upLoadImage2(){
        ImageStore bean = (ImageStore) Class.forName (imageStoreName).newInstance ();
        Image image = null;
        //处理图片，并封装为Image对象
        bean.upload(image, BUCKET_NAME);
    }
}
