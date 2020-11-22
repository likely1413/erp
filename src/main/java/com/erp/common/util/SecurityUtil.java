package com.erp.common.util;

import com.erp.common.security.entity.SysUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security工具类
 * @author Administrator
 */
public class SecurityUtil {

    /**
     * 私有化构造器
     */
    private SecurityUtil(){}

    /**
     * 获取当前用户信息
     */
    public static SysUserDetails getUserInfo(){
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        return sysUserDetails;
    }
    /**
     * 获取当前用户ID
     */
    public static Long getUserId(){
        return getUserInfo().getId();
    }
    /**
     * 获取当前用户账号
     */
    public static String getUserName(){
        return getUserInfo().getUsername();
    }
}