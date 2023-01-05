package com.ilexes.service;

import com.ilexes.model.dto.expose.knowledgeBase.KnowledgeBaseExposeDTO;
import com.ilexes.model.dto.seed.knowledgeBase.KnowledgeBaseSeedDTO;
import com.ilexes.model.entity.Application;

import java.util.Collection;

public interface KnowledgeBaseService {

    Collection<KnowledgeBaseExposeDTO> findAll();
    KnowledgeBaseExposeDTO findById(Long id);
    Collection<KnowledgeBaseExposeDTO> findByApplication(Application application);
    KnowledgeBaseExposeDTO create(KnowledgeBaseSeedDTO knowledgeBaseSeedDTO);
    KnowledgeBaseExposeDTO update(KnowledgeBaseSeedDTO knowledgeBaseSeedDTO);
    void deleteById(Long id);


}
