package com.norialertapp.service;

import com.norialertapp.entity.*;
import com.norialertapp.repository.QtyLevelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

/**
 * Created by katherine_celeste on 10/12/16.
 */

@Service
public class SearchService {

    @Autowired
    QtyLevelRepo qtyLevelRepo;

    private HashMap<Long, String> qtyLevels;

    private HashMap<Long, Integer> qty;

    public void searchShopifyProductsList(List<Product> products) {

        // productID mapped to quantity levels (determined by user - High/Low/Out)
        qtyLevels = new HashMap<>();

        // productID mapped to quantity
        qty = new HashMap<>();

        for (Product product : products) { // for each product
            QtyLevel productLevel = qtyLevelRepo.findByProductid(product.getId()); // grab list of levels
            //compare quantity of product to what user consider high, low, outOfStock
            for (Variant variant : product.getVariants()) {
                qty.put(product.getId(), variant.getInventory_quantity()); // create list of qty's for parts
            }

            Integer outNum = -1;
            if (!(productLevel == null)) {
                    for (Level level : productLevel.getProductLevels()) {
                        if (level.getQuantity() != null) {
                            if (level.getCustomLevel().equals("Out")) {
                                outNum = level.getQuantity();
                            } // find the out qty to use in the loop below:
                        }
                    }
            }

            if (!(productLevel == null)) {
                for (Variant variant : product.getVariants()) {
                    for (Level level : productLevel.getProductLevels())
                    //retrieve quantity for each product
                    {
                        if (level.getQuantity() != null) { //if user has input qty for fields
                            if ((level.getCustomLevel().equals("High")) &&
                                    (variant.getInventory_quantity() >= level.getQuantity()))
                            {
                                qtyLevels.put(product.getId(), level.getCustomLevel());
                            }

                            else if (level.getCustomLevel().equals("Low") &&
                                    ((variant.getInventory_quantity() <= level.getQuantity()) &&
                                            (variant.getInventory_quantity() > outNum)))
                            {
                                qtyLevels.put(product.getId(), level.getCustomLevel());
                            }
                            else if ((level.getCustomLevel().equals("Out")) &&
                                    (variant.getInventory_quantity() <= level.getQuantity()) )
                            {
                                qtyLevels.put(product.getId(), level.getCustomLevel());
                            }
                        }
                    }
                }
            }
        }
    }

    public HashMap<Long, String> qtyLevels() {
        return qtyLevels;
    }

    public HashMap<Long, Integer> qty() {
        return qty;
    }
}
