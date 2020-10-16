package com.jiao.chatonlineserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiao.chatonlineserver.repository")
public class ChatonlineServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatonlineServerApplication.class, args);
    }

}
