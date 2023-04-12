package com.techbull.blogapi.services;

import com.techbull.blogapi.payloads.UserDto;

import java.util.List;

public interface UserService {

    /*  it's a better practice to use DTOs (Data Transfer Objects) instead of entities to transfer data between layers of your application
    * Reason:
    * 1. Tight coupling
    * 2. Security
    * 3. Domain logic
    * 4. Performance
    *  DTOs decouple our application's layers, improve security, and improve performance.
    * */

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user,Long id);

    UserDto getUerById(Long id);

    List<UserDto> getAllUsers();

    void deleteUser(Long id);

}
