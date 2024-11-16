package com.cancan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linktest")
@Slf4j
public class LinkTestController {
    @GetMapping
    public void link(){
        log.info("成功连接");
    }
}
