package com.qi.sell.service.impl;

import com.qi.sell.dao.ProductInfoRespository;
import com.qi.sell.entity.ProductInfo;
import com.qi.sell.enums.ProductStatusEnum;
import com.qi.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Qi
 * 2018/7/5 10:06
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRespository respository;

    @Override
    public ProductInfo findOne(String productId) {
        return respository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return respository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return respository.save(productInfo);
    }
}
