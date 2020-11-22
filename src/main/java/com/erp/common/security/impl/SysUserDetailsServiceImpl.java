package com.erp.common.security.impl;

import com.erp.common.security.entity.SysUserDetails;
import com.erp.sys.entity.SysUser;
import com.erp.sys.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * SpringSecurity用户的业务实现
 *
 * @author Administrator
 */

@Component
public class SysUserDetailsServiceImpl implements UserDetailsService {

    private final IUserService iUserService;
    public SysUserDetailsServiceImpl(IUserService iUserService) {
        this.iUserService = iUserService;
    }


    /**
     * 查询用户信息
     *
     * @Param username  用户名
     * @Return UserDetails SpringSecurity用户信息
     */

    @Override
    public SysUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        SysUser user = iUserService.selectUserByName(username);
        if (user != null) {
            // 组装参数
            SysUserDetails selfUserEntity = new SysUserDetails();
            BeanUtils.copyProperties(user, selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
