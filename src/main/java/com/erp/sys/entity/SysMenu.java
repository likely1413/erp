package com.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author zwc
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_MENU")
@KeySequence(value = "SEQ_AUTO")
public class SysMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "ID",type = IdType.INPUT)
    private Long id;

    /**
     * 菜单名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 路径
     */
    @TableField("PATH")
    private String path;

    /**
     * 菜单许可
     */
    @TableField("PERMISSION")
    private String permission;


}
