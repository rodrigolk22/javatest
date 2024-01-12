package com.rodigolk.javatest.service;

import com.rodigolk.javatest.UserRepo.UserRepo;
import com.rodigolk.javatest.UserRepo.UserRepoPagination;
import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserSaveDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.entity.Profile;
import com.rodigolk.javatest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService{
    @Autowired
    private UserRepo userRepo;

    public User getUser(int id){
        if (userRepo.existsById(id)) {
            User user = userRepo.getReferenceById(id);
            Profile profile = new Profile(user.getProfile().getId(), user.getProfile().getName());
            User userDTO = new User(
                   user.getId(),
                   user.getName(),
                   profile,
                   user.getEmail(),
                   user.getPassword()
           );
           return userDTO;
        }
        System.out.println("User id not found");
        return null;
    }
 
    @Override
    public String addUser(User userSaveDTO)
    {
        Profile profile = new Profile(userSaveDTO.getProfile().getId(), userSaveDTO.getProfile().getName());
        UserDTO userDTO = new UserDTO(
                0, userSaveDTO.getName(),
                profile,
                userSaveDTO.getEmail(),
                userSaveDTO.getPassword()
        );
        userRepo.save(userSaveDTO);
        return userDTO.getName();
    }
 
    @Override
    public List<User> getAllUser() {
       List<User> getusers = userRepo.findAll();
       List<User> userDTOList = new ArrayList<>();
       for(User a:getusers)
       {
            User userDTO = new User(
                   a.getId(),
                   a.getName(),
                   a.getProfile(),
                   a.getEmail(),
                   a.getPassword()
           );
           userDTOList.add(userDTO);
       }
 
       return  userDTOList;
    }

    @Override
    public Page<User> getUserList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<User> getUserByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findUserByName(name, pageable);
    }

    @Override
    public Page<User> getUserByEmail(String email, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findUserByEmail(email, pageable);
    }
 
    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO)
    {
        if (userRepo.existsById(userUpdateDTO.getId())) {
            User user = userRepo.getReferenceById(userUpdateDTO.getId());
 
            user.setName(userUpdateDTO.getName());
            user.setProfile(userUpdateDTO.getProfile());
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
