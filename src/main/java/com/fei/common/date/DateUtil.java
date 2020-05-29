package com.fei.common.date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/23
 * @Description: 时间工具类
 */
public class DateUtil {
    public static final String DATE_FORMAT1 ="yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT2 ="yyyy-MM-dd HH:mm:ss";
    public static final String TIME_ZONE ="GMT+8";

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private DateUtil() {
    }

    /**
     * 获取删除时间字符串（当前时间字符串），使用apach的date common
     */
    public static String getDeleteTimeStr(){
        return DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
    }
}

