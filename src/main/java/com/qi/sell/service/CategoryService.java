package com.qi.sell.service;

import com.qi.sell.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by Qi
 * 2018/7/4 18:19
 **/
public interface CategoryService {
    ProductCategory findOne(Integer categarId);

    List<ProductCategory> findAAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
