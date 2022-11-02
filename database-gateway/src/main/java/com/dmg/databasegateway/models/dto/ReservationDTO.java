package com.dmg.databasegateway.models.dto;

import com.dmg.databasegateway.models.Reservation;

public class ReservationDTO {
    private long id;
    private long flightId;
    private String name;
    private String surname;
    private String nationality;
    private String dni;
    private long age;
    private boolean bags;

    public ReservationDTO(){

    }

    public ReservationDTO(Reservation reservation){
        this.id = reservation.getId();
        this.flightId = reservation.getFlightId().getId();
        this.name = reservation.getName();
        this.surname = reservation.getSurname();
        this.nationality = reservation.getNationality();
        this.dni = reservation.getDni();
        this.age = reservation.getAge();
        this.bags = reservation.isBags();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setBags(boolean bags) {
        this.bags = bags;
    }

    public long getId() {
        return id;
    }

    public long getFlightId() {
        return flightId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDni() {
        return dni;
    }

    public long getAge() {
        return age;
    }

    public boolean isBags() {
        return bags;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
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
