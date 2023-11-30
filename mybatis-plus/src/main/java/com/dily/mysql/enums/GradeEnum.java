package com.dily.mysql.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
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
public enum GradeEnum{
    UNKNOWN(0, "未知"),
    SECONDARY(2, "中学"),
    PRIMARY(1, "小学"),
    HIGH(3, "高中");
    @EnumValue
    private final Integer value;
    @JsonValue
    private final String  label;
}

