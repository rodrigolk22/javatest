package com.rodigolk.javatest.ProfileController;
import com.rodigolk.javatest.DTO.ProfileDTO;
import com.rodigolk.javatest.DTO.ProfileSaveDTO;
import com.rodigolk.javatest.DTO.ProfileUpdateDTO;
import com.rodigolk.javatest.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600)
@RequestMapping("api/v1/profile")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "/{id}")
    public ProfileDTO getProfile(@PathVariable(value = "id") int id){
        ProfileDTO profile = profileService.getProfile(id);
        return profile;
    }

    @PostMapping(path = "/save")
    public String saveProfile(@RequestBody ProfileSaveDTO profileSaveDTO)
    {
        String id = profileService.addProfile(profileSaveDTO);
        return id;
    }

    @GetMapping(path = "/getAllProfile")
    public List<ProfileDTO> getAllProfile()
    {
       List<ProfileDTO> allProfiles = profileService.getAllProfile();
       return allProfiles;
    }

    @PutMapping(path = "/update")
    public String updateProfile(@RequestBody ProfileUpdateDTO profileUpdateDTO)
    {
        String id = profileService.updateProfile(profileUpdateDTO);
        return id;
    }

    @DeleteMapping(path = "/deleteProfile/{id}")
    public String deleteProfile(@PathVariable(value = "id") int id)
    {
        profileService.deleteProfile(id);
        return "deleted";
    }
}
