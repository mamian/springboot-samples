package net.mamian.thriftDemoConsumer.service.provider;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import net.mamian.thriftDemoConsumer.config.ZooKeeperConfig;
import net.mamian.thriftDemoConsumer.service.HelloWorldService;

@Component
public class HelloWorldServiceProvider {

    public HelloWorldService.Client getBalanceUserService() {
        Map<String, HelloWorldService.Client> serviceMap = ZooKeeperConfig.serviceMap;
        //以负载均衡的方式获取服务实例		
        for (Map.Entry<String, HelloWorldService.Client> entry : serviceMap.entrySet()) {
            System.out.println("可供选择服务:" + entry.getKey());
        }
        int rand = new Random().nextInt(serviceMap.size());
        String[] mkeys = serviceMap.keySet().toArray(new String[serviceMap.size()]);
        return serviceMap.get(mkeys[rand]);
    }

}
