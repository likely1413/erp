package com.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author zwc
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_USER")
@KeySequence(value = "SEQ_AUTO")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID",type = IdType.INPUT)
    private Long id;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 状态：1=正常；2=禁用；
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 身份证号码
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 手机号码
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 性别：1=男；2=女；
     */
    @TableField("SEX")
    private Integer sex;

    /**
     * 机构ID
     */
    @TableField("ORGANIZATION_ID")
    private Long organizationId;


}
