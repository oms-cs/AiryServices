package com.airy.ecom.ordersservice.controller;

import com.airy.ecom.ordersservice.model.OrderElements;
import com.airy.ecom.ordersservice.model.dto.OrderElementReqRes;
import com.airy.ecom.ordersservice.services.OrderElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class OrderElementsController {

    @Autowired
    private final OrderElementService orderElementService;

    public OrderElementsController(OrderElementService orderElementService){
        this.orderElementService = orderElementService;
    }

    @PostMapping("/{userName}/add")
    public ResponseEntity<?> addToCart(@RequestBody OrderElementReqRes orderElementReqRes, @PathVariable String userName){
        orderElementReqRes.setUserName(userName);
        OrderElements existingElement = orderElementService.findByUserNameAndProductName(userName, orderElementReqRes.getProductName());
        if(existingElement == null){
            OrderElements orderElements = orderElementService.addToCart(orderElementReqRes);
            return ResponseEntity.ok(orderElements.getProductName() + " Added to Cart");
        }
        return ResponseEntity.ok(orderElementReqRes.getProductName() + " Already exists in Cart! please select a new element");
    }

    @DeleteMapping("/{userName}/remove")
    public ResponseEntity<?> removeFromCart(@RequestBody OrderElementReqRes orderElementReqRes, @PathVariable String userName){
        orderElementReqRes.setUserName(userName);
        OrderElements orderElement = orderElementService.removeFromCart(orderElementReqRes);
        return ResponseEntity.ok(orderElement.getProductName() + " Removed from Cart");
    }

    //for future reference currently adding multiple quantity of a product is not available
    // also removing of the same is also not added hence this is to be added.

    @GetMapping("/{userName}/fetchCart")
    public ResponseEntity<List<OrderElements>> fetchFromCart(@PathVariable String userName){
        return ResponseEntity.ok(orderElementService.fetchFromCart(userName));
    }

    @DeleteMapping("/{userName}/clearCart")
    public ResponseEntity clearCart(@PathVariable String userName){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
