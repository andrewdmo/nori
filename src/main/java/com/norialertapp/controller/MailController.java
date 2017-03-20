package com.norialertapp.controller;
import com.norialertapp.entity.Level;
import com.norialertapp.entity.Product;
import com.norialertapp.entity.QtyAlertTriggerLevel;
import com.norialertapp.entity.QtyLevel;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.repository.QtyLevelRepo;
import com.norialertapp.repository.QtyTriggerRepo;
import com.norialertapp.service.ProductServiceImpl;
import com.norialertapp.service.TriggerMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by katherine_celeste on 10/9/16.
 */

@Controller
public class MailController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private QtyTriggerRepo qtyTriggerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private QtyLevelRepo qtyLevelRepo;

    @Autowired
    private TriggerMailService triggerMailService;

    @RequestMapping(path="/mail", method= RequestMethod.POST)
    public String sendMail(String qty, Long id, Model model) throws MessagingException {

        Product product = productRepo.findOne(id);

        QtyAlertTriggerLevel levelSelected = new QtyAlertTriggerLevel();
        levelSelected.setQtyTrigger(qty);
        levelSelected.setProductId(id);

        // can only save one qty alert per product
        // if qtyTrigger already exists, delete!
        if(qtyTriggerRepo.findByProductId(id)!=null){
            qtyTriggerRepo.delete(qtyTriggerRepo.findByProductId(id).getId());
        }

        qtyTriggerRepo.save(levelSelected);

        triggerMailService.triggerEmail(qty, id);

        QtyLevel productLevels = qtyLevelRepo.findByProductid(id);
        String alertTrigger = "";
        if(qtyTriggerRepo.findByProductId(id)!=null){
            alertTrigger = qtyTriggerRepo.findByProductId(id).getQtyTrigger();}

        List<Level> levels = productLevels.getProductLevels();
        Integer highLevel = -1;
        Integer lowLevel = -1;
        Integer outLevel = -1;

        for(Level level: levels){
            if(level.getCustomLevel().equals("High")){
                highLevel = level.getQuantity();
            }
            else if (level.getCustomLevel().equals("Low")){
                lowLevel = level.getQuantity();
            }
            else {
                outLevel = level.getQuantity();
            }
        }

        productLevels.setProductLevels(levels);


        model.addAttribute("alertTrigger", alertTrigger);
        model.addAttribute("highLevel", highLevel);
        model.addAttribute("lowLevel", lowLevel);
        model.addAttribute("outLevel", outLevel);

        String levelSet = "Level Set Successfully!";
        Product sameProduct = productServiceImpl.retrieveProduct(id);
        Integer productQty = product.getVariants().get(0).getInventory_quantity();
        String imagePic = product.getImages().get(0).getSrc();
        model.addAttribute("levelSetMessage", levelSet);
        model.addAttribute("imagePic", imagePic);
        model.addAttribute("aProduct", sameProduct);
        model.addAttribute("productQty", productQty);


        return "product-detail";
    }
}


