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
public class NotAuthException extends CommonException {

    private int code;
    private String message;

    public NotAuthException() {
        super(StatusConstant.NOAUTH_MESSAGE);
        this.code = StatusConstant.FAILURE_CODE;
    }

    public NotAuthException(String message) {
        super(message);
        this.code = StatusConstant.FAILURE_CODE;
        this.message = message;
    }

    public NotAuthException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public NotAuthException(Throwable cause) {
        super(cause);
        this.code = StatusConstant.FAILURE_CODE;
        this.message = cause.getMessage();
    }

    public NotAuthException(String message, Throwable cause) {
        super(message, cause);
        this.code = StatusConstant.FAILURE_CODE;
        this.message = message;
    }
}
