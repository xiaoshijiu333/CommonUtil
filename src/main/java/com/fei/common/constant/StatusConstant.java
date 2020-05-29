package com.fei.common.constant;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/5
 * @Description: 常用状态以及描述常量
 */
public class StatusConstant {
    public static final int SUCCESS_CODE = 200;
    public static final int NOTFOUND_CODE = 404;
    public static final int FAILURE_CODE = 500;
    public static final String SUCCESS_MESSAGE = "请求成功";
    public static final String FAILTURE_MESSAGE = "请求失败";
    public static final String FAILTURE_MESSAGE_PARAMETER_ERROR = "请求失败，参数错误";
    public static final String NOAUTH_MESSAGE = "对不起你没有权限，不允许访问";

    private StatusConstant() {
    }
}
