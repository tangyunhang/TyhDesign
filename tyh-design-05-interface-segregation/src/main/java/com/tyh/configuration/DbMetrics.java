package com.tyh.configuration;

import com.tyh.configuration.interf.Viewer;

import java.util.Map;

/**
 * @Description: DbMetrics 数据库性能统计模块
 * @Author: 青衣醉
 * @Date: 2023/4/27 4:57 下午
 */
public class DbMetrics implements Viewer {
    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
