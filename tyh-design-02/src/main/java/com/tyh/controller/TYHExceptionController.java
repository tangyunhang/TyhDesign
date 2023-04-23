package com.tyh.controller;

import com.tyh.exception.TYHException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

/**
 * @Description: TYHExceptionController
 * @Author: 青衣醉
 * @Date: 2023/4/21 2:32 下午
 */
@RestController
@RequestMapping("tyhExc")
public class TYHExceptionController {

    @GetMapping("get/{id}")
    public String getException(@PathVariable("id") int id){
        if(id==1){
            Assert.isNull ("ddd");
        }

        throw new TYHException ("tyhExc");
    }
}
