package com.ilexes.service.impl;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.NonExistingEntityException;
import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.expose.billingPlan.BillingPlanExposeDTO;
import com.ilexes.model.dto.seed.billingPlan.BillingPlanSeedDTO;
import com.ilexes.model.entity.Application;
import com.ilexes.model.entity.BillingPlan;
import com.ilexes.repository.BillingPlanRepository;
import com.ilexes.service.BillingPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.ilexes.exception.ExceptionMessages.BILLING_PLAN_DOES_NOT_EXIST;
import static com.ilexes.exception.ExceptionMessages.RESOURCE_WITH_ID_DOES_NOT_EXIST;

@Service
public class BillingPlanServiceImpl implements BillingPlanService {

    private final BillingPlanRepository billingPlanRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BillingPlanServiceImpl(BillingPlanRepository billingPlanRepository, ModelMapper modelMapper) {
        this.billingPlanRepository = billingPlanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<BillingPlanExposeDTO> findAll() {
        return billingPlanRepository
                .findAll()
                .stream()
                .map(plan -> modelMapper.map(plan, BillingPlanExposeDTO.class))
                .toList();
    }

    @Override
    public BillingPlanExposeDTO findById(Long id) {
        return billingPlanRepository
                .findById(id)
                .map(plan -> modelMapper.map(plan, BillingPlanExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(BILLING_PLAN_DOES_NOT_EXIST, id)));
    }

    @Override
    public BillingPlanExposeDTO update(BillingPlanSeedDTO billingPlanSeedDTO, Long id) {
        BillingPlan billingPlan = billingPlanRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format(BILLING_PLAN_DOES_NOT_EXIST, id)));
        modelMapper.map(billingPlanSeedDTO, billingPlan);
        billingPlanRepository.save(billingPlan);
        return modelMapper.map(billingPlan, BillingPlanExposeDTO.class);
    }

    @Override
    public BillingPlanExposeDTO create(BillingPlanSeedDTO billingPlanSeedDTO) {
        BillingPlan plan = billingPlanRepository.save(modelMapper.map(billingPlanSeedDTO, BillingPlan.class));
        return modelMapper.map(plan, BillingPlanExposeDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!billingPlanRepository.existsById(id)) {
            throw new NonExistingEntityException(String.format(RESOURCE_WITH_ID_DOES_NOT_EXIST, id));
        }
        BillingPlan billingPlan = billingPlanRepository.findById(id).get();
        billingPlan.getApplicationsIncluded().clear();
        billingPlanRepository.save(billingPlan);
        billingPlanRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return billingPlanRepository.count();
    }

    @Override
    public Collection<ApplicationExposeDTO> addNewApplications(Long id, Collection<ApplicationExposeDTO> applications) {
        BillingPlan billingPlan = billingPlanRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format(BILLING_PLAN_DOES_NOT_EXIST, id)));
        billingPlan.getApplicationsIncluded().addAll(applications.stream().map(dto -> modelMapper.map(dto, Application.class)).toList());
        billingPlanRepository.save(billingPlan);
        return billingPlan.getApplicationsIncluded().stream().map(app -> modelMapper.map(app, ApplicationExposeDTO.class)).toList();
    }
}
