package com.norialertapp.service;

import com.norialertapp.entity.*;
import com.norialertapp.repository.QtyLevelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by katherine_celeste on 10/12/16.
 */

@Service
public class SearchService {

    @Autowired
    QtyLevelRepo qtyLevelRepo;

    HashMap<Long, String> qtyLevels;

    HashMap<Long, Integer> qty;

    public void searchShopifyProductsList(List<Product> products){

        List listOfInfo = new ArrayList();



        // productID mapped to quantity levels (determined by user - High/Low/Out)
        qtyLevels = new HashMap<>();

        // productID mapped to quantity
        qty = new HashMap<>();

        for (Product product : products) {
            QtyLevel productLevel = qtyLevelRepo.findByProductid(product.getId());
            //compare quantity of product to what user consider high, low, outOfStock
            for (Variant variant : product.getVariants()) {
                qty.put(product.getId(), variant.getInventory_quantity());
            }
            if (!(productLevel == null)) {
                for (Level level : productLevel.getProductLevels())
                    //retrieve quantity for each product
                    for (Variant variant : product.getVariants()) {
                        //  qty.put(product.getId(), variant.getInventory_quantity());
                        //THIS IS LIKELY INCORRECT. GO BACK AND CHECK (High should be checked before Low, then OutofStock

                        if (level.getQuantity() != null) { //if user has input qty for fields
                            if (level.getQuantity() >= variant.getInventory_quantity()) {
                                qtyLevels.put(product.getId(), level.getCustomLevel());
                            }
                        }
                    }
            }
        }
    }

    public HashMap<Long, String> qtyLevels(){
        return qtyLevels;
    }

    public HashMap<Long, Integer> qty(){
        return qty;
    }
}
