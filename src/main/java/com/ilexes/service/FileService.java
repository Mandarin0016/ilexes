package com.ilexes.service;

import com.ilexes.model.dto.expose.file.FileExposeDTO;
import com.ilexes.model.dto.seed.file.FileSeedDTO;

import java.util.Collection;

public interface FileService {
    Collection<FileExposeDTO> findAll();
    FileExposeDTO findById(Long id);
    FileExposeDTO create(FileSeedDTO fileSeedDTO);
    FileExposeDTO update(FileSeedDTO fileSeedDTO, Long id);
    void deleteById(Long id);

}
