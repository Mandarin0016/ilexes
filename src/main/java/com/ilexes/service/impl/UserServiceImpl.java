package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.user.UserExposeDTO;
import com.ilexes.model.dto.seed.user.UserSeedDTO;
import com.ilexes.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Collection<UserExposeDTO> findAll() {
        return null;
    }

    @Override
    public UserExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public UserExposeDTO findByEmail(String email) {
        return null;
    }

    @Override
    public UserExposeDTO create(UserSeedDTO userSeedDTO) {
        return null;
    }

    @Override
    public UserExposeDTO update(UserSeedDTO userSeedDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
