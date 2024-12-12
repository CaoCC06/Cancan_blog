package com.cancan.service;


import com.cancan.entity.SysUser;
import com.cancan.vo.LoginVO;

public interface LoginService {
    LoginVO login(SysUser user);

    void logout();
}
