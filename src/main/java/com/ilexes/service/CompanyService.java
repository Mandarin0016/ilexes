package com.ilexes.service;

import com.ilexes.model.dto.expose.company.CompanyExposeDTO;
import com.ilexes.model.dto.seed.company.CompanySeedDTO;
import com.ilexes.model.enums.CompanyType;

import java.util.Collection;

public interface CompanyService {

    Collection<CompanyExposeDTO> findAll();
    CompanyExposeDTO findById(Long id);
    Collection<CompanyExposeDTO> findAllByType(CompanyType companyType);
    CompanyExposeDTO update(CompanySeedDTO companySeedDTO, Long id);
    CompanyExposeDTO create(CompanySeedDTO companySeedDTO);
    void deleteById(Long id);
}
