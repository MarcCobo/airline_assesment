package com.dmg.reservations;

import com.dmg.reservations.models.Reservation;
import com.dmg.reservations.services.ReservationService;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;


@SpringBootTest
class ReservationsApplicationTests {

	@Autowired
	private ReservationService service;

	@Test
	public void MakeReservation_WhenCalled_ReturnReservation(){
		Reservation rev = new Reservation(1, 1, "David", "Erena",
				"Spanish", "12345678A", 23, false);
		Response response = service.makeReservation(rev);
		Assertions.assertEquals(response.statusCode(), 201);

//		int result = service.makeReservation(rev);
//		Assertions.assertEquals(201, result);
	}
}
