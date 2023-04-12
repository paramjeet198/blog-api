package com.techbull.blogapi.services.impl;

import com.techbull.blogapi.entities.User;
import com.techbull.blogapi.exceptions.ResourceNotFoundException;
import com.techbull.blogapi.payloads.UserDto;
import com.techbull.blogapi.repositories.UserRepo;
import com.techbull.blogapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo; //class implementation is given at runtime.
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

//        System.out.println(userRepo.getClass());
//        System.out.println(userRepo.getClass().getName());

        User user = this.dtoToUser(userDto);
        User savedUser = userRepo.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {

        User existingUser = userRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));

        User user = modelMapper.map(userDto, User.class);
        User updatedUser = userRepo.save(user);

        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUerById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id ", id));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(this.userToDto(user));
        }
        return userDtos;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id ", id));
        userRepo.delete(user);
    }


    public User dtoToUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        System.out.println("user:" + user);
        return user;

//        return User.builder()
//                .id(userDto.getId())
//                .email(userDto.getEmail())
//                .name(userDto.getName())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .build();

    }

    public UserDto userToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        System.out.println("userDto: " + userDto);
        return userDto;
//        return UserDto.builder()
//                .id(user.getId())
//                .email(user.getEmail())
//                .name(user.getName())
//                .password(user.getPassword())
//                .about(user.getAbout())
//                .build();

    }

}
