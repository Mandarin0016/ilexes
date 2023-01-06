package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.article.ArticleExposeDTO;
import com.ilexes.model.dto.seed.article.ArticleSeedDTO;
import com.ilexes.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public Collection<ArticleExposeDTO> findAll() {
        return null;
    }

    @Override
    public ArticleExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public ArticleExposeDTO update(ArticleSeedDTO articleSeedDTO, Long id) {
        return null;
    }

    @Override
    public ArticleExposeDTO create(ArticleSeedDTO articleSeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
