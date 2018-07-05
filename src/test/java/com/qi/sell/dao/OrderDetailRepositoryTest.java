package com.qi.sell.dao;

import com.qi.sell.entity.OrderDetail;
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
 * 2018/7/5 15:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456790");
        orderDetail.setOrderId("201807051001");
        orderDetail.setProductIcon("www.baidu.com");
        orderDetail.setProductId("123457");
        orderDetail.setProductName("蛋挞");
        orderDetail.setProductPrice(new BigDecimal(15.5));
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail1 =repository.save(orderDetail);
        Assert.assertNotEquals(null,orderDetail1);

    }

    @Test
    public void findByOrOrderId() throws Exception{
        List<OrderDetail> list = repository.findByOrOrderId("201807051001");
        Assert.assertNotEquals(0,list.size());
    }
}