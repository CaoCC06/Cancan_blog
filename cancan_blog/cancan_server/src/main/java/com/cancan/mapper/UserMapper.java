package com.cancan.mapper;

import com.cancan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id,username,password,identity from user where username=#{username} and status=0 and deleted=0")
    User getByUsername(String username);
}
