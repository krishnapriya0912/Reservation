package walmart.ReservationSystem.service;

import static org.junit.Assert.*;

import org.junit.Test;

import walmart.ReservationSystem.model.Reservation;
import walmart.ReservationSystem.model.SeatHold;
public class SeatingReservationTest {
	
	SeatingReservation reserve = new SeatingReservation();
	SeatHold seatHold = new SeatHold();
	Reservation reservation = new Reservation();
	
	@Test
	public void numSeatsAvailable() {
		int totalSeats = 200;
		 totalSeats -= seatHold.getNumSeatsOnHold() + reservation.getTotalReservedSeats();
		int value = reserve.numSeatsAvailable();
		assertEquals(totalSeats,value);
	}
	
	@Test
	public void reserveSeats() {
		int seatsToReserve = 4;
		String customerEmail = "test@gmail.com";
		assertEquals(customerEmail, reserve.reserveSeats(seatsToReserve, customerEmail));
	}
	
	@Test
	public void findAndHoldSeats() {
		int seatsToReserve = 4;
		String customerEmail = "test@gmail.com";
		assertEquals(customerEmail, reserve.findAndHoldSeats(seatsToReserve, customerEmail).getCustomerEmail());
		assertEquals(seatsToReserve, reserve.findAndHoldSeats(seatsToReserve, customerEmail).getNumberOfSeats());
	}
	
	
	@Test
	public void reserveHoldSeats() {
		int seatsToReserve = 4;
		String customerEmail = "test@gmail.com";
		assertEquals(customerEmail, reserve.reserveHoldSeats(seatsToReserve, customerEmail));
	}
	
}
