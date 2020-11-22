package com.erp.common.security.handler;

import com.erp.common.security.entity.SysUserDetails;
import com.erp.common.security.impl.SysUserDetailsServiceImpl;
import com.erp.common.security.jwt.JwtConfig;
import com.erp.common.security.jwt.JwtTokenUtil;
import com.erp.common.util.ResultUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * 登录成功处理类
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final SysUserDetailsServiceImpl sysUserDetailsServiceImpl;

    public UserLoginSuccessHandler(SysUserDetailsServiceImpl sysUserDetailsServiceImpl) {
        this.sysUserDetailsServiceImpl = sysUserDetailsServiceImpl;
    }

    /**
     * 登录成功返回结果
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws JsonProcessingException {

        response.addHeader("Access-Control-Allow-Origin", "*");

        SysUserDetails sysUserDetails = (SysUserDetails) authentication.getPrincipal();
        String token = JwtTokenUtil.createAccessToken(sysUserDetails);

        token = JwtConfig.tokenPrefix + token;
        // 封装返回参数
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("success", true);
        resultData.put("code", 200);
        resultData.put("msg", "登录成功");
        resultData.put("token", token);
        resultData.put("userInfo", sysUserDetails);
        ResultUtil.responseJson(response, resultData);
    }
}