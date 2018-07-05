package com.qi.sell.service;

import com.qi.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Qi
 * 2018/7/4 18:46
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    /*查找所有在架商品列表*/
    List<ProductInfo> findUpAll();

    /*查找所有商品列表 带分页*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /*加库存*/

    /*减库存*/

}
