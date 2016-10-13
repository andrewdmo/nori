package com.norialertapp.controller;
import com.norialertapp.entity.Level;
import com.norialertapp.entity.Product;
import com.norialertapp.entity.QtyAlertTriggerLevel;
import com.norialertapp.entity.QtyLevel;
import com.norialertapp.repository.LevelRepo;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.repository.QtyLevelRepo;
import com.norialertapp.repository.QtyTriggerRepo;
import com.norialertapp.service.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by katherine_celeste on 10/9/16.
 */

@Controller
public class MailController {
    //
    @Autowired
    private MailClient mailClient;

    @Autowired
    private QtyTriggerRepo qtyTriggerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private LevelRepo levelRepo;

    @Autowired
    private QtyLevelRepo qtyLevelRepo;

    @RequestMapping(path="/mail", method= RequestMethod.POST)
    public String sendMail(String qty, Long id) throws MessagingException {

        Product product = productRepo.findOne(id);

        QtyAlertTriggerLevel levelSelected = new QtyAlertTriggerLevel();
        levelSelected.setQtyTrigger(qty);
        levelSelected.setProductId(id);

        qtyTriggerRepo.save(levelSelected);

        Integer currentInventoryQty = product.getVariants().get(0).getInventory_quantity();

        QtyLevel qtyLevel = qtyLevelRepo.findByProductid(product.getId()); // grab QtyLevel object

        Integer out = -1;


        if(qtyLevel.getProductLevels()!=null) {
            List <Level> levels = qtyLevel.getProductLevels(); // grab levels list
            Integer triggerQty = 0;
            for (Level level : levels) { //iterate through list to find the triggerQty
                if (level.getCustomLevel().equals(qty))
                    triggerQty = level.getQuantity();
                if (level.getCustomLevel().equals("Out")) {
                    out = level.getQuantity();
                }
            }
            switch (qty) {
                case "High":
                    if (currentInventoryQty >= triggerQty) {
                        mailClient.send("kceleste35@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                                "of stock. Cheers! -Nori");
                    }
                    break;

                case "Low":
                    if ((currentInventoryQty <= triggerQty) && (currentInventoryQty > out)) {
                        mailClient.send("kceleste35@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                                "of stock. Cheers! -Nori");
                    }
                    break;
                case "Out":
                    if (currentInventoryQty <= triggerQty) {
                        mailClient.send("kceleste35@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                                "of stock. Cheers! -Nori");
                        break; // optional
                    }

            }
            return "success"; // text should read "level set successfully"
        }
        return "error";  // create error page
    }
}


