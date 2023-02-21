package com.airy.ecom.ordersservice.controller;

import com.airy.ecom.ordersservice.model.OrderElements;
import com.airy.ecom.ordersservice.model.dto.OrderElementReqRes;
import com.airy.ecom.ordersservice.services.OrderElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
public class OrderElementsController {

    @Autowired
    private final OrderElementService orderElementService;

    public OrderElementsController(OrderElementService orderElementService){
        this.orderElementService = orderElementService;
    }

    @PostMapping("add")
    public ResponseEntity<?> addToCart(@RequestBody OrderElementReqRes orderElementReqRes){
        OrderElements orderElements = orderElementService.addToCart(orderElementReqRes);
        return ResponseEntity.ok(orderElements.getProductName() + " Added to Cart");
    }

    @DeleteMapping("remove")
    public ResponseEntity<?> removeFromCart(@RequestBody OrderElementReqRes orderElementReqRes){
        OrderElements orderElement = orderElementService.removeFromCart(orderElementReqRes);
        return ResponseEntity.ok(orderElement.getProductName() + " Added to Cart");
    }

    //for future reference currently adding multiple quantity of a product is not available
    // also removing of the same is also not added hence this is to be added.

}
