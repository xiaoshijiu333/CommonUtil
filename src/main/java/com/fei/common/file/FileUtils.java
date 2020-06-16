package com.fei.common.file;

import com.fei.common.constant.FileConstant;
import com.fei.common.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: xiaoshijiu
 * @Date: 2020/6/13
 * @Description: 文件命名规范：不能有以下9种符号：\ / * ? : " < > |
 */
public class FileUtils {

    private static Pattern pattern = Pattern.compile("<|>|:|\"|\\*|\\?|\\/|\\\\|\\|");

    private final static Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

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
    public static boolean fileNameNotStandard(String filename) {
        Matcher matcher = pattern.matcher(filename);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * @param url：文件网络地址
     * @param dir: 目录
     * @param filename：保存的文件名，没有后缀
     * @param retryCount 尝试次数
     * @param timeOut 超时时间，单位毫秒
     */
    public static void downFiles(String url, String dir, String filename, int retryCount,
            int timeOut) {

        if (fileNameNotStandard(filename)) {
            throw new CommonException("文件名不合规，含有特殊字符，\\ / * ? : \" < > |");
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;
        int count = 1;
        while (count <= retryCount) {
            try {
                URLConnection connection = new URL(url).openConnection();
                connection.setConnectTimeout(timeOut);
                connection.setReadTimeout(timeOut);
                inputStream = connection.getInputStream();
                byte[] bytes = new byte[100];
                // 不存在，创建该文件夹
                File file = new File(dir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                // 根据url获取文件后缀
                String suffix = url.substring(url.lastIndexOf("."));
                outputStream = new FileOutputStream(
                        dir + FileConstant.SEPARATOR + filename + suffix);
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }
                break;
            } catch (IOException e) {
                LOGGER.warn("第{}次尝试失败，准备下一次尝试", count);
                count++;
                if (count > retryCount) {
                    LOGGER.error("网络问题，下载失败", e);
                    break;
                }
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private FileUtils() {
    }
}
