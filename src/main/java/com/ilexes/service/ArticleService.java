package com.ilexes.service;

import com.ilexes.model.dto.expose.article.ArticleExposeDTO;
import com.ilexes.model.dto.seed.article.ArticleSeedDTO;

import java.util.Collection;

public interface ArticleService {
    Collection<ArticleExposeDTO> findAll();
    ArticleExposeDTO findById(Long id);
    ArticleExposeDTO update(ArticleSeedDTO articleSeedDTO, Long id);
    ArticleExposeDTO create(ArticleSeedDTO articleSeedDTO);
    void deleteById(Long id);

}
