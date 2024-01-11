package com.rodigolk.javatest.service;

import com.rodigolk.javatest.ProfileRepo.ProfileRepo;
import com.rodigolk.javatest.DTO.ProfileDTO;
import com.rodigolk.javatest.DTO.ProfileSaveDTO;
import com.rodigolk.javatest.DTO.ProfileUpdateDTO;
import com.rodigolk.javatest.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceIMPL implements ProfileService{
    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public ProfileDTO getProfile(int id){
        if (profileRepo.existsById(id)) {
            Profile profile = profileRepo.getById(id);
            ProfileDTO profileDTO = new ProfileDTO(
                   profile.getId(),
                   profile.getName()
           );
           return profileDTO;
        }
        System.out.println("Profile id not found");
        return null;
    }
 
    @Override
    public String addProfile(ProfileSaveDTO profileSaveDTO)
    {
        Profile profile = new Profile(
                profileSaveDTO.getName()
        );
        profileRepo.save(profile);
        return profile.getName();
    }
 
    @Override
    public List<ProfileDTO> getAllProfile() {
       List<Profile> getprofiles = profileRepo.findAll();
       List<ProfileDTO> profileDTOList = new ArrayList<>();
       for(Profile a:getprofiles)
       {
            ProfileDTO profileDTO = new ProfileDTO(
 
                   a.getId(),
                   a.getName()
           );
           profileDTOList.add(profileDTO);
       }
 
       return  profileDTOList;
    }
 
    @Override
    public String updateProfile(ProfileUpdateDTO profileUpdateDTO)
    {
        if (profileRepo.existsById(profileUpdateDTO.getId())) {
            Profile profile = profileRepo.getById(profileUpdateDTO.getId());
 
            profile.setName(profileUpdateDTO.getName());
            profileRepo.save(profile);
        }
            else
            {
                System.out.println("Profile ID do not Exist");
            }
 
                return null;
        }
 
    @Override
    public boolean deleteProfile(int id) {
 
        if(profileRepo.existsById(id))
        {
            profileRepo.deleteById(id);
        }
        else
        {
            System.out.println("Profile id not found");
        }
 
        return true;
    }
}
