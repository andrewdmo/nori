package com.norialertapp.controller;

import com.norialertapp.entity.*;
import com.norialertapp.repository.QtyLevelRepo;
import com.norialertapp.service.ProductService;
import com.norialertapp.service.SearchService;
import com.norialertapp.service.ShopifyService;
import com.norialertapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import java.util.List;

/**
 * Created by katherine_celeste on 10/11/16.
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    ShopifyService shopifyService;

    @Autowired
    public ProductService productService;

    @Autowired
    private SearchService searchService;

//    @RequestParam(value = "error", required = false) String error,
//    @RequestParam(value = "logout", required = false) String logout,

    //Spring Security sees this :
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(String password, String username, Model model) {

        Users user = userService.findByEmail(username); //username = email
         if(userService.passwordMatch(password, user.getPassword())) {

             // load list of products from Shopify
             List<Product> products = shopifyService.getAndSaveProducts();

             searchService.searchShopifyProductsList(products);

             HashMap <Long, String> qtyLevels= searchService.qtyLevels();
             HashMap <Long, Integer> qty = searchService.qty();

             model.addAttribute("qtyLevels", qtyLevels);
             model.addAttribute("qty", qty);

             model.addAttribute("products", productService.listProducts());
             return "dashboard";
         }
         else{
             return "error";
         }
         // Uh oh....
        //Something went wrong. Please navigate back to the previous page.

    }


    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public String createAccount(Model model) {
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String accountCreated(String firstName, String lastName, String email, String password,
                                 String confirmPassword, Model model) {
        Users user = new Users();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);

        // make sure user has not registered in the past
        if(userService.findByEmail(email)==null) {
            try {
                userService.saveUser(user);
                return "dashboard";
            } catch (Exception e) {

            }
        }
            return "errorPg";
    }

    @RequestMapping(value = "/emailTemplate", method = RequestMethod.GET)
    public String emailTemplate(Model model) {
        return "email-template";
    }
}