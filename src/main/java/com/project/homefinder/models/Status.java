package com.project.homefinder.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Status {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    public Status(){ }

    public Status(String name) { this.name = name; }

    @OneToMany
    @JoinColumn(name = "status_id")
    private List<Property> properties = new ArrayList<>();



    public int getId() { return id; }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Property> getProperties() { return properties; }


}
