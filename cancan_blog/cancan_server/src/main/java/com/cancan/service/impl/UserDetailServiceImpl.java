package com.cancan.service.impl;

import com.cancan.LoginUser;
import com.cancan.entity.SysUser;
import com.cancan.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("验证用户");
        //查询用户信息
        SysUser sysUser = userMapper.getByUsername(username);
        //没有查到用户则抛出异常
        if (Objects.isNull(sysUser)){
            log.info("用户名或密码错误");
            throw new RuntimeException("用户名或密码错误");
        }
        //将数据封装成UserDetails
        return new LoginUser(sysUser);
    }
}
