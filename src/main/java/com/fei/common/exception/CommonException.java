package com.fei.common.exception;

import com.fei.common.constant.StatusConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/17
 * @Description: 自定义运行时异常
 */
@Setter
@Getter
public class CommonException extends RuntimeException {

    private int code;
    private String message;

    public CommonException() {
        super();
        this.code = StatusConstant.FAILURE_CODE;
    }

    public CommonException(String message) {
        super(message);
        this.code = StatusConstant.FAILURE_CODE;
        this.message = message;
    }

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public CommonException(Throwable cause) {
        super(cause);
        this.code = StatusConstant.FAILURE_CODE;
        this.message = cause.getMessage();
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
        this.code = StatusConstant.FAILURE_CODE;
        this.message = message;
    }
}
