package com.erp.common.security.handler;

import com.erp.common.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @Description 登录失败处理类
 */
@Slf4j
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {
    /**
     * 登录失败返回结果
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
        // 这些对于操作的处理类可以根据不同异常进行不同处理
        if (exception instanceof UsernameNotFoundException){
            log.info("【登录失败】"+exception.getMessage());
            ResultUtil.responseJson(response,ResultUtil.resultCode(false,"账号不存在"));
        }
        if (exception instanceof LockedException){
            log.info("【登录失败】"+exception.getMessage());
            ResultUtil.responseJson(response,ResultUtil.resultCode(false,"用户被禁用"));
        }
        if (exception instanceof BadCredentialsException){
            log.info("【登录失败】"+exception.getMessage());
            ResultUtil.responseJson(response,ResultUtil.resultCode(false,"密码不正确"));
        }
        ResultUtil.responseJson(response,ResultUtil.resultCode(false,"登录失败"));
    }
}