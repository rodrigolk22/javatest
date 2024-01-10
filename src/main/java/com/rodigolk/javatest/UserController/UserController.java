package com.rodigolk.javatest.UserController;
import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserSaveDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO)
    {
        String id = userService.addUser(userSaveDTO);
        return id;
    }

    @GetMapping(path = "/getAllUser")
    public List<UserDTO> getAllUser()
    {
       List<UserDTO> allUser = userService.getAllUser();
       return allUser;
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
        boolean deleteuser = userService.deleteUser(id);
        return "deleted";
    }
}
