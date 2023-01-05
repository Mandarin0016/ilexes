package com.ilexes.service;

import com.ilexes.model.dto.expose.file.FileExposeDTO;
import com.ilexes.model.dto.seed.file.FileSeedDTO;

import java.util.Collection;

public interface FileService {
    Collection<FileExposeDTO> findAll();
    FileExposeDTO findById(Long id);
    //тук му давам да върне колекция, защото имената на файловете не са уникални
    Collection<FileExposeDTO> findByName(String fileName);
    //тук отново връщам колекция, защото Url-a не е уникален в ентитито. а може би трябва?
    Collection<FileExposeDTO> findByUrl(String fileUrl);
    FileExposeDTO create(FileSeedDTO fileSeedDTO);
    FileExposeDTO update(FileSeedDTO fileSeedDTO);
    void deleteById(Long id);

}
