/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.thriftDemoProvider.service.impl;

import net.mamian.thriftDemoProvider.service.HelloWorldService;
import org.apache.thrift.TException;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-6 17:08:06
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {

    @Override
    public String sayHello(String username) throws TException {
        return "马面测试thrift调用是否成功。若您看到了此条信息，说明thrift调用成功。";
    }

    
}
