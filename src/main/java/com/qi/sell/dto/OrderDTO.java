package com.qi.sell.dto;

import com.qi.sell.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象,比ordermaster多了orderdetail信息
 * Created by Qi
 * 2018/7/5 17:22
 **/
@Data
public class OrderDTO {
    /*订单Id*/
    private String orderId;

    /*买家名字*/
    private String buyerName;

    /*买家手机号*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信openId*/
    private String buyerOpenid;

    /*订单总额*/
    private BigDecimal orderAmount;

    /*订单状态 0新下单*/
    private Integer orderStatus;

    /*支付状态 0未支付*/
    private Integer payStatus;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
