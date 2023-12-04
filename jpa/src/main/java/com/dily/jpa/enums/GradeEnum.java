package com.dily.jpa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Grade
 * Date: 2023-11-29 星期三
 * Time: 15:53
 * Author: Dily_Su
 * Remark:
 */
@Getter
@AllArgsConstructor
public enum GradeEnum implements BaseEnum<Integer>{
    UNKNOWN(0, "未知"),
    SECONDARY(2, "中学"),
    PRIMARY(1, "小学"),
    HIGH(3, "高中");
    private final Integer code;
    @JsonValue
    private final String  name;


    /// 枚举通用转换类实现
    public static class Converter extends AbstractEnumConverter<GradeEnum, Integer> {
        @Override
        public Integer convertToDatabaseColumn(BaseEnum<Integer> baseEnum) {
            try {
                return super.convertToDatabaseColumn(baseEnum);
            }catch (Exception e){
                return 0;
            }
        }

        @Override
        public BaseEnum<Integer> convertToEntityAttribute(Integer value) {
            try {
                return super.convertToEntityAttribute(value);
            }catch (Exception e){
                return GradeEnum.UNKNOWN;
            }
        }
    }
}

