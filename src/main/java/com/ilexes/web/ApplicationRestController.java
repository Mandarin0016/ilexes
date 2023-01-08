package com.ilexes.web;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;
import com.ilexes.service.ApplicationService;
import com.ilexes.util.CommonMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

import static com.ilexes.util.ErrorHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/applications")
public class ApplicationRestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping()
    public Collection<ApplicationExposeDTO> findAll() {
        return applicationService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public ApplicationExposeDTO findById(@PathVariable("id") Long id) {
        return applicationService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<ApplicationExposeDTO> create(@Valid @RequestBody ApplicationSeedDTO applicationSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        ApplicationExposeDTO applicationExposeDTO =  applicationService.create(applicationSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(applicationExposeDTO.getId()).toUri())
                .body(applicationExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean isDeleted = applicationService.deleteById(id);
        return isDeleted ? new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.OK)
                : new ResponseEntity<>(String.format(CommonMessages.RESOURCE_WITH_ID_DOES_NOT_EXIST, id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<ApplicationExposeDTO> update(@Valid @RequestBody ApplicationSeedDTO applicationSeedDTO, @PathVariable("id") Long id, Errors errors) {
        handleValidationErrors(errors);
        ApplicationExposeDTO applicationExposedDTO = applicationService.update(applicationSeedDTO, id);
        return ResponseEntity.ok(applicationExposedDTO);
    }

    @GetMapping("/count")
    public Long count() {
        return applicationService.count();
    }

}
