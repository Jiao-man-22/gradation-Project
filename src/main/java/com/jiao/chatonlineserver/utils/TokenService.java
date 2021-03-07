package com.jiao.chatonlineserver.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * 用户登陆验证
 * */
public class TokenService {
    //设置token过期时间
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60;
    //token密钥
    private static final String TOKEN_SECRET = "SHOIDAHOHDHOASHDOA";
    //得到token
    public static String returnToken(String username, String password) {
        try {

            String token = "";
            Date expire_date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //加秘密钥
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<String, Object>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带 用户信息生成新的签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .sign(algorithm);
            return token;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return "token创建失败";
    }

    /*
    @param String token
    @return String token */
    public static boolean verify(String token){
        //要求一个密钥
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    }
