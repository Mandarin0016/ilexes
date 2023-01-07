package com.ilexes.web;


import com.ilexes.model.dto.expose.user.UserExposeDTO;
import com.ilexes.model.dto.seed.user.UserSeedDTO;
import com.ilexes.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

import static com.ilexes.util.ErrorHandlingUtil.handleValidationErrors;

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

//    @PostMapping()
//    public ResponseEntity<UserExposeDTO> create(@Valid @RequestBody UserSeedDTO userSeedDTO, Errors errors) {
//        handleValidationErrors(errors);
//        UserExposeDTO createdUser = userService.create(userSeedDTO);
//        return ResponseEntity
//                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}")
//                        .buildAndExpand(createdUser.getId()).toUri())
//                .body(createdUser);
//    }
}
