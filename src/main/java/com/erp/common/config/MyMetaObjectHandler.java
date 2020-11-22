package com.erp.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.erp.common.util.DateTimeUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * 自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //对应实体类属性addTime，而非数据库字段ADD_TIME
        this.setFieldValByName("addTime", DateTimeUtil.getTimeToString(), metaObject);
        this.setFieldValByName("updateTime", DateTimeUtil.getTimeToString(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", DateTimeUtil.getTimeToString(), metaObject);
    }
}
