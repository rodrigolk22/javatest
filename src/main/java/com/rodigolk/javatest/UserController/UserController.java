package com.rodigolk.javatest.UserController;
import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.entity.Profile;
import com.rodigolk.javatest.entity.User;
import com.rodigolk.javatest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.rodigolk.javatest.service.ProfileService;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600)
@RequestMapping("api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable(value = "id") int id){
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody User userSaveDTO)
    {
        // Verifique se o perfil já existe pelo nome
        Profile existingProfile = profileService.getProfileByName(userSaveDTO.getProfileName());

        UserDTO newUser = new UserDTO();
        newUser.setName(userSaveDTO.getName());
        newUser.setEmail(userSaveDTO.getEmail());
        newUser.setPassword(userSaveDTO.getPassword());
        newUser.setProfile(existingProfile);

        userService.addUser(userSaveDTO);
        return "{\"message\": \"Saved\"}";
    }

    @GetMapping(path = "/getAllUser")
    public List<User> getAllUser()
    {
       List<User> allUser = userService.getAllUser();
       return allUser;
    }

    @GetMapping(path = "/getUserList")
    public Page<User> getUserList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getUserList(page, size);
    }

    @GetMapping("/getUserByName")
    public Page<User> getUserByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getUserByName(name, page, size);
    }

    @GetMapping("/getUserByEmail")
    public Page<User> getUserByEmail(
            @RequestParam String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getUserByEmail(email, page, size);
    }

    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO)
    {
        String id = userService.updateUser(userUpdateDTO);
        return id;
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id)
    {
        userService.deleteUser(id);
        return "deleted";
    }

}
