package com.fei.common.json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: xiaoshijiu
 * @Date: 2020/6/12
 * @Description: $value$
 */
public class JsonUtilsByJackJson {

    static ObjectMapper objectMapper;

    /**
     * json字符串转成具体的java对象
     * @param jsonStr json格式字符串
     * @param t 泛型，待转化类型的字节码
     * @return Java对象
     */
    public static <T> T string2JavaObject(String jsonStr, Class<T> t) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json对象转json字符串，该对象为null的属性不转出来
     * @param object json对象（java对象）
     * @return json格式字符串
     */
    public static String jsonObject2Strig(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
