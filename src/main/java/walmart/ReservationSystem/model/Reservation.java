package walmart.ReservationSystem.model;

public class Reservation {
	
	private int numSeats;
	
	private String customerEmail;
	
	// Assuming that 20 seats reserved.
	// If the DB is connected then can get rid off the initialization.
	private int totalReservedSeats = 20;

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getTotalReservedSeats() {
		return totalReservedSeats;
	}

	public void setTotalReservedSeats(int totalReservedSeats) {
		// TotalReserved seats is seats already reserved + new seats reservation
		totalReservedSeats = getTotalReservedSeats() + getNumSeats();
		this.totalReservedSeats = totalReservedSeats;
	}
	
	

}
