package com.airy.ecom.ordersservice.services;

import com.airy.ecom.ordersservice.model.Order;
import com.airy.ecom.ordersservice.model.OrderElements;
import com.airy.ecom.ordersservice.model.dto.OrderReqRes;
import com.airy.ecom.ordersservice.repository.OrderElementsRepository;
import com.airy.ecom.ordersservice.repository.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final OrderElementsRepository orderElementsRepository;

    public OrderService(OrdersRepository ordersRepository, OrderElementsRepository orderElementsRepository){
        this.ordersRepository = ordersRepository;
        this.orderElementsRepository = orderElementsRepository;
    }

    public Order placeOrder(String userName){
        List<OrderElements> orderElements = orderElementsRepository.findByUserName(userName);
        Order order = new Order();
        order.setUserName(userName);
        order.setOrderAmount(orderElements.stream()
                .map(OrderElements::getPrice)
                .reduce(0.0,(total, price) -> total+price));
        order.setOrderElements(orderElements);
        order.setOrderStatus("ENTERED");

        Order placedOrder = ordersRepository.save(order);
        orderElementsRepository.deleteByUserName(userName);
        return placedOrder;
    }
}
