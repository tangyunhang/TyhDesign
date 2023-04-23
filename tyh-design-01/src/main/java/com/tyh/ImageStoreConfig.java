package com.tyh;

import com.tyh.common.AliyunImageStore;
import com.tyh.common.ImageStore;
import com.tyh.common.PrivateImageStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: ImageStoreConfig
 * @Author: 青衣醉
 * @Date: 2023/4/19 5:58 下午
 */
@Configuration
public class ImageStoreConfig {

    @Bean
     public ImageStore imageStore (){
        return new AliyunImageStore ();
    }
}
