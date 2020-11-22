package com.erp.common.security.jwt;

import com.erp.common.security.entity.SysUserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * JWT工具类
 *
 * @author Administrator
 */
@Slf4j
public class JwtTokenUtil {

    /**
     * 私有化构造器
     */
    private JwtTokenUtil() {
    }

    /**
     * 生成Token
     *
     * @Param selfUserEntity 用户安全实体
     * @Return Token
     */
    public static String createAccessToken(SysUserDetails sysUserDetails) throws JsonProcessingException {
        // 登陆成功生成JWT
        String token = Jwts.builder()
                // 放入用户名和用户ID
                .setId(sysUserDetails.getId().toString())
                // 主题
                .setSubject(sysUserDetails.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("wt")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", new ObjectMapper().writeValueAsString(sysUserDetails.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JwtConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JwtConfig.secret)
                .compact();
        return token;
    }


}