package com.ilexes.web;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;
import com.ilexes.service.ApplicationService;
import com.ilexes.util.CommonMessages;
import io.swagger.v3.oas.annotations.media.Content;
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
import java.util.Collection;

import static com.ilexes.util.ErrorHandlingUtil.handleValidationErrors;
import static com.ilexes.web.ApiMimeType.APPLICATION_COLLECTION_TYPE;
import static com.ilexes.web.ApiMimeType.APPLICATION_TYPE;

@RestController
@RequestMapping("/applications")
@Tag(name = "Application Controller")
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

public class ApplicationRestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(produces = APPLICATION_COLLECTION_TYPE)
    public Collection<ApplicationExposeDTO> findAll() {
        return applicationService.findAll();
    }

    @GetMapping(value = "/{id:\\d+}", produces = APPLICATION_TYPE)
    public ApplicationExposeDTO findById(@PathVariable("id") Long id) {
        return applicationService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<ApplicationExposeDTO> create(@Valid @RequestBody ApplicationSeedDTO applicationSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        ApplicationExposeDTO applicationExposeDTO = applicationService.create(applicationSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(applicationExposeDTO.getId()).toUri())
                .body(applicationExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        applicationService.deleteById(id);
        return new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.OK);
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
