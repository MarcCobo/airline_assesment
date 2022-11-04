package com.dmg.reservations.models;

public class ReservationDTO {
    private long id;
    private long flightId;
    private String name;
    private String surname;
    private String nationality;
    private String dni;
    private long age;
    private boolean bags;
    private int numSeats;
    private double price;

    public ReservationDTO(){

    }

    public ReservationDTO(long id, long flightId, String name, String surname, String nationality, String dni, long age, boolean bags, int numSeats, double price) {
        this.id = id;
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.dni = dni;
        this.age = age;
        this.bags = bags;
        this.numSeats = numSeats;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
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
                ", numSeats=" + numSeats +
                ", price=" + price +
                '}';
    }
}
