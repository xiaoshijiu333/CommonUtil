package com.fei.common.server.cookie;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/16
 * @Description: cookie工具类
 */
public class CookieUtils {

    /**
     * 过期时间，单位：秒；七天
     */
    public static final int COOKIE_SECOND = 7 * 24 * 3600;

    /**
     * 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
     * @param request 请求对象
     * @param key key值
     * @return Cookie对象
     */
    public static Cookie getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return null;
        }
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (key.equals(c.getName())) {
                cookie = c;
                break;
            }
        }
        return cookie;
    }

    /**
     * 根据Cookie名称直接得到Cookie值
     * @param request 请求对象
     * @param key key值
     * @return String value值
     */
    public static String getCookieValue(HttpServletRequest request, String key) {
        Cookie cookie = getCookie(request, key);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }

    /**
     * 移除cookie
     * @param request 请求对象
     * @param response 响应对象
     * @param key key值
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response,
            String key) {
        if (null == key) {
            return;
        }
        Cookie cookie = getCookie(request, key);
        if (null != cookie) {
            // path 共享（同一服务器下的不同应用）
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
     * 添加一条新的Cookie，可以指定过期时间(单位：秒)
     * @param response 响应对象
     * @param key key值
     * @param value value值
     * @param maxValue 过期时间
     */
    public static void setCookie(HttpServletResponse response, String key, String value,
            int maxValue) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        if (null == value) {
            value = "";
        }
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        if (maxValue != 0) {
            cookie.setMaxAge(maxValue);
        } else {
            cookie.setMaxAge(COOKIE_SECOND);
        }
        response.addCookie(cookie);
    }

    /**
     * 添加一条新的Cookie，默认7天过期时间
     * @param response 响应对象
     * @param key key值
     * @param value value值
     */
    public static void setCookie(HttpServletResponse response, String key, String value) {
        setCookie(response, key, value, COOKIE_SECOND);
    }

    /**
     * 将cookie封装到Map里面
     * @param request 请求对象
     * @return Cookie对应的Map集合
     */
    public static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (!ArrayUtils.isEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
