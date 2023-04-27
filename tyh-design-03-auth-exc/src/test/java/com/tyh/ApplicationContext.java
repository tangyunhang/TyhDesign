package com.tyh;

/**
 * @Description: ApplicationContext上下文测试
 * @Author: 青衣醉
 * @Date: 2023/4/24 3:01 下午
 */
public class ApplicationContext {
    private static final ApplicationContext instance = new ApplicationContext ();

    /**
     * @description:      的 attributes
     * @author: tangyunhang
     * @date: 2023/4/27 9:51 上午
     * @param: [点点滴滴]
     * @return:
     **/
    private ApplicationContext(){
        initializeBeans ();
    }
    public void initializeBeans() {
        System.out.println ("ddfffff");
    }

    public static ApplicationContext getInstance(){
        System.out.println ("ssssss");

        //获取当前路径下的所有文件
        return instance;
    }
}
