package com.dmg.reservations;

import com.dmg.reservations.models.ReservationDTO;
import com.dmg.reservations.services.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class ReservationsApplicationTests {

	@Autowired
	private ReservationService service;

	@Test
	public void MakeReservation_CorrectData_DoesNotThrow() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena",
				"Spanish", "12345678A", 23, false);
		String response = service.makeReservation(rev);
		Assertions.assertDoesNotThrow(() -> service.makeReservation(rev));
	}

	@Test
	public void MakeReservation_NegativeFlightId_ReturnEmpty() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, -1L, "David", "Erena",
				"Spanish", "12345678A", 23, false);
		String response = service.makeReservation(rev);
		Assertions.assertTrue(response.isEmpty());
	}

	@Test
	public void MakeReservation_NameEmpty_ReturnEmpty() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, 1L, "", "Erena",
				"Spanish", "12345678A", 23, false);
		String response = service.makeReservation(rev);
		Assertions.assertTrue(response.isEmpty());
	}

	@Test
	public void MakeReservation_SurnameEmpty_ReturnEmpty() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, 1L, "David", "",
				"Spanish", "12345678A", 23, false);
		String response = service.makeReservation(rev);
		Assertions.assertTrue(response.isEmpty());
	}

	@Test
	public void MakeReservation_NationalityEmpty_ReturnEmpty() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena",
				"", "12345678A", 23, false);
		String response = service.makeReservation(rev);
		Assertions.assertTrue(response.isEmpty());
	}

	@Test
	public void MakeReservation_DniEmpty_ReturnEmpty() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena",
				"Spanish", "", 23, false);
		String response = service.makeReservation(rev);
		Assertions.assertTrue(response.isEmpty());
	}

	@Test
	public void MakeReservation_NegativeAge_ReturnEmpty() throws IOException {
		ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena",
				"Spanish", "", -23, false);
		String response = service.makeReservation(rev);
		Assertions.assertTrue(response.isEmpty());
	}
}
