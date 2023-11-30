package com.dily.mysql.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * SexEnum
 * Date: 2023-11-30 星期四
 * Time: 15:08
 * Author: Dily_Su
 * Remark:
 */
@AllArgsConstructor
public enum SexEnum implements IEnum<Integer> {
    MALE(0,"男"),
    FEMALE(1,"女");

    private final int value;
    @JsonValue
    private final String label;

    @Override
    public Integer getValue() {
        return this.value;
    }
}
