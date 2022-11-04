package com.dmg.databasegateway.models;

import com.dmg.databasegateway.models.dto.ReservationDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String email;
    @Column
    private String nationality;
    @Column
    private String dni;
    @Column
    private long age;
    @Column
    private boolean bags;
    @Column
    @ColumnDefault("1")
    private int numSeats;
    @Column
    @ColumnDefault("0.0")
    private double price;

    public Reservation(long id, Flight flightId, String name, String surname, String email, String nationality, String dni, long age, boolean bags, int numSeats, double price) {
        this.id = id;
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nationality = nationality;
        this.dni = dni;
        this.age = age;
        this.bags = bags;
        this.numSeats = numSeats;
        this.price = price;
    }

    public Reservation(Flight flightId, String name, String surname, String email, String nationality, String dni, long age, boolean bags, int numSeats, double price) {
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nationality = nationality;
        this.dni = dni;
        this.age = age;
        this.bags = bags;
        this.numSeats = numSeats;
        this.price = price;
    }

    public Reservation() {

    }

    public Reservation(ReservationDTO dto){
        this.id = dto.getId();
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.email = dto.getEmail();
        this.nationality = dto.getNationality();
        this.dni = dto.getDni();
        this.age = dto.getAge();
        this.bags = dto.isBags();
        this.numSeats = dto.getNumSeats();
        this.price = dto.getPrice();
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

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", bags=" + bags +
                ", numSeats=" + numSeats +
                ", price=" + price +
                '}';
    }
}
