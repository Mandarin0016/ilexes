package com.ilexes.web;
import com.ilexes.model.dto.expose.location.LocationExposeDTO;
import com.ilexes.model.dto.seed.location.LocationSeedDTO;
import com.ilexes.service.LocationService;
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
import java.util.Collection;
import static com.ilexes.util.ErrorHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/locations")
@Tag(name = "Location Controller")
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

public class LocationRestController {

    private final LocationService locationService;

    @Autowired
    public LocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/count")
    public Long count() {
        return locationService.count();
    }

    @GetMapping()
    public Collection<LocationExposeDTO> findAll(){
        return locationService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public LocationExposeDTO findById(@PathVariable("id") Long id) {
        return locationService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<LocationExposeDTO> create(@Valid @RequestBody LocationSeedDTO locationSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        LocationExposeDTO locationExposeDTO = locationService.create(locationSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(locationExposeDTO.getId()).toUri())
                .body(locationExposeDTO);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<LocationExposeDTO> update(@Valid @RequestBody LocationSeedDTO locationSeedDTO, @PathVariable("id") Long id, Errors errors) {
        handleValidationErrors(errors);
        LocationExposeDTO locationExposeDTO = locationService.update(locationSeedDTO, id);
        return ResponseEntity.ok(locationExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        locationService.deleteById(id);
        return new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.OK);
    }

}
