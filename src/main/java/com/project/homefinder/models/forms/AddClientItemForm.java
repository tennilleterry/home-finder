package com.project.homefinder.models.forms;

import com.project.homefinder.models.Client;
import com.project.homefinder.models.Location;
import com.project.homefinder.models.Property;

import javax.validation.constraints.NotNull;

public class AddClientItemForm {

    @NotNull
    private int id;

    @NotNull
    private int propertyId;

    private Iterable<Property> properties;

    private Client client;

    public AddClientItemForm() {
    }

    public AddClientItemForm(Iterable<Property> properties, Client client) {
        this.properties = properties;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

}