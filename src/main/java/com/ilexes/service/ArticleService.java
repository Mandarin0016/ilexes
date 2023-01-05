package com.ilexes.service;

import com.ilexes.model.dto.expose.article.ArticleExposeDTO;
import com.ilexes.model.dto.seed.article.ArticleSeedDTO;

import java.util.Collection;

public interface ArticleService {
    Collection<ArticleExposeDTO> findAll();
    ArticleExposeDTO findById(Long id);
    ArticleExposeDTO findByTitle(String title);
    ArticleExposeDTO update(ArticleSeedDTO articleSeedDTO);
    ArticleExposeDTO create(ArticleSeedDTO articleSeedDTO);
    void deleteById(Long id);

}
