package com.norialertapp.controller;

import com.norialertapp.entity.Product;
import com.norialertapp.entity.User;
import com.norialertapp.service.ProductService;
import com.norialertapp.service.SearchService;
import com.norialertapp.service.ShopifyService;
import com.norialertapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @RequestMapping(path = {"", "/", "/index", "/login"}/*, method = RequestMethod.GET*/)
    public String login() {
        return "login";
    }

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

    //Spring Security sees this from _login.html_ form:

    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    public String loginForm(String username, String password, Model model) {

        User user = userService.findByEmail(username); //username = email
        if (userService.passwordMatch(password, user.getPassword())) {
            return "redirect:/dashboard";

        } else {
            return "redirect:/login?error";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        return "redirect:/login?logout";
    }

    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }

}
