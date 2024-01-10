package com.rodigolk.javatest.service;

import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserSaveDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);
 
    List<UserDTO> getAllUser();
 
    String updateUser(UserUpdateDTO userUpdateDTO);
 
    boolean deleteUser(int id);
}
