package com.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统角色菜单
 * </p>
 *
 * @author zwc
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_ROLE_MENU")
@KeySequence(value = "SEQ_AUTO")
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "ID",type = IdType.INPUT)
    private Long id;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField("MENU_ID")
    private Long menuId;


}
