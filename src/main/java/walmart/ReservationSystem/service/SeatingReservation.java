package walmart.ReservationSystem.service;


import java.util.HashMap;

import walmart.ReservationSystem.model.Reservation;
import walmart.ReservationSystem.model.SeatHold;
import walmart.ReservationSystem.model.Venue;

public class SeatingReservation implements TicketService {
	
	SeatHold seat = new SeatHold();
	Reservation reservation = new Reservation();
	Venue venue = new Venue();
	int availableSeats = venue.getTotalAvailableSeats();
	
	// Returns the number of available seats 
	public int numSeatsAvailable() {
		if (reservation.getTotalReservedSeats() < 200) {
		availableSeats -= seat.getNumSeatsOnHold() + reservation.getTotalReservedSeats();
		return availableSeats;
		}
		else {
			System.out.println("All the seats are reserved.");
			return 0;
		}
	}

	//returns the email when the requested seats are booked
	public String reserveSeats(int numSeats, String customerEmail) {
			availableSeats -= numSeats;
			reservation.setCustomerEmail(customerEmail);
			reservation.setNumSeats(numSeats);
			System.out.println("Available Seats are:"+ availableSeats);
		return customerEmail;
	}
	
	// Method to release the seat hold by the customer after the reservation is done for the same.
	public void releaseSeatHold(int numSeats, String customerEmail) {
		if(seat.getSeatsHeld().get(customerEmail).equals(numSeats) ) {
			// Removing the held seats from the SealHold list after making a reservation successfully.
			seat.getSeatsHeld().remove(customerEmail);
			System.out.println("Hold is release.");
		}
	}
	
	//Method to reserve the already held seats
	public String reserveHoldSeats(int numSeats, String customerEmail) {
		//Doing this step as there is no DB to retrieve the previously held seats. And to implement reservation for the previous held seats. 
		 findAndHoldSeats(numSeats, customerEmail);
		if (!seat.getSeatsHeld().isEmpty()) {
			if(seat.getSeatsHeld().get(customerEmail).equals(numSeats) ) {
				reserveSeats(numSeats, customerEmail);
				System.out.println("Reservation done Sucessfully.");
				releaseSeatHold(numSeats, customerEmail);
				}
			return customerEmail;
		}
	
			else  {
				System.out.println("No seats were held.");
				return null;
			}
	}

	//Methode to find the available seats and hold
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		if (numSeatsAvailable() > numSeats) {
			HashMap<String, Integer> seatHold = new HashMap<String, Integer>();
			seatHold.put(customerEmail, numSeats);
			seat.setCustomerEmail(customerEmail);
			seat.setNumberOfSeats(numSeats);
			seat.setSeatsHeld(seatHold);
			return seat;
			}
		else
		    return null;
	}
}


