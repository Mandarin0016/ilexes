package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.company.CompanyExposeDTO;
import com.ilexes.model.dto.seed.company.CompanySeedDTO;
import com.ilexes.model.enums.CompanyType;
import com.ilexes.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Override
    public Collection<CompanyExposeDTO> findAll() {
        return null;
    }

    @Override
    public CompanyExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public Collection<CompanyExposeDTO> findAllByType(CompanyType companyType) {
        return null;
    }

    @Override
    public CompanyExposeDTO update(CompanySeedDTO companySeedDTO, Long id) {
        return null;
    }

    @Override
    public CompanyExposeDTO create(CompanySeedDTO companySeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
