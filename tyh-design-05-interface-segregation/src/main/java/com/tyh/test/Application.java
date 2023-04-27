package com.tyh.test;

import com.tyh.configuration.KafkaConfig;
import com.tyh.configuration.MysqlConfig;
import com.tyh.configuration.RedisConfig;
import com.tyh.source.ConfigSource;
import com.tyh.source.ZookeeperConfigSource;
import com.tyh.taskServer.ScheduledUpdater;
import com.tyh.taskServer.SimpleHttpServer;

/**
 * @Description: Application
 * @Author: 青衣醉
 * @Date: 2023/4/27 2:49 下午
 */
public class Application {
    static ConfigSource configSource = new ZookeeperConfigSource ();
    private static final RedisConfig redisConfig = new RedisConfig (configSource);
    private static final MysqlConfig mysqlConfig = new MysqlConfig (configSource);
    private static final KafkaConfig kafkaConfig = new KafkaConfig (configSource);

    public static void main(String[] args) {
        ScheduledUpdater redisConfigServier
                = new ScheduledUpdater (30,30,redisConfig);
        //redisConfigServier.start ();

        ScheduledUpdater kafkaConfigServier
                = new ScheduledUpdater (30,30,kafkaConfig);
        //kafkaConfigServier.start ();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("172.0.0.1",2390);
        simpleHttpServer.addViewer ("/config",kafkaConfig);
        simpleHttpServer.addViewer ("/config",mysqlConfig);
        simpleHttpServer.run ();
    }
}
