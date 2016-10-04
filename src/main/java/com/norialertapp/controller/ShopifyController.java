package com.norialertapp.controller;
import com.norialertapp.entity.Product;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.service.ShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by katherine_celeste on 9/29/16.
 */

@Controller
public class ShopifyController {

    @Autowired
    public ShopifyService shopifyService;

    @Autowired
    public ProductRepo productRepo;

    @RequestMapping(path = "/")
    public String listProducts(Model model){

        productRepo.save(new Product(8798765l, "Great Product"));

        model.addAttribute("products", shopifyService.listProducts());

        return "dashboard";
    }
}
