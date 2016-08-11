/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.thriftDemoConsumer.controllers;

import lombok.extern.slf4j.Slf4j;
import net.mamian.thriftDemoConsumer.common.ResponseCode;
import net.mamian.thriftDemoConsumer.common.RestResponse;
import net.mamian.thriftDemoConsumer.service.HelloWorldService;
import net.mamian.thriftDemoConsumer.service.provider.HelloWorldServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户api接口层
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:45
 * @copyright ©2016 马面 All Rights Reserved
 */
@Slf4j
@Controller
public class HomeController {
    
    @Autowired
    private HelloWorldServiceProvider helloWorldServiceProvider;
    
    /**
     * 查找用户的订单
     * @return 
     */
    @RequestMapping(value="/thrift", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse listOrder() {
        RestResponse result = new RestResponse();
        try {
            HelloWorldService.Client svr=helloWorldServiceProvider.getBalanceUserService();
            String userDto= svr.sayHello("马面");
            return result.success(userDto);
        } catch (Exception ex) {
            log.debug("payment error when list order: {}", ex.toString());
            return result.error(ResponseCode.ERROR_UNKNOW);
        }
    }

}
