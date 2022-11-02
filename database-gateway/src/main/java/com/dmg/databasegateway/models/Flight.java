package com.dmg.databasegateway.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;
    @Column
    private String airline;
    @Column
    private String flight_num;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "origin")
    private Place origin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination")
    private Place destination;
    @Column
    private LocalDate date;
    @Column
    private double price;
    @Column
    private long layover;
    @Column
    private String layover_text;
    @Column
    private boolean luggage;
    @Column
    private double transit_time;
    @OneToMany(mappedBy = "flightId")
    @JsonIgnore
    private List<Reservation> reservations;

    public Flight(String airline, String flight_num, Place origin, Place destination, LocalDate date, double price, long layover, String layover_text, boolean luggage, double transit_time) {
        this.airline = airline;
        this.flight_num = flight_num;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.layover = layover;
        this.layover_text = layover_text;
        this.luggage = luggage;
        this.transit_time = transit_time;
    }

    public Flight(long id, String airline, String flight_num, Place origin, Place destination, LocalDate date, double price, long layover, String layover_text, boolean luggage, double transit_time) {
        this.id = id;
        this.airline = airline;
        this.flight_num = flight_num;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.layover = layover;
        this.layover_text = layover_text;
        this.luggage = luggage;
        this.transit_time = transit_time;
    }

    public Flight() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(String flight_num) {
        this.flight_num = flight_num;
    }

    public Place getOrigin() {
        return origin;
    }

    public void setOrigin(Place origin) {
        this.origin = origin;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getLayover() {
        return layover;
    }

    public void setLayover(long layover) {
        this.layover = layover;
    }

    public String getLayover_text() {
        return layover_text;
    }

    public void setLayover_text(String layover_text) {
        this.layover_text = layover_text;
    }

    public boolean isLuggage() {
        return luggage;
    }

    public void setLuggage(boolean luggage) {
        this.luggage = luggage;
    }

    public double getTransit_time() {
        return transit_time;
    }

    public void setTransit_time(double transit_time) {
        this.transit_time = transit_time;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airline='" + airline + '\'' +
                ", flight_num='" + flight_num + '\'' +
                ", origin=" + origin +
                ", destination=" + destination +
                ", date=" + date +
                ", price=" + price +
                ", layover=" + layover +
                ", layover_text='" + layover_text + '\'' +
                ", luggage=" + luggage +
                ", transit_time=" + transit_time +
                ", reservations=" + reservations +
                '}';
    }
}
