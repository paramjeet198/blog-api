package com.techbull.blogapi.controllers;

import com.techbull.blogapi.payloads.ApiResponse;
import com.techbull.blogapi.payloads.UserDto;
import com.techbull.blogapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") long id) {
        UserDto updatedUser = userService.updateUser(userDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable("userId") long id) {
        return new ResponseEntity<>(userService.getUerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


}
