package com.fei.common.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: xiaoshijiu
 * @Date: 2020/6/13
 * @Description: 文件命名规范：不能有以下9种符号：\ / * ? : " < > |
 */
public class FileNameFarmat {

    private static Pattern pattern = Pattern.compile("<|>|:|\"|\\*|\\?|\\/|\\\\|\\|");

    /**
     * @param filename 文件名
     * @param to 将这些字符转成什么
     * @return 替换不合规字符之后的重命名
     */
    public static String renameFile(String filename, String to) {
        // 反斜杠在Java里面表示转义符，在正则表达式里面也表示转义符，所以在replaceAll中四个反斜杠表示一个反斜杠
        return filename.replaceAll("<|>|:|\"|\\*|\\?|\\/|\\\\|\\|", to);
    }

    /**
     * @param filename 文件名
     * @return 是否不合规，即包含了特殊字符
     */
    public static boolean fileNameStandard(String filename) {
        Matcher matcher = pattern.matcher(filename);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private FileNameFarmat() {
    }
}
