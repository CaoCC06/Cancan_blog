package com.cancan.controller;

import com.cancan.entity.SysUser;
import com.cancan.result.Result;
import com.cancan.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
@Api(tags = "登录接口")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Result login(@RequestBody SysUser user){
        return Result.success(loginService.login(user));
    }

    @RequestMapping ("/userLogout")
    public Result logout(){
        log.info("===========正在登出==========");
        loginService.logout();
        return Result.success("登出成功");
    }
}
