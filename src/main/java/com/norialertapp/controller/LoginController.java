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


    @RequestMapping(path = {"", "/", "/index", "/login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    //Spring Security sees this from _login.html_ form:

    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    public String loginForm(String username, String password, Model model) {

        User user = userService.findByEmail(username); //username = email
        if (userService.passwordMatch(password, user.getPassword())) {

            // load list of products from Shopify
            List<Product> products = shopifyService.getAndSaveProducts();

            searchService.searchShopifyProductsList(products);

            HashMap<Long, String> qtyLevels = searchService.qtyLevels();
            HashMap<Long, Integer> qty = searchService.qty();

            model.addAttribute("qtyLevels", qtyLevels);
            model.addAttribute("qty", qty);

            model.addAttribute("products", productService.listProducts());
            return "dashboard";

        } else {
            return "/login";

//            return "/login?error";
        }
    }

    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }

//    Duplicate?:

//    @RequestMapping(value = "/login")
//    public String login(Model model) {
//        return "login";
//    }

//    @RequestMapping(value = "/createAcct", method = RequestMethod.GET)
//    public String createAcct(Model model) {
//        return "createAcct";
//    }
//
//    @RequestMapping(value = "/createAcct", method = RequestMethod.POST)
//    public String createAcct(String firstName, String lastName, String email, String password,
//                             String confirmPassword, Model model) {
//        User user = new User();
//        user.setFirstname(firstName);
//        user.setLastname(lastName);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setConfirmPassword(confirmPassword);
//
//        // make sure user has not registered in the past
//        if (userService.findByEmail(email) == null)
//            try {
//                userService.saveUser(user);
//                return "dashboard";
//            } catch (Exception e) {
//                return "error"; /*add registration error*/
//            }
//        return null;
//    }

}
