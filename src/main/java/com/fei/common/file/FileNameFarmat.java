package com.fei.common.file;

/**
 * @Author: xiaoshijiu
 * @Date: 2020/6/13
 * @Description: 文件命名规范：不能有以下9种符号：\ / * ? : " < > |
 */
public class FileNameFarmat {

    /**
     * @param filename 文件名
     * @param to 将这些字符转成什么
     */
    public static String renameFile(String filename, String to) {
        // 反斜杠在Java里面表示转义符，在正则表达式里面也表示转义符，所以在replaceAll中四个反斜杠表示一个反斜杠
        return filename.replaceAll("<|>|:|\"|\\*|\\?|\\/|\\\\|\\|", to);
    }

}
