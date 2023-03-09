package com.ilexes.web;
import com.ilexes.model.dto.expose.file.FileExposeDTO;
import com.ilexes.model.dto.seed.file.FileSeedDTO;
import com.ilexes.service.FileService;
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
@RequestMapping("/files")
@Tag(name = "File Controller")
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

public class FileRestController {

    private final FileService fileService;

    @Autowired
    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping()
    public Collection<FileExposeDTO> findAll() {
        return fileService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public FileExposeDTO findById(@PathVariable("id") Long id) {
        return fileService.findById(id);
    }

    @GetMapping("/count")
    public Long count() {
        return fileService.count();
    }

    @PostMapping()
    public ResponseEntity<FileExposeDTO> create(@Valid @RequestBody FileSeedDTO fileSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        FileExposeDTO fileExposeDTO = fileService.create(fileSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(fileExposeDTO.getId()).toUri())
                .body(fileExposeDTO);
    }

    @PutMapping("/{id:\\d+}")
    public FileExposeDTO update(@Valid @RequestBody FileSeedDTO fileSeedDTO, @PathVariable("id") Long id, Errors errors) {
        handleValidationErrors(errors);
        return fileService.update(fileSeedDTO, id);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        fileService.deleteById(id);
        return new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.OK);
    }

}
