package com.fei.common.server.model;

import com.fei.common.constant.StatusConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/5
 * @Description: 返回前端模型结果
 */
@Getter
@Setter
public class ApiResult<T> {

    /**
     * 响应码，响应信息，响应数据
     */
    private int code;
    private String message;
    private T data;

    /**
     * 私有构造器，表明该类不允许直接实例化
     */
    private ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ApiResult() {
    }

    /**
     * ok 成功是通过model返回数据的
     */
    public static <T> ApiResult<T> ok(T data) {
        return new ApiResult<>(StatusConstant.SUCCESS_CODE, StatusConstant.SUCCESS_MESSAGE, data);
    }

    public static ApiResult ok() {
        return new ApiResult<>(StatusConstant.SUCCESS_CODE, StatusConstant.SUCCESS_MESSAGE, null);
    }

    public static ApiResult fail() {
        return new ApiResult<>(StatusConstant.SUCCESS_CODE, StatusConstant.FAILTURE_MESSAGE, null);
    }

    /**
     * fail 失败是通过message返回给前端信息的，model就一直为null
     */
    public static <T> ApiResult<T> fail(String message) {
        return new ApiResult<>(StatusConstant.SUCCESS_CODE, message, null);
    }

    public static <T> ApiResult<T> fail(int code, String message) {
        return new ApiResult<>(code, message, null);
    }

    public static <T> ApiResult<T> of(int code, String message, T data) {
        return new ApiResult<>(code, message, data);
    }

    public static ApiResult of(int code, String message) {
        return new ApiResult<>(code, message, null);
    }
}
