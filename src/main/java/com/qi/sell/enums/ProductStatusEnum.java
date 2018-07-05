package com.qi.sell.enums;

import com.qi.sell.entity.ProductInfo;
import lombok.Getter;

/**
 * Created by Qi
 * 2018/7/5 10:10
 **/
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"), DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
