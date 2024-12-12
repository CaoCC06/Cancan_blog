package com.cancan.mapper;

import com.cancan.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {

    @Select("select id,username,password from sys_user where username=#{username}  and status=0 and del_flag=0")
    SysUser getByUsername(String username);
}
