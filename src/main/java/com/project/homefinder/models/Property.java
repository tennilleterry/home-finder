package com.project.homefinder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 60)
    private String name;

    @NotNull
    @Size(min = 1, message = "Address must not be empty")
    private String address;


    @NotNull
    @Size(min = 1, message = "Description must not be empty")
    private String description;



    //fix change to one-to-one. There is one user for a property listing.

    @ManyToOne
     private User user;


    @ManyToOne
    private Status status;


    @ManyToMany(mappedBy="properties")
    private List<Location> locations;




    public Property(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public Property() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public List<Location> getLocations() { return locations; }




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}

