package com.dily.jpa.enums;

import jakarta.persistence.AttributeConverter;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * EnumConvert
 * Date: 2023-11-29 星期三
 * Time: 16:35
 * Author: Dily_Su
 * Remark: 枚举通用转换类 抽象类
 */
public abstract class AbstractEnumConverter<X extends BaseEnum<V>,V> implements AttributeConverter<BaseEnum<V>, V> {

    private Class<X> clazz;
    private Method method;

    @SuppressWarnings("unchecked")
    public AbstractEnumConverter() {
        this.clazz = (Class<X>) (((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments())[0];
        try {
            method = clazz.getMethod("values");
        } catch (Exception e) {
            throw new RuntimeException("can't get values method from " + clazz);
        }
    }
    /**
     * 数据库存储的值
     * @param baseEnum 枚举对象
     * @return 数据库中存放的值
     */
    @Override
    public V convertToDatabaseColumn(BaseEnum<V> baseEnum) {
        return baseEnum.getCode();
    }

    /**
     * 数据库中的值转换为 枚举对象
     * @param value 数据库中的值
     * @return 枚举对象
     */
    @SuppressWarnings("unchecked")
    @Override
    public BaseEnum<V> convertToEntityAttribute(V value) {
        try {
            X[] enums = (X[]) method.invoke(null);
            for (X x: enums){
                if (x.getCode().equals(value)){
                    return x;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            throw new IllegalArgumentException("unknown value of db enum attribute: " + value);
    }
}
