package com.qi.sell.service.impl;

import com.qi.sell.entity.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Qi
 * 2018/7/12 13:42
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {
    @Autowired
    private SellerServiceImpl sellerService;

    private static final String openid = "abc";

    @Test
    public void findSellerInfoByOpenid()  throws Exception{
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid("abc");
        log.info("seller:{}",sellerInfo);
        Assert.assertEquals(sellerInfo.getUsername(),"admin");
    }
}