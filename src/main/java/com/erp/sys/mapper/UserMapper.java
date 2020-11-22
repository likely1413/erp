package com.erp.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erp.sys.entity.SysMenu;
import com.erp.sys.entity.SysRole;
import com.erp.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author zwc
 * @since 2020-11-22
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户ID查询权限集合
     *
     * @param userId 用户ID
     * @return List<SysMenu>
     */
    List<SysMenu> selectSysMenuByUserId(Long userId);


    /**
     * 通过用户ID查询角色集合
     *
     * @Param userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRole> selectSysRoleByUserId(Long userId);

}
