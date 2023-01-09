package com.ilexes.web;
import com.ilexes.model.dto.expose.file.FileExposeDTO;
import com.ilexes.model.dto.seed.file.FileSeedDTO;
import com.ilexes.service.FileService;
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
@RequestMapping("/files")
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

    //при ъпдейт клиента не е нужен да дава всички параметри на файла, modelMaper-a ще игнорира нъл стойностите и ще ъпдейтне само каквото сме му подали :)
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
