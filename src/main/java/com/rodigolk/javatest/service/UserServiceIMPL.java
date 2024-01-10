package com.rodigolk.javatest.service;

import com.rodigolk.javatest.UserRepo.UserRepo;
import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserSaveDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService{
    @Autowired
    private UserRepo userRepo;
 
    @Override
    public String addUser(UserSaveDTO userSaveDTO)
    {
        User user = new User(
                userSaveDTO.getName(),
                userSaveDTO.getProfile_id(),
                userSaveDTO.getEmail(),
                userSaveDTO.getPassword()
        );
        userRepo.save(user);
        return user.getName();
    }
 
    @Override
    public List<UserDTO> getAllUser() {
       List<User> getusers = userRepo.findAll();
       List<UserDTO> userDTOList = new ArrayList<>();
       for(User a:getusers)
       {
            UserDTO userDTO = new UserDTO(
 
                   a.getId(),
                   a.getName(),
                   a.getProfile_id(),
                   a.getEmail(),
                   a.getPassword()
           );
           userDTOList.add(userDTO);
       }
 
       return  userDTOList;
    }
 
    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO)
    {
        if (userRepo.existsById(userUpdateDTO.getId())) {
            User user = userRepo.getById(userUpdateDTO.getId());
 
            user.setName(userUpdateDTO.getName());
            user.setProfile_id(userUpdateDTO.getProfile_id());
            user.setEmail(userUpdateDTO.getEmail());
            user.setPassword(userUpdateDTO.getPassword());
            userRepo.save(user);
        }
            else
            {
                System.out.println("User ID do not Exist");
            }
 
                return null;
        }
 
    @Override
    public boolean deleteUser(int id) {
 
        if(userRepo.existsById(id))
        {
            userRepo.deleteById(id);
        }
        else
        {
            System.out.println("User id not found");
        }
 
        return true;
    }
}
