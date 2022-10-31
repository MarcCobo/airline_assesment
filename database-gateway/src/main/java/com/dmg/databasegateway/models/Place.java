package com.dmg.databasegateway.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "origin")
    @JsonIgnore
    private List<Flight> originFlights;
    @OneToMany(mappedBy = "destination")
    @JsonIgnore
    private List<Flight> destinationFlights;

    public Place(String name) {
        this.name = name;
    }

    public Place(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Place() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
