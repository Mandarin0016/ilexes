package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.billingPlan.BillingPlanExposeDTO;
import com.ilexes.model.dto.seed.billingPlan.BillingPlanSeedDTO;
import com.ilexes.service.BillingPlanService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BillingPlanServiceImpl implements BillingPlanService {
    @Override
    public Collection<BillingPlanExposeDTO> findAll() {
        return null;
    }

    @Override
    public BillingPlanExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public BillingPlanExposeDTO update(BillingPlanSeedDTO billingPlanSeedDTO, Long id) {
        return null;
    }

    @Override
    public BillingPlanExposeDTO create(BillingPlanSeedDTO billingPlanSeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
