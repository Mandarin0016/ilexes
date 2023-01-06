package com.ilexes.web;


import com.ilexes.model.dto.expose.user.UserExposeDTO;
import com.ilexes.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Collection<UserExposeDTO> findAll() {
        return userService.findAll();
    }
}
