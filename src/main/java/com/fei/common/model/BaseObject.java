package com.fei.common.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 定义通用属性，像创建时间、修改时间、删除时间，然后实体或模型直接继承该类，则拥有了通用字段
 */
@Setter
@Getter
public class BaseObject {
    /**
     * 定义和属性名相同的常量字段
     */
    public static final String CREATE_TIME = "createTime";
    private Date createTime;
    public static final String UPDATE_TIME = "updateTime";
    private Date updateTime;
    public static final String DELETE_TIME = "deleteTime";
    /**
     * 空串表示未删除
     */
    public static final String DELETE_TIME_NO = "";
    private String deleteTime;
}
