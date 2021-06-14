package com.example.boot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、导入依赖
 *      1）、导入dubbo-starter
 *      2）、导入dubbo的其他依赖
 * SpringBoot2 与 dubbo 整合的三种方式
 *      1）、导入dubbo-starter，在application.properties配置属性，使用@Service【暴露服务】使用@Refrence【引入服务】
 *      2）、保留dubbo的xml配置文件:
 *              导入dubbo-starter，使用@ImportResource导入dubbo的配置文件即可
 *      3）、使用注解API方式：创建 MyDubboConfig.java 进行配置
 *              将每一个注解手动注册到容器中
 */

//@EnableDubbo   // 开启基于注解的dubbo功能
//@ImportResource(locations = "classpath:provider.xml")
@EnableDubbo(scanBasePackages = "com.example.boot")
@SpringBootApplication
public class BootUserServiceProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
