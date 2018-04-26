package com.project.homefinder.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 3, max = 15)
    private String phone;

    @NotNull
    @Size(min = 3, max = 40)
    private String occupation;

    @NotNull
    @Size(min = 3, max = 15)
    private String monthlyIncome;

    @NotNull
    @Size(min = 3, max = 15)
    private String creditScore;

    @NotNull
    @Size(min = 3, max = 15)
    private String amenities;

    @ManyToMany
    private List<Property> properties;



    public Location(String name, String phone, String occupation, String monthlyIncome, String creditScore, String amenities) {
        this.name = name;
        this.phone = phone;
        this.occupation = occupation;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
        this.amenities = amenities;

    }


    public Location() {
    }


    public void addItem(Property item) {
        properties.add(item);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public List<Property> getProperties() {
        return properties;
    }
}