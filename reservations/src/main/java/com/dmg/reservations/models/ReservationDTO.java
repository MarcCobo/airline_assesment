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

    public ReservationDTO(Reservation reservation){
        this.id = reservation.getId();
        this.flightId = reservation.getFlightId();
        this.name = reservation.getName();
        this.surname = reservation.getSurname();
        this.nationality = reservation.getNationality();
        this.dni = reservation.getDni();
        this.age = reservation.getAge();
        this.bags = reservation.isBags();
    }
}
