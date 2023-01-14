package com.ilexes.model.dto.seed.file;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class FileSeedDTO {
    @Size(min = 2)
    @NotBlank
    private String fileName;
    @URL
    @NotBlank
    private String fileUrl;
}
