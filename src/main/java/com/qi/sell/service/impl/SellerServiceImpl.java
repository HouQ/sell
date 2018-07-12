package com.qi.sell.service.impl;

import com.qi.sell.dao.SellerInfoRepository;
import com.qi.sell.entity.SellerInfo;
import com.qi.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Qi
 * 2018/7/11 14:37
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
