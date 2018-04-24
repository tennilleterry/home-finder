package com.project.homefinder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    /*@NotNull
    @Size(min = 3, message = "Enter valid address.")
    private String address;

    @NotNull
    @Size(min = 3, message = "Enter valid city.")
    private String city;

    @NotNull
    @Size(min = 3, message = "Enter valid state.")
    private String state;

    @NotNull
    @Size(min = 3, message = "Enter valid zip.")
    private String zip;*/

    @NotNull
    @Size(min = 6, message = "Please enter a valid email.")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;



    @OneToMany
    @JoinColumn(name = "user_id")
     private List<Property> properties = new ArrayList<>();



    //@ManyToMany(mappedBy="users")
    //private List<Availability> availabilities;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    /*public User(String address, String city, String state, String zip){
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }*/

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Property> getProperties() { return properties; }
}