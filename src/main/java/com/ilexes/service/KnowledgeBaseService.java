package com.ilexes.service;

import com.ilexes.model.dto.expose.knowledgeBase.KnowledgeBaseExposeDTO;
import com.ilexes.model.dto.seed.knowledgeBase.KnowledgeBaseSeedDTO;
import com.ilexes.model.entity.Application;

import java.util.Collection;

public interface KnowledgeBaseService {

    Collection<KnowledgeBaseExposeDTO> findAll();
    KnowledgeBaseExposeDTO findById(Long id);
    KnowledgeBaseExposeDTO create(KnowledgeBaseSeedDTO knowledgeBaseSeedDTO);
    KnowledgeBaseExposeDTO update(KnowledgeBaseSeedDTO knowledgeBaseSeedDTO, Long id);
    void deleteById(Long id);


}
