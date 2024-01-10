package com.rodigolk.javatest.DTO;

public class ProfileSaveDTO {
    
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileSaveDTO(String name){
        this.name = name;
    }

    public ProfileSaveDTO(){}

    @Override
    public String toString() {
        return "ProfileSaveDTO{" +
                "name='" + name +
                '}';
    }
}
