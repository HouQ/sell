package com.qi.sell.dao;

import com.qi.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Qi
 * 2018/7/5 14:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("201807051003");
        orderMaster.setBuyerName("Jack Za");
        orderMaster.setBuyerPhone("123456");
        orderMaster.setBuyerAddress("金汇南路28号3011");
        orderMaster.setBuyerOpenid("wx12568947");
        orderMaster.setOrderAmount(new BigDecimal(20.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest pageRequest = PageRequest.of(1,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid("wx12568947",pageRequest);
        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}