package com.cancan.SecurityTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class BCryptPasswordTest {
    @Test
    public void testBCryptPassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("CZC15271758136cc");
        System.out.println(encode);
        System.out.println(encode2);
        System.out.println(passwordEncoder.matches("123456",encode));
    }
}
