package com.dmg.databasegateway.models;

import jakarta.persistence.*;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flightId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String nationality;
    @Column
    private String dni;
    @Column
    private long age;
    @Column
    private boolean bags;

    public Reservation(long id, Flight flightId, String name, String surname, String nationality, String dni, long age, boolean bags) {
        this.id = id;
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.dni = dni;
        this.age = age;
        this.bags = bags;
    }

    public Reservation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public boolean isBags() {
        return bags;
    }

    public void setBags(boolean bags) {
        this.bags = bags;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", bags=" + bags +
                '}';
    }
}
