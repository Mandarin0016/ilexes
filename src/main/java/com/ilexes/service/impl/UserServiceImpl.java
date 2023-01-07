package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.user.UserExposeDTO;
import com.ilexes.model.dto.seed.user.UserSeedDTO;
import com.ilexes.model.entity.User;
import com.ilexes.repository.UserRepository;
import com.ilexes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Collection<UserExposeDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserExposeDTO.class)).collect(Collectors.toList());
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

    @Override
    public void verify(String email, String code) {

    }
}
