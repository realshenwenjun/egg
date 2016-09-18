package com.dskj.util;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2016/9/18.
 */
public class Java2Map {

    /**
     * JavaBean对象转化成Map对象
     *
     * @return
     * @author jqlin
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Map java2Map(Object o) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = null;
        fields = getDeclaredField(o);
        for (Field field : fields) {
            field.setAccessible(true);
            String proName = field.getName();
            Object proValue = field.get(o);
            map.put(proName, proValue);
        }
        return map;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param object    : 子类对象
     * @return 父类中的属性对象
     */

    public static Field[] getDeclaredField(Object object) {
        Field[] fields = null;

        Class<?> clazz = object.getClass();
        fields = clazz.getDeclaredFields();
        Class<?> supperClazz = clazz.getSuperclass();
        if (supperClazz != null) {
            Field[] supperFields = supperClazz.getDeclaredFields();
            int strLen1 = fields.length;//保存第一个数组长度
            int strLen2 = supperFields.length;//保存第二个数组长度
            fields = Arrays.copyOf(fields, strLen1 + strLen2);//扩容
            System.arraycopy(supperFields, 0, fields, strLen1, strLen2);//将第二个数组与第一个数组合并
        }
        return fields;
    }
}
