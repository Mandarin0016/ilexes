package com.ilexes.web;


import com.ilexes.model.dto.expose.user.UserExposeDTO;
import com.ilexes.model.dto.seed.user.UserSeedDTO;
import com.ilexes.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

import static com.ilexes.util.ErrorHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Request was successful."),
        @ApiResponse(
                responseCode = "400",
                description = "You made a bad request."),
        @ApiResponse(
                responseCode = "401",
                description = "You did not have valid credentials."),
        @ApiResponse(
                responseCode = "403",
                description = "You do not have permission to execute a request."),
        @ApiResponse(
                responseCode = "500",
                description = "An internal server error occurred.")})

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
