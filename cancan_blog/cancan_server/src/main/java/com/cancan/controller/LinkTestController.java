package com.cancan.controller;

import com.cancan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping
    @ApiOperation("测试post连接")
    public Result postLink(@RequestBody Map<String ,Object> map){
        log.info("name:"+map.get("name"));
        log.info("age:"+map.get("age"));
        return Result.success(map);
    }
}
