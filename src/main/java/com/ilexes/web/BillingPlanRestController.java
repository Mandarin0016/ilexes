package com.ilexes.web;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.expose.billingPlan.BillingPlanExposeDTO;
import com.ilexes.model.dto.seed.billingPlan.BillingPlanSeedDTO;
import com.ilexes.service.ApplicationService;
import com.ilexes.service.BillingPlanService;
import com.ilexes.util.CommonMessages;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@Tag(name = "Plan Controller")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Request was successful."),
        @ApiResponse(
                responseCode = "400",
                description = "You made a bad request."),
        @ApiResponse(
                responseCode = "401",
                description = "You did not have valid credentials."),
        @ApiResponse(
                responseCode = "403",
                description = "You do not have permission to execute a request."),
        @ApiResponse(
                responseCode = "500",
                description = "An internal server error occurred.")})

public class BillingPlanRestController {
    private final BillingPlanService billingPlanService;
    private final ApplicationService applicationService;

    @Autowired
    public BillingPlanRestController(BillingPlanService billingPlanService, ApplicationService applicationService) {
        this.billingPlanService = billingPlanService;
        this.applicationService = applicationService;
    }

    @GetMapping()
    public Collection<BillingPlanExposeDTO> findAll() {
        return billingPlanService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public BillingPlanExposeDTO findById(@PathVariable("id") Long id) {
        return billingPlanService.findById(id);
    }

    @PostMapping
    public ResponseEntity<BillingPlanExposeDTO> create(@Valid @RequestBody BillingPlanSeedDTO billingPlanSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        BillingPlanExposeDTO billingPlanExposeDTO = billingPlanService.create(billingPlanSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(billingPlanExposeDTO.getId()).toUri())
                .body(billingPlanExposeDTO);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<BillingPlanExposeDTO> update(@Valid @RequestBody BillingPlanSeedDTO billingPlanSeedDTO, @PathVariable("id") Long id, Errors errors) {
        handleValidationErrors(errors);
        BillingPlanExposeDTO billingPlanExposeDTO = billingPlanService.update(billingPlanSeedDTO, id);
        return ResponseEntity.ok(billingPlanExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        billingPlanService.deleteById(id);
        return new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return billingPlanService.count();
    }

    @PostMapping("/{id:\\d+}/applications")
    public Collection<ApplicationExposeDTO> addNewApplication(@PathVariable("id") Long id, @RequestBody String... name) {
        Collection<ApplicationExposeDTO> applications = applicationService.findAllByName(Arrays.stream(name).toList());
        return billingPlanService.addApplications(id, applications);
    }

    @DeleteMapping("/{id:\\d+}/applications")
    public Collection<ApplicationExposeDTO> removeApplication(@PathVariable("id") Long id, @RequestParam(name = "name", defaultValue = "") String name) {
        return billingPlanService.removeApplication(id, name);
    }

    @GetMapping("/{id:\\d+}/applications")
    public Collection<ApplicationExposeDTO> findAllApplications(@PathVariable("id") Long id) {
        return billingPlanService.findAllApplications(id);
    }
}
