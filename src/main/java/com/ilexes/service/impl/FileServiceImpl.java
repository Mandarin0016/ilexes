package com.ilexes.service.impl;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.NonExistingEntityException;
import com.ilexes.model.dto.expose.file.FileExposeDTO;
import com.ilexes.model.dto.seed.file.FileSeedDTO;
import com.ilexes.model.entity.InputFile;
import com.ilexes.repository.FileRepository;
import com.ilexes.service.FileService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.ilexes.exception.ExceptionMessages.BILLING_PLAN_DOES_NOT_EXIST;
import static com.ilexes.exception.ExceptionMessages.RESOURCE_WITH_ID_DOES_NOT_EXIST;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public FileServiceImpl(FileRepository fileRepository, ModelMapper modelMapper) {
        this.fileRepository = fileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<FileExposeDTO> findAll() {
        return fileRepository.findAll()
                .stream()
                .map(file -> modelMapper.map(file, FileExposeDTO.class))
                .toList();
    }

    @Override
    public FileExposeDTO findById(Long id) {
        return fileRepository.findById(id)
                .map(file -> modelMapper.map(file, FileExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.FILE_DOES_NOT_EXIST, id)));
    }

    @Override
    public FileExposeDTO create(FileSeedDTO fileSeedDTO) {
        InputFile file = modelMapper.map(fileSeedDTO, InputFile.class);
        fileRepository.save(file);
        return modelMapper.map(file, FileExposeDTO.class);
    }

    @Override
    public FileExposeDTO update(FileSeedDTO fileSeedDTO, Long id) {
        InputFile file = fileRepository.findById(id).orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.FILE_DOES_NOT_EXIST, id)));
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        modelMapper.map(fileSeedDTO, file);
        fileRepository.save(file);
        return modelMapper.map(file, FileExposeDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!fileRepository.existsById(id)) {
            throw new NonExistingEntityException(String.format(RESOURCE_WITH_ID_DOES_NOT_EXIST, id));
        }
        fileRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return fileRepository.count();
    }
}
