package com.erp.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.erp.sys.entity.SysMenu;
import com.erp.sys.entity.SysRole;
import com.erp.sys.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author zwc
 * @since 2020-11-22
 */
public interface IUserService extends IService<SysUser> {
    /**
     * 根据用户ID查询权限集合
     *
     * @param userId 用户ID
     * @return List<SysMenu> 角色名集合
     */
    List<SysMenu> selectSysMenuByUserId(Long userId);

    /**
     * 根据用户ID查询角色集合
     *
     * @param userId 用户ID
     * @return List<SysRole> 角色名集合
     */
    List<SysRole> selectSysRoleByUserId(Long userId);

    /**
     * 根据用户名查询实体
     *
     * @param username 用户名
     * @return SysUser 用户实体
     */
    SysUser selectUserByName(String username);

}
