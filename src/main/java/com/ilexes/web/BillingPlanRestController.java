package com.ilexes.web;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.expose.billingPlan.BillingPlanExposeDTO;
import com.ilexes.model.dto.seed.billingPlan.BillingPlanSeedDTO;
import com.ilexes.service.ApplicationService;
import com.ilexes.service.BillingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.Collection;

import static com.ilexes.util.ErrorHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/billing")
public class BillingPlanRestController {
    private final BillingPlanService billingPlanService;
    private final ApplicationService applicationService;

    @Autowired
    public BillingPlanRestController(BillingPlanService billingPlanService, ApplicationService applicationService) {
        this.billingPlanService = billingPlanService;
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<BillingPlanExposeDTO> create(@Valid @RequestBody BillingPlanSeedDTO billingPlanSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        BillingPlanExposeDTO billingPlanExposeDTO = billingPlanService.create(billingPlanSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(billingPlanExposeDTO.getId()).toUri())
                .body(billingPlanExposeDTO);
    }

    @PostMapping("/{id:\\d+}/applications")
    public Collection<ApplicationExposeDTO> addNewApplication(@PathVariable("id") Long id, @RequestBody String... name) {
        Collection<ApplicationExposeDTO> applications = applicationService.findAllByName(Arrays.stream(name).toList());
        return billingPlanService.addNewApplications(id, applications);
    }
}
