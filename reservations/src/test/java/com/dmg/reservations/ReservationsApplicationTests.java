package com.dmg.reservations;

import com.dmg.reservations.models.Reservation;
import com.dmg.reservations.services.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ReservationsApplicationTests {

	@Autowired
	private ReservationService service;

	@Test
	public void MakeReservation_WhenCalled_ReturnReservation(){
		Reservation rev = new Reservation(1, 120, "David", "Erena",
				"Spanish", "12345678A", 23, false);
		Reservation result = service.save(rev);
		Assertions.assertNotNull(result);
	}

	@Test
	public void FindReservationById_IdExists_ReturnReservation(){
		Reservation result = service.findById(1);
		Assertions.assertNotNull(result);
	}

	@Test
	public void FindReservationById_IdNotFound_ThrowsException(){
		Reservation result = service.findById(-1);
		Assertions.assertNull(result);
	}

	@Test
	public void FindReservationByDate_WhenCalled_ReturnList(){
		List<Reservation> result = service.findByDate(LocalDate.now());
		Assertions.assertNotNull(result);
	}

}
