package com.rodigolk.javatest.service;

import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserSaveDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(int id);

    String addUser(UserSaveDTO userSaveDTO);
 
    List<UserDTO> getAllUser();

    List<UserDTO> findAllUserByName(String name, int page, int size);

    List<UserDTO> findAllUserByEmail(String email, int page, int size);
 
    String updateUser(UserUpdateDTO userUpdateDTO);
 
    boolean deleteUser(int id);
}
