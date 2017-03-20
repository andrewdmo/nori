package com.norialertapp.service;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.entity.LineItem;
import com.norialertapp.entity.ShopifyOrder;
import com.norialertapp.repository.VariantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine_celeste on 10/7/16.
 */

@Service
public class OrderCreatedService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    VariantRepo variantRepo;

    public List<Long> productIdList(ShopifyOrder anOrder){
        List<LineItem> items = anOrder.getLine_items();

        List<Long> productIds = new ArrayList<>();

        for (LineItem item: items){
            productIds.add(item.getProduct_id());
        }

        return productIds;

    }

    public void compareValues(ShopifyOrder anOrder){
        List<Long> productIds = productIdList(anOrder);

        // retrieve list of productID's from the variant table that match the ids in the order
      //  List<Long> variantProductIds = variantRepo.findAll(productIds);

        // retrieve list of products that match the ids from the order
      //  List<Product> products =  productRepo.findAll(productIds);


//        for()



    }

    public void updateProduct(ShopifyOrder anOrder) {

       // productRepo.save(product);
    }
}
