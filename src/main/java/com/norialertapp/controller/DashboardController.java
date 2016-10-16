package com.norialertapp.controller;

import com.norialertapp.entity.*;
import com.norialertapp.repository.ProductRepo;
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

import java.util.*;

/**
 * Created by katherine_celeste on 10/12/16.
 */

@Controller
public class DashboardController {

    @Autowired
    UserService userService;

    @Autowired
    ShopifyService shopifyService;

    @Autowired
    public ProductService productService;

    @Autowired
    public QtyLevelRepo qtyLevelRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    SearchService searchService;

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String searchUsingValues(Search search, Model model) {

        Set<Product> productListA = new HashSet<>(productRepo.findById(search.getProductID()));
        Set<Product> productListB = null;
        Set<Product> productListC = null;

        if (!search.getVendorName().equals("")) {
            productListB = new HashSet<>(productRepo.findByVendorIgnoreCaseContaining(search.getVendorName()));
        }

        if (!search.getItemName().equals("")) {
            productListC = new HashSet<>(productRepo.findByTitleIgnoreCaseContaining(search.getItemName()));
        }

//        HashMap<Long, String> qtyLevels = searchService.qtyLevels(); // Grab list of products with their qtyLevel (based on current inventory levels)

        List<Long> productIDs = new ArrayList<>(); // initialize blank list of productID's

        Set<Product> productListD = new HashSet<>();

//        for (HashMap.Entry<Long, String> product : qtyLevels.entrySet()) { //iterate through HashMap and add products to list that
//            if (product.getValue().equals(search.getQtyLevel()))              //match qtyLevel search criteria
//            {
//                productIDs.add(product.getKey());
//            }
//        }

        for (Long id : productIDs) { // add products to master list
            Product aProduct = productRepo.findOne(id);
            productListD.add(aProduct);
        }

        //Need unique list of products - use Set to accomplish this
        Set<Product> uniqueProductList = new HashSet<>();

        uniqueProductList.addAll(productListA);

        if (productListB != null) {
            uniqueProductList.addAll(productListB);
        }
        if (productListC != null) {
            uniqueProductList.addAll(productListC);
        }
        uniqueProductList.addAll(productListD);

        HashMap<Long, Integer> qty = searchService.qty();

//        model.addAttribute("qtyLevels", qtyLevels);
        model.addAttribute("qty", qty);

        if ((productListA.size() > 0) || (!search.getVendorName().equals("")) || (!search.getQtyLevel().equals("")) || (productListD.size() > 0)) {

            model.addAttribute("products", uniqueProductList);
        } else {
            model.addAttribute("products", productService.listProducts());
        }

        return "dashboard";
    }
}
