package net.mamian.thriftDemoProvider.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import net.mamian.thriftDemoProvider.service.HelloWorldService;
import net.mamian.thriftDemoProvider.service.impl.HelloWorldServiceImpl;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 10:43:36
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
@Configuration
public class ThriftConfig {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    @Bean
    public TServerTransport tServerTransport() {
        try {
            return new TServerSocket(7911);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public TServer tServer() {
        //发布服务
        HelloWorldService.Processor processor = new HelloWorldService.Processor(
                new HelloWorldServiceImpl());
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(
                tServerTransport()).processor(processor));
        return server;
    }

    @PostConstruct
    public void init() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tServer().serve();
            }
        });
    }

}
