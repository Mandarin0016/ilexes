package com.ilexes.service;

import com.ilexes.model.dto.expose.billingPlan.BillingPlanExposeDTO;
import com.ilexes.model.dto.expose.company.CompanyExposeDTO;
import com.ilexes.model.dto.seed.billingPlan.BillingPlanSeedDTO;
import com.ilexes.model.dto.seed.company.CompanySeedDTO;
import com.ilexes.model.enums.CompanyType;

import java.util.Collection;

public interface BillingPlanService {
    Collection<BillingPlanExposeDTO> findAll();
    BillingPlanExposeDTO findById(Long id);
    BillingPlanExposeDTO update(BillingPlanSeedDTO billingPlanSeedDTO, Long id);
    BillingPlanExposeDTO create(BillingPlanSeedDTO billingPlanSeedDTO);
    void deleteById(Long id);
}
