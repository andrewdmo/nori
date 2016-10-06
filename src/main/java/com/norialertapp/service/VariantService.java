package com.norialertapp.service;

import com.norialertapp.entity.Variant;
import com.norialertapp.repository.VariantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by katherine_celeste on 10/6/16.
 */

@Service
public class VariantService {

    @Autowired
    VariantRepo variantRepo;

    public void saveVariant(Variant variant) {
        variantRepo.save(variant);
    }

}
