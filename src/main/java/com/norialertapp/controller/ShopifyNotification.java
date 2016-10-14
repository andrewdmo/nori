package com.norialertapp.controller;
import com.norialertapp.entity.CatchHook;
import com.norialertapp.entity.LineItem;
import com.norialertapp.entity.Product;
import com.norialertapp.entity.Variant;
import com.norialertapp.repository.CatchHookRepo;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.service.OrderCreatedService;
import com.norialertapp.service.ShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

/**
 * Created by katherine_celeste on 10/5/16.
 */

@RestController
public class ShopifyNotification {

    @Autowired
    public OrderCreatedService orderCreatedService;

    @Autowired
    public ShopifyService shopifyService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CatchHookRepo catchHookRepo;

    //ERROR: updates multiple times! Why?
    //Possible answer: multiple order possibilities: order fufilled, order paid, etc.
    @RequestMapping(path = "/order/payment")
    public String caughtHook(@RequestBody CatchHook catchHook) {

        // if hook hasn't already been processed (doesn't yet exist in table)...
        // don't repeat multiple times?
        if(catchHookRepo.findOne(catchHook.getId())==null) {

            List<LineItem> lineItems = catchHook.getLine_items();

            HashMap<Long, Integer> productIDs = new HashMap<>(); // create list of productID's from JSON order


            for (LineItem lineItem : lineItems) {
                Integer qty = lineItem.getQuantity(); // get qty from JSON order
                productIDs.put(lineItem.getProduct_id(), qty);
            }

            for (HashMap.Entry<Long, Integer> product : productIDs.entrySet()) { //iterate through HashMap and add products to list that

                // get current qty...in 3 simple steps:D
                Product a = productRepo.findOne(product.getKey());
                List<Variant> variant = a.getVariants();
                Integer qty = variant.get(0).getInventory_quantity();

                Integer updatedQty = qty - product.getValue();

                Product aProduct = productRepo.getOne(product.getKey());
                aProduct.getVariants().get(0).setInventory_quantity(updatedQty); // update Product with revised Qty

                productRepo.save(aProduct);

            }
        }
        return "";
    }


    // If someone manually updates inventory:
    @RequestMapping(path = "/products/update")
    public String caughtHook(@RequestBody Product product) {

            productRepo.save(product);

        return "";
    }
}
