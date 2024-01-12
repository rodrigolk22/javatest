package com.rodigolk.javatest.service;

import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.entity.User;

import java.util.List;

import org.springframework.data.domain.Page;

public interface UserService {

    User getUser(int id);

    String addUser(User userSaveDTO);
 
    List<User> getAllUser();

    Page<User>getUserList(int page, int size);

    Page<User> getUserByName(String name, int page, int size);

    Page<User> getUserByEmail(String email, int page, int size);
 
    String updateUser(UserUpdateDTO userUpdateDTO);
 
    boolean deleteUser(int id);
}
