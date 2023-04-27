package com.tyh.taskServer;

import com.tyh.configuration.interf.Viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: SimpleHttpServer,http服务
 * @Author: 青衣醉
 * @Date: 2023/4/27 3:29 下午
 */
public class SimpleHttpServer {
    private int port;
    private String host;
    private Map<String, List<Viewer>> viewrs = new HashMap<String, List<Viewer>> ();

    public SimpleHttpServer(String host,int port) {
        this.port = port;
        this.host = host;
    }

    public void addViewer(String url,Viewer viewer) {
        if (!viewrs.containsKey (url)) {
            viewrs.put (url, new ArrayList<> ());
        }
        this.viewrs.get (url).add (viewer);
    }

    public void run(){
        viewrs.entrySet ().forEach (entry ->{
            String key = entry.getKey ();
            entry.getValue ().forEach (value ->{
                StringBuilder sb = new StringBuilder();
                sb.append ("http://")
                        .append (host)
                        .append (":")
                        .append (port)
                        .append (key)
                        .append (value.outputInPlainText ());
                System.out.println (sb.toString ());
            });
        });
    }
}
