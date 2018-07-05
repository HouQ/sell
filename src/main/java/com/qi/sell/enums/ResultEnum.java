package com.qi.sell.enums;

import lombok.Getter;

/**
 * Created by Qi
 * 2018/7/5 17:34
 **/
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
