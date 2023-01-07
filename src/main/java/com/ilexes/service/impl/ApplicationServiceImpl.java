package com.ilexes.service.impl;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.NonExistingEntityException;
import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;
import com.ilexes.model.entity.Application;
import com.ilexes.repository.ApplicationRepository;
import com.ilexes.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, ModelMapper modelMapper) {
        this.applicationRepository = applicationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<ApplicationExposeDTO> findAll() {
        return applicationRepository.findAll()
                .stream()
                .map(app -> modelMapper.map(app, ApplicationExposeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationExposeDTO findById(Long id) throws NonExistingEntityException {
        return applicationRepository.findById(id)
                .map(app -> modelMapper.map(app, ApplicationExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.USER_DOES_NOT_EXIST, id)));

    }


    @Override
    public ApplicationExposeDTO update(ApplicationSeedDTO applicationSeedDTO, Long id) {
        return null;
    }

    @Override
    public ApplicationExposeDTO create(ApplicationSeedDTO applicationSeedDTO) {
        Application application = applicationRepository.save(modelMapper.map(applicationSeedDTO, Application.class));
        return modelMapper.map(application, ApplicationExposeDTO.class);
    }

    @Override
    public void deleteById(Long id) {

    }
}
