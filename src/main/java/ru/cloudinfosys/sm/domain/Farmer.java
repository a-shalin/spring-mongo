package ru.cloudinfosys.sm.domain;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.geo.GeoJson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.Arrays;

@Entity
public class Farmer {
    @Id
    private String id;

    @TextIndexed
    private String firstName;
    @TextIndexed
    private String lastName;

    private GeoJsonPoint location = new GeoJsonPoint(0, 0);

    public Farmer() {
    };

    public Farmer (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location=" + location +
                '}';
    }
}
