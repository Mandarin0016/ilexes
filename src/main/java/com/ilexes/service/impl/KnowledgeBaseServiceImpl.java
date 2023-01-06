package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.knowledgeBase.KnowledgeBaseExposeDTO;
import com.ilexes.model.dto.seed.knowledgeBase.KnowledgeBaseSeedDTO;
import com.ilexes.model.entity.Application;
import com.ilexes.service.KnowledgeBaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {
    @Override
    public Collection<KnowledgeBaseExposeDTO> findAll() {
        return null;
    }

    @Override
    public KnowledgeBaseExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public KnowledgeBaseExposeDTO create(KnowledgeBaseSeedDTO knowledgeBaseSeedDTO) {
        return null;
    }

    @Override
    public KnowledgeBaseExposeDTO update(KnowledgeBaseSeedDTO knowledgeBaseSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
