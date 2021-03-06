package com.qi.sell.enums;

import lombok.Getter;

/**
 * Created by Qi
 * 2018/7/5 17:34
 **/
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数不正确"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单无商品详情"),
    PAY_STATUS_ERROR(17, "支付状态错误"),
    CART_EMPTY(18, "购物车为空"),
    SELLER_ERROR(19, "卖家信息不正确"),
    SELLER_NOT_EXIST(20, "卖家不存在"),
    WRONG_PASSWORD(21, "密码错误"),
    ORDER_CANCEL_SUCCESS(22, "订单取消成功"),
    ORDER_FINISH_SUCCESS(23, "订单完结成功");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
