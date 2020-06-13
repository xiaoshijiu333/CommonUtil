package com.fei.common.random;

import java.util.Random;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 获取验证码（数字+字母）
 */
public class RandomCode {

    /**
     * 获取验证码（数字+字母）
     * @param n 验证码长度
     * @return java.lang.String
     */
    public static String getCode(int n) {
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // 声明一个字符数组对象ch 保存 验证码
        char[] ch = new char[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(string.length());
            ch[i] = string.charAt(index);
        }
        return String.valueOf(ch);
    }

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private RandomCode() {
    }
}
