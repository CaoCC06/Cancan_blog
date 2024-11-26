package com.cancan.controller;

import com.cancan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags = "测试接口")
public class LinkTestController {
    @GetMapping
    @ApiOperation("测试前后端连接")
    public Result link(){
        log.info("前后端成功连接");
        return Result.success("前后端成功连接");
    }
}
