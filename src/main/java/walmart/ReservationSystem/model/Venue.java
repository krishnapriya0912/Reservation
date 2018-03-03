package walmart.ReservationSystem.model;

public class Venue {
	// Assuming that there are 200 seats in the venue.
	// If the DB is connected then can get rid off the initialization.
	
	private int totalAvailableSeats = 200;


	public int getTotalAvailableSeats() {
		return totalAvailableSeats;
	}

	public void setTotalAvailableSeats(int totalAvailableSeats) {
		this.totalAvailableSeats = totalAvailableSeats;
	}
	
}
