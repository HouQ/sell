package com.qi.sell.service;

import com.qi.sell.entity.SellerInfo;

/**
 * Created by Qi
 * 2018/7/11 14:35
 **/
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
