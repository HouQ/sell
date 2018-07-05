package com.qi.sell.service.impl;

import com.qi.sell.dto.OrderDTO;
import com.qi.sell.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Qi
 * 2018/7/5 18:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String OPENID = "wx123456789";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("wang");
        orderDTO.setBuyerPhone("123456789");
        orderDTO.setBuyerAddress("王府井大道3303");
        orderDTO.setBuyerOpenid(OPENID);

        /*购物车*/
        List<OrderDetail> orderDetailList = new ArrayList<>();
//        OrderDetail o1 =new OrderDetail()

    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}