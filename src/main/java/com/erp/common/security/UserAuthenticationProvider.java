package com.erp.common.security;


import com.erp.common.security.entity.SysUserDetails;
import com.erp.common.security.impl.SysUserDetailsServiceImpl;
import com.erp.sys.entity.SysRole;
import com.erp.sys.service.IUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 自定义登录验证
 * @author Administrator
 */

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    private final SysUserDetailsServiceImpl sysUserDetailsServiceImpl;
    private final IUserService iUserService;

    public UserAuthenticationProvider(SysUserDetailsServiceImpl sysUserDetailsServiceImpl, IUserService iUserService) {
        this.sysUserDetailsServiceImpl = sysUserDetailsServiceImpl;
        this.iUserService = iUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取表单输入中返回的用户名
        String username = (String) authentication.getPrincipal();
        // 获取表单中输入的密码
        String password = (String) authentication.getCredentials();
        // 查询用户是否存在
        SysUserDetails userInfo = sysUserDetailsServiceImpl.loadUserByUsername(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        if (!new BCryptPasswordEncoder().matches(password, userInfo.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        if (userInfo.getStatus().equals(2)) {
            throw new LockedException("该用户已被禁用");
        }

        // 角色集合
        Set<GrantedAuthority> authorities = new HashSet<>();
        // 查询用户角色
        List<SysRole> sysRoleEntityList = iUserService.selectSysRoleByUserId(userInfo.getId());
        for (SysRole sysRoleEntity : sysRoleEntityList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + sysRoleEntity.getName()));
        }
        userInfo.setAuthorities(authorities);
        // 进行登录
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

