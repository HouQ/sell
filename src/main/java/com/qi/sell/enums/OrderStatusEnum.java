package com.qi.sell.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 * Created by Qi
 * 2018/7/5 14:42
 **/
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完成"),
    CANCEL(2, "已取消"),;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

//    public static OrderStatusEnum getOrderStatusEnum(Integer code) {
//        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
//            if (orderStatusEnum.getCode() == code) {
//                return orderStatusEnum;
//            }
//        }
//        return null;
//    }

}
