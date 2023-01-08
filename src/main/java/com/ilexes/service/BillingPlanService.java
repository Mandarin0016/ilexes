package com.ilexes.service;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.expose.billingPlan.BillingPlanExposeDTO;
import com.ilexes.model.dto.seed.billingPlan.BillingPlanSeedDTO;

import java.util.Collection;

public interface BillingPlanService {
    Collection<BillingPlanExposeDTO> findAll();
    BillingPlanExposeDTO findById(Long id);
    BillingPlanExposeDTO update(BillingPlanSeedDTO billingPlanSeedDTO, Long id);
    BillingPlanExposeDTO create(BillingPlanSeedDTO billingPlanSeedDTO);
    void deleteById(Long id);
    Long count();
    Collection<ApplicationExposeDTO> addNewApplications(Long id, Collection<ApplicationExposeDTO> applications);
}
