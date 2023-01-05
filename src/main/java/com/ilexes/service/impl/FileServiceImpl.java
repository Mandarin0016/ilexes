package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.file.FileExposeDTO;
import com.ilexes.model.dto.seed.file.FileSeedDTO;
import com.ilexes.service.FileService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public Collection<FileExposeDTO> findAll() {
        return null;
    }

    @Override
    public FileExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public Collection<FileExposeDTO> findByName(String fileName) {
        return null;
    }

    @Override
    public Collection<FileExposeDTO> findByUrl(String fileUrl) {
        return null;
    }

    @Override
    public FileExposeDTO create(FileSeedDTO fileSeedDTO) {
        return null;
    }

    @Override
    public FileExposeDTO update(FileSeedDTO fileSeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
