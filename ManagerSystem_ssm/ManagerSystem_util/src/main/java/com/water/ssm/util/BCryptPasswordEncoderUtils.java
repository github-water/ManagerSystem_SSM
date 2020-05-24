package com.water.ssm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String passwordEncoder(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "water";
        System.out.println(passwordEncoder(password));
        //$2a$10$eyDqnuSlpTbyi8sJT27z8u2eeMokEd41M2iucoJabF1Uh5KawaKAC
    }
}
