package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.survey.SurveyExposeDTO;
import com.ilexes.model.dto.seed.survey.SurveySeedDTO;
import com.ilexes.model.enums.SatisfactionLevel;
import com.ilexes.service.SurveyService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Override
    public Collection<SurveyExposeDTO> findAll() {
        return null;
    }

    @Override
    public SurveyExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public Collection<SurveyExposeDTO> findAllBySatisfactionLevel(SatisfactionLevel satisfactionLevel) {
        return null;
    }

    @Override
    public SurveyExposeDTO update(SurveySeedDTO surveySeedDTO, Long id) {
        return null;
    }

    @Override
    public SurveyExposeDTO create(SurveySeedDTO surveySeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
