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
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int index = random.nextInt(string.length());
            ch[i] = string.charAt(index);
        }
        String result = String.valueOf(ch);
        return result;
    }
}
