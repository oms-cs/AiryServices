package com.airy.ecom.ordersservice.services;

import com.airy.ecom.ordersservice.model.OrderElements;
import com.airy.ecom.ordersservice.model.dto.OrderElementReqRes;
import com.airy.ecom.ordersservice.repository.OrderElementsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderElementService {


    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final OrderElementsRepository orderElementsRepository;


    public OrderElementService(OrderElementsRepository orderElementsRepository, ModelMapper modelMapper){
        this.orderElementsRepository = orderElementsRepository;
        this.modelMapper = modelMapper;
    }

    public OrderElements addToCart(OrderElementReqRes orderElementReqRes){
            OrderElements orderElement = modelMapper.map(orderElementReqRes, OrderElements.class);
            OrderElements savedOrderElement = orderElementsRepository.save(orderElement);
            return savedOrderElement;
    }

    public OrderElements removeFromCart(OrderElementReqRes orderElementReqRes){
            OrderElements orderElement = modelMapper.map(orderElementReqRes, OrderElements.class);
            orderElementsRepository.delete(orderElement);
            return orderElement;
    }
}
