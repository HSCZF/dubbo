package com.example.boot.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.bean.UserAddress;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心(暴露服务)
 * 1）、导入dubbo依赖(2.6.2) \操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */

@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired
    // 远程服务使用 @Reference
    @Reference(url = "127.0.0.1:20880") // dubbo 直连
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        // 1.查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        /*for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }*/

        return addressList;
    }
}
