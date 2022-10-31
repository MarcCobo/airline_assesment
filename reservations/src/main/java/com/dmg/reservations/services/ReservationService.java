package com.dmg.reservations.services;

import com.dmg.reservations.models.Reservation;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    public Reservation save(Reservation rev) {
        throw new NotYetImplementedException("Save operation not implemented.");
    }

    public Reservation findById(int id) {
        throw new NotYetImplementedException("FindById operation not implemented.");
    }

    public List<Reservation> findByDate(LocalDate now) {
        throw new NotYetImplementedException("FindByDate operation not implemented.");
    }
}
