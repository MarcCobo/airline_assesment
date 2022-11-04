package com.dmg.databasegateway.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table
public class Analytics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @ColumnDefault("0")
    private int checkedFlights;
    @Column
    @ColumnDefault("0")
    private int bookedFlights;

    public Analytics() {
    }

    public Analytics(long id, Place place, int checkedFlights, int bookedFlights) {
        this.id = id;
        this.checkedFlights = checkedFlights;
        this.bookedFlights = bookedFlights;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCheckedFlights() {
        return checkedFlights;
    }

    public void setCheckedFlights(int checkedFlights) {
        this.checkedFlights = checkedFlights;
    }

    public int getBookedFlights() {
        return bookedFlights;
    }

    public void setBookedFlights(int bookedFlights) {
        this.bookedFlights = bookedFlights;
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "id=" + id +
//                ", place=" + place +
                ", checkedFlights=" + checkedFlights +
                ", bookedFlights=" + bookedFlights +
                '}';
    }
}
