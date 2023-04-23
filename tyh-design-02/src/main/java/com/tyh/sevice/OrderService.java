package com.tyh.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: OrderService
 * @Author: 青衣醉
 * @Date: 2023/4/23 10:15 上午
 */
@Component
public class OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao){
        this.orderDao=orderDao;
    }
}
