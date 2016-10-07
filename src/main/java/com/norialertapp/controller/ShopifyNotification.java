package com.norialertapp.controller;

import com.norialertapp.entity.LineItem;
import com.norialertapp.entity.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by katherine_celeste on 10/5/16.
 */

@RestController
public class ShopifyNotification {

    // autowire in a service class "myservice"

    @RequestMapping (path = "/notification/update")
    public String productUpdate(@RequestBody Product product){

//        myservice.save(product);
//        myservice.triggerNotifications(productId);
//
       return "notification!";
    }

    @RequestMapping (path = "/order/creation")
    public String orderCreation(@RequestBody LineItem lineItem){
        return "an order";
    }
}
