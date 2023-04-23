package com.tyh.exception;

/**
 * @Description: TYHException
 * @Author: 青衣醉
 * @Date: 2023/4/21 2:31 下午
 */
public class TYHException extends RuntimeException{
    public TYHException(){
        super("lalalal");
    }
    public TYHException(String message){
            super("TYHException:"+ message);
    }
}
