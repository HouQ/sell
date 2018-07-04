package com.qi.sell.service;

import com.qi.sell.entity.ProductInfo;
import org.springframework.stereotype.Service;

/**
 * Created by Qi
 * 2018/7/4 18:46
 **/
@Service
public interface ProductService {
    ProductInfo findOne(String productId);


}
