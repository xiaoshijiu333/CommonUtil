package com.fei.common.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author: xiaoshijiu
 * @Date: 2020/6/12
 * @Description: json操作相关工具类，基于fastjson
 */
public class JsonUtilsByFastJson {

    /**
     * json对象转json字符串，该对象为null的属性也转出来
     * @param object json对象（java对象）
     * @return json格式字符串
     */
    public static String jsonObject2StrigContainNull(Object object) {
        return JSONObject.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }

    /**
     * json对象转json字符串，该对象为null的属性不转出来
     * @param object json对象（java对象）
     * @return json格式字符串
     */
    public static String jsonObject2Strig(Object object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * json字符串转成具体的java对象(null值会自动包括到对象里面去)
     * @param jsonStr json格式字符串
     * @param t 泛型，待转化类型的字节码
     * @return Java对象
     */
    public static <T> T string2JavaObject(String jsonStr, Class<T> t) {
        return JSONObject.parseObject(jsonStr, t);
    }

    /**
     * json字符串转json对象(null值不会自动包括到对象里面去)
     * @param jsonStr json格式字符串
     * @return json对象
     */
    public static Object string2JsonObject(String jsonStr) {
        return JSONObject.parseObject(jsonStr);
    }

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private JsonUtilsByFastJson() {
    }
}