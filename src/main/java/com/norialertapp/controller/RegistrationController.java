package com.norialertapp.controller;

import com.norialertapp.entity.User;
import com.norialertapp.service.ProductService;
import com.norialertapp.service.SearchService;
import com.norialertapp.service.ShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by katherine_celeste on 10/8/16.
 */
@Controller
public class RegistrationController {

    //forms error cycle:
//    @Autowired
//    private UserService userService;

    @Autowired
    private ShopifyService shopifyService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private ProductService productService;


    @RequestMapping(path = "/createAcct", method = RequestMethod.GET)
    public String createAcct(/*Model model*/) {

        // forms error cycle:
//        model.addAttribute("user", userService);
        return "createAcct";
    }

    @RequestMapping(value = "/createAcct", method = RequestMethod.POST)
    public String createAcct(@ModelAttribute("user") User user, Model model) {

        //first check for password or conf pass - see if it matches
//        if (!user.getPassword().equals(user.getConfirmPassword())) {
//            model.addAttribute("user", user);
//            model.addAttribute("error", "Password and confirm password do not match");
//            return "createAcct";
//        }

        //check if email exists or not
        //creates error cycle so blanked:
//        User savedUser = userService.findByEmail(user.getUsername());
//        if (savedUser != null) {
//            //user is not equal to null means user with this email id is already exist
//            model.addAttribute("user", user);
//            model.addAttribute("error", "This email is already exist with us.");
//            return "createAcct";
//        }

//        try {
//            // now save
//            userService.saveUser(user);

//      copied from LoginController to populate Dash:

        // load list of products from Shopify
//        List<Product> products = shopifyService.getAndSaveProducts();
//
//        searchService.searchShopifyProductsList(products);
//
//        HashMap<Long, String> qtyLevels = searchService.qtyLevels();
//        HashMap<Long, Integer> qty = searchService.qty();
//
//        model.addAttribute("qtyLevels", qtyLevels);
//        model.addAttribute("qty", qty);
//
//        model.addAttribute("products", productService.listProducts());
        return "dashboard";

//    } catch(
//    Exception e)
//
//    {
//        return "error"; /*add specific login error*/
//    }

//        {
//            model.addAttribute("user", user);
//            model.addAttribute("error", "Internal server error , please try again");
//            return "createAcct";
//        }
    }
}

//        model.addAttribute("success", "You will receive an email to activate your account. If you don't find in your Inbox, please check your spam/junk mail as well.");
//        return "success";

