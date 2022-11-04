package com.dmg.reservations;

import com.dmg.reservations.models.ReservationDTO;
import com.dmg.reservations.services.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;


@SpringBootTest
class ReservationsApplicationTests {

    @Autowired
    private ReservationService service;

    @Test
    public void MakeReservation_CorrectData_ReturnCreatedCode() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "ErenJeager@solera.com",
                "Spanish", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void MakeReservation_NegativeFlightId_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, -1L, "David", "Erena", "ErenJeager@solera.com",
                "Spanish", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_NameEmpty_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "", "Erena", "ErenJeager@solera.com",
                "Spanish", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_SurnameEmpty_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "", "ErenJeager@solera.com",
                "Spanish", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_NationalityEmpty_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "ErenJeager@solera.com",
                "", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_DniEmpty_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "ErenJeager@solera.com",
                "Spanish", "", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_DniLessThanEightCharacters_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "ErenJeager@solera.com",
                "Spanish", "123456A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_DniIncorrectFormat_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "ErenJeager@solera.com",
                "Spanish", "1a345678", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_NegativeAge_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "ErenJeager@solera.com",
                "Spanish", "12345678A", -23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_EmptyEmail_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "",
                "Spanish", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void MakeReservation_IncorrectEmailFormat_ReturnBadRequest() throws IOException {
        ReservationDTO rev = new ReservationDTO(1, 1L, "David", "Erena", "asasdsadasd.12",
                "Spanish", "12345678A", 23, false, 1, 0.0);
        ResponseEntity<ReservationDTO> response = service.makeReservation(rev);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void getVariablePrice_WhenCalled_ReturnAccordingPrice() {
        int[] ages = new int[3];
        ages[0] = 1;
        ages[1] = 5;
        ages[2] = 18;
        double result = service.getVariablePrice(ages, true, 200);
		Assertions.assertEquals(720, result);
    }
}
