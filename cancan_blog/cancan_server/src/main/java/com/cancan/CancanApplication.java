package com.cancan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CancanApplication {
    public static void main(String[] args){
        SpringApplication.run(CancanApplication.class,args);
        log.info("服务已启动");
    }
}
