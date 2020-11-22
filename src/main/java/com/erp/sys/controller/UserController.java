package com.erp.sys.controller;


import com.erp.sys.entity.SysUser;
import com.erp.sys.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户表
 *
 * @author zwc
 * @since 2020-11-22
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    /**
     * 添加用户
     *
     * @return
     */
    @GetMapping("add")
    public String add() {
        SysUser user = new SysUser();
        user.setName("有颜");
        user.setUsername("admin");
        user.setUsername("admin");
        if (service.save(user)) {
            return "保存成功";
        }
        return "保存失败";
    }

}
