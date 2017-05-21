package com.norialertapp.controller;

import com.norialertapp.entity.Product;
import com.norialertapp.service.ProductService;
import com.norialertapp.service.SearchService;
import com.norialertapp.service.ShopifyService;
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

//    private UserService userService;

    ShopifyService shopifyService;

    public ProductService productService;

    private SearchService searchService;

    @RequestMapping(path = {"", "/", "/index"}/*, method = RequestMethod.GET*/)
    public String landing() {
        return "redirect:/login";
    }

    //login (x2):
    @RequestMapping(path = {"/login"})
    public String login() {
        return "login";
    }

    //Spring Security sees this from _login.html_ form:
//    @RequestMapping(path = {"/login"}, method = RequestMethod.POST)
//    public String login(String username, String password) {
//
//        User user = userService.findByEmail(username); //username = email
//
//        if (userService.passwordMatch(password, user.getPassword())) {
//            return "redirect:/dashboard";
//
//        } else {
//            return "redirect:/login?error";
//        }
//    }

    @RequestMapping(path = {"/dashboard"})
    public String dashboard(Model model) {

        // load list of products from Shopify
        List<Product> products = shopifyService.getAndSaveProducts();

        searchService.searchShopifyProductsList(products);

        HashMap<Long, String> qtyLevels = searchService.qtyLevels();
        HashMap<Long, Integer> qty = searchService.qty();

        model.addAttribute("qtyLevels", qtyLevels);
        model.addAttribute("qty", qty);

        model.addAttribute("products", productService.listProducts());
        return "dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        return "redirect:/login?logout";
    }

//    @ExceptionHandler
//    //add URL request query feedback later (https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc):
//    public String error() {
//        return "error";
//    }

}