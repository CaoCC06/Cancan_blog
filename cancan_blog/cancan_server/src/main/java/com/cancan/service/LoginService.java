package com.cancan.service;


import com.cancan.entity.User;
import com.cancan.vo.LoginVO;

public interface LoginService {
    LoginVO login(User user);


    void logout();
}
