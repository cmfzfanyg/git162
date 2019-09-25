package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")  //指定该包并创建DAO实现类对象
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
