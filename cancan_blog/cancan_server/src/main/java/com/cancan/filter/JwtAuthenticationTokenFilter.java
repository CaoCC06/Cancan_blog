package com.cancan.filter;

import com.cancan.LoginUser;
import com.cancan.properties.JwtProperties;
import com.cancan.utils.JwtUtil;
import com.cancan.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String id = null;
        try {
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            id = claims.get("id").toString();
        } catch (Exception e) {
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String redisKey = "user:"+id;
        LoginUser loginUser = (LoginUser) redisUtil.getObjectValue(redisKey);
        if (Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        //权限认证，获取权限信息封装到usernamePasswordAuthenticationToken中
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request,response);
    }
}
