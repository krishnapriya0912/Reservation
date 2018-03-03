package walmart.ReservationSystem.model;

import java.util.HashMap;

public class SeatHold {

	private int numberOfSeats;
	
	private String customerEmail;
	
	private HashMap<String, Integer> seatsHeld;
	
	// Assuming that 33 seats on hold.
	// If the DB is connected then can get rid off the initialization.
	private int numSeatsOnHold = 33;
	
	

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public HashMap<String, Integer> getSeatsHeld() {
		return seatsHeld;
	}

	public void setSeatsHeld(HashMap<String, Integer> seatsHeld) {
		this.seatsHeld = seatsHeld;
	}

	public int getNumSeatsOnHold() {
		return numSeatsOnHold;
	}

	public void setNumSeatsOnHold(int numSeatsOnHold) {
		//Number of seats already held is the size of the map which stores all the held seats
		numSeatsOnHold = getSeatsHeld().size();
		this.numSeatsOnHold = numSeatsOnHold;
	}


	
}
