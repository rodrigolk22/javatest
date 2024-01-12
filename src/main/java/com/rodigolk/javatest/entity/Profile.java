package com.rodigolk.javatest.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name = "id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 50)
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

    public Profile(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Profile(String name){
        this.name = name;
    }

    public Profile(){}

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + 
                '}';
    }
}
