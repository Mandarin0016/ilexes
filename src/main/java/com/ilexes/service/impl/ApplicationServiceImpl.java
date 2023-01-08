package com.ilexes.service.impl;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.NonExistingEntityException;
import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;
import com.ilexes.model.entity.Application;
import com.ilexes.repository.ApplicationRepository;
import com.ilexes.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.ilexes.exception.ExceptionMessages.BILLING_PLAN_DOES_NOT_EXIST;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;

    @Autowired
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
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.APPLICATION_DOES_NOT_EXIST, id)));

    }

    @Override
    public ApplicationExposeDTO update(ApplicationSeedDTO applicationSeedDTO, Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.APPLICATION_DOES_NOT_EXIST, id)));
        modelMapper.map(applicationSeedDTO, application);
        applicationRepository.save(application);
        return modelMapper.map(application, ApplicationExposeDTO.class);
    }

    @Override
    public ApplicationExposeDTO create(ApplicationSeedDTO applicationSeedDTO) {
        Application application = applicationRepository.save(modelMapper.map(applicationSeedDTO, Application.class));
        return modelMapper.map(application, ApplicationExposeDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new NonExistingEntityException(String.format(ExceptionMessages.RESOURCE_WITH_ID_DOES_NOT_EXIST, id));
        }
        applicationRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return applicationRepository.count();
    }

    @Override
    public Collection<ApplicationExposeDTO> findAllByName(Collection<String> name) {
        return applicationRepository.findAllByNameIn(name).stream().map(application -> modelMapper.map(application, ApplicationExposeDTO.class)).collect(Collectors.toList());
    }
}
