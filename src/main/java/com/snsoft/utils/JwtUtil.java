package com.snsoft.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class JwtUtil {
    private final static Key key;//这里是加密解密的key。

    static {
        key = MacProvider.generateKey();
    }

    public static String getToken(String subject) {
        String compactJws = Jwts.builder()//返回的字符串便是我们的jwt串了
                .setSubject(subject)//设置主题
                .signWith(SignatureAlgorithm.HS512, key)//设置算法（必须）
                .compact();//这个是全部设置完成后拼成jwt串的方法
        return "Bearer " + compactJws;
    }

    public static boolean validateToken(String compactJws, String subject) {
        String str = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject();
        return str.equals(subject);
    }

    public void testJWT(String[] args) {
        String token = JwtUtil.getToken("001");
        System.out.println(token);
        boolean b = JwtUtil.validateToken(token, "001");
    }

}
