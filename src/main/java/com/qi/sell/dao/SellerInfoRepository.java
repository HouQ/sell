package com.qi.sell.dao;

import com.qi.sell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Qi
 * 2018/7/11 14:26
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
    SellerInfo findByUsername(String username);
}
