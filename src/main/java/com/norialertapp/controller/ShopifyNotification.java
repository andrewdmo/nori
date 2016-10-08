package com.norialertapp.controller;

import com.norialertapp.entity.ShopifyOrder;
import com.norialertapp.service.OrderCreatedService;
import com.norialertapp.service.ShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by katherine_celeste on 10/5/16.
 */

@RestController
public class ShopifyNotification {

    @Autowired
    public OrderCreatedService orderCreatedService;

    @Autowired
    public ShopifyService shopifyService;

    @RequestMapping (path = "/order/creation")
    public String orderCreation(@RequestBody ShopifyOrder shopifyOrder) {

          shopifyService.getAndSaveProducts();

        //orderCreatedService.
//        myservice.save(product);
//        myservice.triggerNotifications(productId);
//
        return "notification!";
    }
}
