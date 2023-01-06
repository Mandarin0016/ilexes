package com.ilexes.service;

import com.ilexes.model.dto.expose.survey.SurveyExposeDTO;
import com.ilexes.model.dto.seed.survey.SurveySeedDTO;
import com.ilexes.model.enums.SatisfactionLevel;

import java.util.Collection;

public interface SurveyService {

    Collection<SurveyExposeDTO> findAll();
    SurveyExposeDTO findById(Long id);

    Collection<SurveyExposeDTO> findAllBySatisfactionLevel(SatisfactionLevel satisfactionLevel);

    SurveyExposeDTO update(SurveySeedDTO surveySeedDTO, Long id);

    SurveyExposeDTO create(SurveySeedDTO surveySeedDTO);

    void deleteById(Long id);
}
