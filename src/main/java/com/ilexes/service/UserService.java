package com.ilexes.service;

import com.ilexes.model.dto.expose.user.UserExposeDTO;
import com.ilexes.model.dto.seed.user.UserSeedDTO;

import java.util.Collection;

public interface UserService {
    Collection<UserExposeDTO> findAll();
    UserExposeDTO findById(Long id);
    UserExposeDTO findByEmail(String email);
    UserExposeDTO create(UserSeedDTO userSeedDTO);
    UserExposeDTO update(UserSeedDTO userSeedDTO, Long id);
    void deleteById(Long id);

    void verify(String email, String code);

}
