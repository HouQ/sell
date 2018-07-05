package com.qi.sell.dao;

import com.qi.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Qi
 * 2018/7/5 14:57
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrOrderId(String orderId);
}
