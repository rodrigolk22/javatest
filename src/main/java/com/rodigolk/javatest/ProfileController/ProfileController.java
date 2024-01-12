package com.rodigolk.javatest.ProfileController;
import com.rodigolk.javatest.entity.Profile;
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
    public  Profile getProfile(@PathVariable(value = "id") int id){
        Profile profile = profileService.getProfile(id);
        return profile;
    }

    @PostMapping(path = "/save")
    public String saveProfile(@RequestBody ProfileSaveDTO profileSaveDTO)
    {
        profileService.addProfile(profileSaveDTO);
        return "{\"message\": \"Saved\"}";
    }

    @GetMapping(path = "/getAllProfile")
    public List<Profile> getAllProfile()
    {
       List<Profile> allProfiles = profileService.getAllProfile();
       return allProfiles;
    }

    @PutMapping(path = "/update")
    public String updateProfile(@RequestBody ProfileUpdateDTO profileUpdateDTO)
    {
        profileService.updateProfile(profileUpdateDTO);
        return "{\"message\": \"Updated\"}";
    }

    @DeleteMapping(path = "/deleteProfile/{id}")
    public String deleteProfile(@PathVariable(value = "id") int id)
    {
        profileService.deleteProfile(id);
        return "deleted";
    }
}
