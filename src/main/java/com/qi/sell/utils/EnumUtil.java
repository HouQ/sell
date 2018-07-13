package com.qi.sell.utils;

import com.qi.sell.enums.CodeEnum;

/**
 * Created by Qi
 * 2018/7/13 15:47
 **/
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
