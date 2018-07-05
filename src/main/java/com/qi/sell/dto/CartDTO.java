package com.qi.sell.dto;

import lombok.Data;

/**
 * 购物车
 * Created by Qi
 * 2018/7/5 18:01
 **/
@Data
public class CartDTO {
    /*商品id*/
    private String productId;

    /*数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
