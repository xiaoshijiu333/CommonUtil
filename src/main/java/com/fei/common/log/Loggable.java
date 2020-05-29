package com.fei.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/27
 * @Description: 日志接口
 */
public interface Loggable {

    /**
     * 实现该接口则默认实现该方法
     * 实现该接口的类，使用该方法则可以打印日志
     */
    default Logger getLog() {
        return LoggerFactory.getLogger(this.getClass());
    }
}

