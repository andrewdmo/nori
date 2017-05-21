package com.norialertapp.controller;

import com.norialertapp.entity.Product;
import com.norialertapp.entity.Search;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.repository.QtyLevelRepo;
import com.norialertapp.service.ProductService;
import com.norialertapp.service.SearchService;
import com.norialertapp.service.ShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * Created by katherine_celeste on 10/12/16.
 */

@Controller
public class DashboardController {

    //forms error cycle:
//    @Autowired
//    UserService userService;

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
        Set<Product> productListD = null;

        if (!search.getVendorName().equals("")) {
            productListB = new HashSet<>(productRepo.findByVendorIgnoreCaseContaining(search.getVendorName()));
        }

        if (!search.getItemName().equals("")) {
            productListD = new HashSet<>(productRepo.findByTitleIgnoreCaseContaining(search.getItemName()));
        }

        HashMap<Long, String> qtyLevels = searchService.qtyLevels(); // Grab list of products with their qtyLevel (based on current inventory levels)

        List<Long> productIDs = new ArrayList<>(); // initialize blank list of productID's

        Set<Product> productListC = new HashSet<>();

        for (Map.Entry<Long, String> product : qtyLevels.entrySet()) { //iterate through HashMap and add products to list that
            if (product.getValue().equals(search.getQtyLevel()))              //match qtyLevel search criteria
            {
                productIDs.add(product.getKey());
            }
        }
        for (Long id : productIDs) { // add products to master list
            Product aProduct = productRepo.findOne(id);
            productListC.add(aProduct);
        }

        //Need unique list of products - use Set to accomplish this
        Set<Product> uniqueProductList = new HashSet<>();

        boolean fieldA = !(search.getProductID() == null);
        boolean fieldB = !search.getVendorName().equals("");
        boolean fieldC = !search.getQtyLevel().equals("");
        boolean fieldD = !search.getItemName().equals("");

        // if only first search field used
        if (fieldA && !fieldB && !fieldC && !fieldD) {
            uniqueProductList.addAll(productListA);
        }
        // if 2 search fields used
        else if (fieldA && fieldB && !fieldC && !fieldD) {
            uniqueProductList.addAll(productListA);
            if (productListB != null) {
                uniqueProductList.addAll(productListB);
            }
        }
        // if 3 search fields
        else if (fieldA && fieldB && fieldC && !fieldD) {
            uniqueProductList.addAll(productListA);
            if (productListB != null) {
                uniqueProductList.addAll(productListB);
            }
            uniqueProductList.addAll(productListC);

        } else if (!fieldA && fieldB && fieldC && fieldD) {
            if (productListB != null) {
                uniqueProductList.addAll(productListB);
            }

            uniqueProductList.addAll(productListC);
            if (productListD != null) {
                uniqueProductList.addAll(productListD);
            }
        } else if (!fieldA && fieldB && !fieldC && !fieldD) {
            if (productListB != null) {
                uniqueProductList.addAll(productListB);
            }
        } else if (!fieldA && fieldB && fieldC && !fieldD) {
            if (productListB != null) {
                uniqueProductList.addAll(productListB);
            }

            uniqueProductList.addAll(productListC);

        } else if (!fieldA && fieldB && !fieldC && fieldD) {
            if (productListB != null) {
                uniqueProductList.addAll(productListB);
            }
            if (productListD != null) {

                uniqueProductList.addAll(productListD);

            }
        } else if (!fieldA && !fieldB && fieldC && fieldD) {


            uniqueProductList.addAll(productListC);
            if (productListD != null) {
                uniqueProductList.addAll(productListD);
            }
        } else if (!fieldA && !fieldB && !fieldC && fieldD) {
            if (productListD != null) {
                uniqueProductList.addAll(productListD);
            }
        } else if (!fieldA && !fieldB && fieldC && !fieldD) {

            uniqueProductList.addAll(productListC);

        }

        HashMap<Long, Integer> qty = searchService.qty();

        model.addAttribute("qtyLevels", qtyLevels);
        model.addAttribute("qty", qty);

        // if search parameters were entered...add products that meet search
        if ((productListA.size() > 0) || (productListC.size() > 0) || (!search.getVendorName().equals("")) || (!search.getItemName().equals(""))) {
            model.addAttribute("products", uniqueProductList);

        } else { // show all products
            model.addAttribute("products", productService.listProducts());
        }

        return "dashboard";
    }

    @ExceptionHandler
    //add URL request query feedback later (https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc):
    public String error() {
        return "error";
    }
}
