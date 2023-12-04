package com.dily.jpa.enums;

import jakarta.persistence.AttributeConverter;

/**
 * EnumConfig
 * Date: 2023-11-29 星期三
 * Time: 15:59
 * Author: Dily_Su
 * Remark: GradeEnum 的 枚举类转换类
 */
//@Converter(autoApply = true)
public class EnumConverter implements AttributeConverter<GradeEnum, String> {

    /**
     * 此方法告诉jpa数据库里存的值
     */
    @Override
    public String convertToDatabaseColumn(GradeEnum gradeEnum) {
        if (gradeEnum == null) {
            return null;
        }
        return gradeEnum.getName();
    }

    /**
     * 此方法告诉Java从数据库里取出的值对应的是哪个enum值
     */
    @Override
    public GradeEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        for (GradeEnum gradeEnum : GradeEnum.values()) {
            if (gradeEnum.getName().equals(value)) {
                return gradeEnum;
            }
        }
        return GradeEnum.UNKNOWN;
//        throw new IllegalArgumentException(); // 或者给个默认的enum eg: return Grade.UNKNOWN
    }
}
