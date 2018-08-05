package com.pack.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密"0"
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        //结果：$2a$10$fUpQLw90.USzI.jHNuH8WueM21s52s.7fEXiEW3Fy/hThKf5jXrmW
    }


}
