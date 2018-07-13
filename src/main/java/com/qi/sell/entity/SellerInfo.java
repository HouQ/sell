package com.qi.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Qi
 * 2018/7/11 14:24
 **/
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    @NotEmpty(message = "姓名必填")
    private String username;

    @NotEmpty(message = "密码必填")
    private String password;

    private String openid;


}
