package com.norialertapp.controller;
import com.norialertapp.entity.*;
import com.norialertapp.repository.ImageRepo;
import com.norialertapp.repository.LevelRepo;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.repository.QtyLevelRepo;
import com.norialertapp.service.ProductService;
import com.norialertapp.service.ProductServiceImpl;
import com.norialertapp.service.SearchService;
import com.norialertapp.service.ShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by katherine_celeste on 9/29/16.
 */

@Controller
public class ShopifyController {

    @Autowired
    public ShopifyService shopifyService;

    @Autowired
    public ProductRepo productRepo;

    @Autowired
    public ProductService productService;

    @Autowired
    public ProductServiceImpl productServiceImpl;

    @Autowired
    public QtyLevelRepo qtyLevelRepo;

    @Autowired
    public ImageRepo imageRepo;

    @Autowired
    LevelRepo levelRepo;

    @Autowired
    SearchService searchService;

    @RequestMapping(path = "/", method=RequestMethod.GET)
    public String listProducts(){

        return "login";
    }

    @RequestMapping(path = "/dashboard")
    public String dashboard(Model model){
// load list of products from Shopify
        List<Product> products = shopifyService.getAndSaveProducts();

        searchService.searchShopifyProductsList(products);

        HashMap<Long, String> qtyLevels= searchService.qtyLevels();
        HashMap <Long, Integer> qty = searchService.qty();

        model.addAttribute("qtyLevels", qtyLevels);
        model.addAttribute("qty", qty);

        model.addAttribute("products", productService.listProducts());
        return "dashboard";
    }

    @RequestMapping(path = "/{product.id}", method=RequestMethod.GET)
    public String individualProduct(@PathVariable("product.id") final Long productId, Model model){

        Product product = productServiceImpl.retrieveProduct(productId);
        Integer productQty = product.getVariants().get(0).getInventory_quantity();
        String imagePic = product.getImages().get(0).getSrc();
        model.addAttribute("imagePic", imagePic);
        model.addAttribute("aProduct", product);
        model.addAttribute("productQty", productQty);

        return "product-detail";
    }

    @RequestMapping(path = "/storeQty", method=RequestMethod.POST)
    public String storeQtys(Integer high, Integer low, Integer out, Long id, Model model){

        QtyLevel productLevels = new QtyLevel();
        productLevels.setProductid(id);

        ArrayList<Level> levels = new ArrayList<>();

        Level highLevel = new Level();
        Level lowLevel = new Level();
        Level outLevel = new Level();

        highLevel.setCustomLevel("High");
        lowLevel.setCustomLevel("Low");
        outLevel.setCustomLevel("Out");

        highLevel.setQuantity(high);
        lowLevel.setQuantity(low);
        outLevel.setQuantity(out);

        levels.add(highLevel);
        levels.add(lowLevel);
        levels.add(outLevel);

        productLevels.setProductLevels(levels);

        if(qtyLevelRepo.findByProductid(id)!=null) { // if levels already exist, we need to override
            qtyLevelRepo.delete(qtyLevelRepo.findByProductid(id));
        }

        qtyLevelRepo.save(productLevels);


        Product product = productServiceImpl.retrieveProduct(id);
        Integer productQty = product.getVariants().get(0).getInventory_quantity();
        ProductImage image = product.getImages().get(0);
        String imageSrc = image.getSrc();
        model.addAttribute("qtyRulesMessage", "Rules Set Successfully!");
        model.addAttribute("productQty", productQty);
        model.addAttribute("imagePic", imageSrc);
        model.addAttribute("aProduct", product);
        model.addAttribute("highLevel", highLevel.getQuantity());
        model.addAttribute("lowLevel", lowLevel.getQuantity());
        model.addAttribute("outLevel", outLevel.getQuantity());

        return "product-detail";
    }
//    @RequestMapping(value = "/{event.id}", method = RequestMethod.GET)
//    public Event getEvent(@PathVariable("event.id") final Integer eventId) {
//        return eventService.getEvent(eventId);
//    }
}
