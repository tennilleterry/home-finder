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
    @Size(min = 1, message = "Description must not be empty")
    private String description;



    //private PropertyType type;




    @ManyToOne
    private Status status;


    @ManyToMany(mappedBy="properties")
    private List<Location> locations;



    public Property(String name, String description) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public List<Location> getLocations() { return locations; }


    /*public PropertyType getType() {
        return type;
    }

    public void setPropertyType(PropertyType type) {
        this.type = type;
    }*/

}

