package com.rodigolk.javatest.DTO;

import com.rodigolk.javatest.entity.Profile;

public class UserDTO {
    
    private int id;
    private String name;
    private Profile profile;
    private String email;
    private String password;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile existingProfile) {
        this.profile = existingProfile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserDTO(int id, String name, Profile profile, String email, String password){
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String name, Profile profile, String email, String password){
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }

}
