package com.qi.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qi.sell.entity.OrderDetail;
import com.qi.sell.enums.OrderStatusEnum;
import com.qi.sell.enums.PayStatusEnum;
import com.qi.sell.utils.EnumUtil;
import com.qi.sell.utils.serializer.Data2LongSerializer;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象,比ordermaster多了orderdetail信息
 * Created by Qi
 * 2018/7/5 17:22
 **/
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL) //结果中为null的不返回给前端
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
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date createTime;

    /*更新时间*/
    //@JsonSerialize(using = Data2LongSerializer.class) 格式化时间格式
    private Date updateTime;

    //当这个字段必须要返回且不能为null的时候,给个初始值
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    //根据状态码获取枚举类
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore//转成json时会忽略
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }


}
