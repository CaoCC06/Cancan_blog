package com.cancan.service.impl;

import com.cancan.LoginUser;
import com.cancan.entity.User;
import com.cancan.properties.JwtProperties;
import com.cancan.service.LoginService;
import com.cancan.utils.JwtUtil;
import com.cancan.utils.RedisUtil;
import com.cancan.vo.LoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 用户登录
     * @param user
     * @return
     */
    public LoginVO login(User user) {
        //使用authenticationManager.authenticate进行用户验证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        //通过认证后，生成根据id 生成令牌JWT
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", loginUser.getUser().getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
        LoginVO loginVO = new LoginVO();
        BeanUtils.copyProperties(loginUser.getUser(),loginVO);
        loginVO.setToken(token);
        //将用户信息存入redis
        redisUtil.setObjectValue("user:" + loginUser.getUser().getId(), loginUser);
        // 设置缓存过期时间为1小时（3600秒）
        redisUtil.setExpire("user:" + loginUser.getUser().getId(), 3600);
        return loginVO;
    }

    /**
     * 用户退出
     */
    public void logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        if (Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        Long id = loginUser.getUser().getId();
        //删除Redis中的值
        redisUtil.delete("user:"+id);
    }
}
