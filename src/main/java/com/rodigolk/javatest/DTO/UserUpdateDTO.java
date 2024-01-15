package com.rodigolk.javatest.DTO;

import com.rodigolk.javatest.entity.Profile;

public class UserUpdateDTO {
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

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public UserUpdateDTO(){}


    public UserUpdateDTO(int id, String name, Profile profile, String email, String password){
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserUpdateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
