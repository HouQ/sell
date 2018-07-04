package com.qi.sell.dao;

import com.qi.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Qi
 * 2018/7/4 17:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRespositoryTest {
    @Autowired
    private ProductCategoryRespository respository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = respository.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
//    @Transactional //完全回滚，不在数据库留下痕迹
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱榜", 5);
        ProductCategory p = respository.save(productCategory);
        Assert.assertNotNull(p);
//        Assert.assertNotEquals(null,p);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = respository.findById(2).orElse(null);
        productCategory.setCategoryType(100);
        respository.saveAndFlush(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,100);
        List<ProductCategory> result = respository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}