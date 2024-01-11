package com.rodigolk.javatest.UserController;
import com.rodigolk.javatest.DTO.UserDTO;
import com.rodigolk.javatest.DTO.UserSaveDTO;
import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600)
@RequestMapping("api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public UserDTO getUser(@PathVariable(value = "id") int id){
        UserDTO user = userService.getUser(id);
        return user;
    }

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

    @GetMapping(path = "/findAllUserByName", params = { "name", "page", "size" })
    public List<UserDTO> findAllUserByName(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size)
    {
       List<UserDTO> allUserByName = userService.findAllUserByName(name, page, size);
       return allUserByName;
    }

    @GetMapping(path = "/findAllUserByEmail", params = { "email", "page", "size" })
    public List<UserDTO> findAllUserByEmail(@RequestParam("email") String email, @RequestParam("page") int page, @RequestParam("size") int size)
    {
       List<UserDTO> allUserByEmail = userService.findAllUserByEmail(email, page, size);
       return allUserByEmail;
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
