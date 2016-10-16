package com.norialertapp.service;

import com.norialertapp.entity.Level;
import com.norialertapp.entity.Product;
import com.norialertapp.entity.QtyAlertTriggerLevel;
import com.norialertapp.entity.QtyLevel;
import com.norialertapp.repository.ProductRepo;
import com.norialertapp.repository.QtyLevelRepo;
import com.norialertapp.repository.QtyTriggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by katherine_celeste on 10/14/16.
 */

@Service
public class TriggerMailService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    QtyTriggerRepo qtyTriggerRepo;

    @Autowired
    QtyLevelRepo qtyLevelRepo;

    @Autowired
    MailClient mailClient;

    public void triggerEmail(String qty, Long id) throws MessagingException {

        Product product = productRepo.findOne(id);

        QtyAlertTriggerLevel levelSelected = new QtyAlertTriggerLevel();
        levelSelected.setQtyTrigger(qty);
        levelSelected.setProductId(id);


        Integer currentInventoryQty = product.getVariants().get(0).getInventory_quantity();

        QtyLevel qtyLevel = qtyLevelRepo.findByProductid(product.getId()); // grab QtyLevel object

        Integer out = -1;


        if(qtyLevel!=null) {
            List<Level> levels = qtyLevel.getProductLevels(); // grab levels list
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
                        mailClient.send("peruvianplatafinaalerts@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                                "of stock. Cheers! -Nori");
                    }
                    break;

                case "Low":
                    if ((currentInventoryQty <= triggerQty) && (currentInventoryQty > out)) {
                        mailClient.send("peruvianplatafinaalerts@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                                "of stock. Cheers! -Nori");
                    }
                    break;
                case "Out":
                    if (currentInventoryQty <= triggerQty) {
                        mailClient.send("peruvianplatafinaalerts@gmail.com", "Inventory Alert: Items Low/Out of Stock", "You currently have one or more items out" +
                                "of stock. Cheers! -Nori");
                        break; // optional
                    }

            }
        }}
}
