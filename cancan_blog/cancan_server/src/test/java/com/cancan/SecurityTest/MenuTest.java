package com.cancan.SecurityTest;

import com.cancan.mapper.SysMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuTest {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Test
    public void testgetPermsByUserId(){
        List<String> list = sysMenuMapper.getPermsByUserId(1L);
        System.out.println(list);
    }


}
