package com.qi.sell.entity;

import com.qi.sell.enums.OrderStatusEnum;
import com.qi.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Qi
 * 2018/7/5 14:40
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /*订单Id*/
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态 0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;
}
