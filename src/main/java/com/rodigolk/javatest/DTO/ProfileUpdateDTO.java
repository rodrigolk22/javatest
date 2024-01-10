package com.rodigolk.javatest.DTO;

public class ProfileUpdateDTO {
    private int id;
    private String name;


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

    public ProfileUpdateDTO(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProfileUpdateDTO{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
