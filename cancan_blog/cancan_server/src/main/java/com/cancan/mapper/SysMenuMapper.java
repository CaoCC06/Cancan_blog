package com.cancan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    List<String> getPermsByUserId(Long userId);
}
