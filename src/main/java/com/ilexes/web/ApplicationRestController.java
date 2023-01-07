package com.ilexes.web;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;
import com.ilexes.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
