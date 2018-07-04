package com.qi.sell.dao;

import com.qi.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Qi
 * 2018/7/4 18:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {
    @Autowired
    ProductInfoRespository respository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("奶酪");
        productInfo.setProductPrice(new BigDecimal(15.5));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("澳洲进口！！");
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(100);

        ProductInfo productInfo1 = respository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = respository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }
}