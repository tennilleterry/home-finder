package com.project.homefinder.models.forms;



import com.project.homefinder.models.Location;
import com.project.homefinder.models.Property;

import javax.validation.constraints.NotNull;

public class AddLocationItemForm {

    @NotNull
    private int id;

    @NotNull
    private int propertyId;

    private Iterable<Property> properties;

    private Location location;

    public AddLocationItemForm() {
    }

    public AddLocationItemForm(Iterable<Property> properties, Location location) {
        this.properties = properties;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Iterable<Property> getProperties() {
        return properties;
    }

    public Location getLocation() {
        return location;
    }

}