package com.qi.sell.service.impl;

import com.qi.sell.dao.ProductCategoryRespository;
import com.qi.sell.entity.ProductCategory;
import com.qi.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * Created by Qi
 * 2018/7/4 18:21
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRespository respository;

    @Override
    public ProductCategory findOne(Integer categarId) {
        return respository.findById(categarId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAAll() {
        return respository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return respository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return respository.save(productCategory);
    }
}
