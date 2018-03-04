package walmart.ReservationSystem;

import java.util.Scanner;

import walmart.ReservationSystem.service.SeatingReservation;

public class Start {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("\t\t\t Reservation System");
	System.out.println("\t\t\t *******************");
	System.out.println("\nOptions: 1. Available Seats 2. Request for Hold 3. Reserve Seats 4. Reserve prevously held seats 5. Exit.");
	int input = sc.nextInt();
	if (input > 0 && input <= 5) {
		SeatingReservation reserve = new SeatingReservation();
		switch (input) {
		case 1: System.out.println("Number available Seats are: " + reserve.numSeatsAvailable());
			break;
		case 2: System.out.println("Enter the number of seats to reserve:");
			int seatsReserve = sc.nextInt();
			System.out.println("Enter the email to reserve:");
			String customerEmail = sc.next();
			reserve.findAndHoldSeats(seatsReserve, customerEmail);
			System.out.println("Number of seats held are:" + seatsReserve + "for custome:" + customerEmail);
			System.out.println("Do you want to reserve now? (Yes or NO)");
			String response = sc.next();
			if (response.equalsIgnoreCase("yes")) {
				reserve.reserveSeats(seatsReserve, customerEmail);
				reserve.releaseSeatHold(seatsReserve, customerEmail);
				System.out.println("Reserved Seats are: " + seatsReserve + " for the custome email: " + customerEmail);
			}
			else if (response.equalsIgnoreCase("no")) {
				System.out.println("Your "+ seatsReserve + " seats are held sucessfully.");
				}
			else 
				System.out.println("Please select Yes or No");
			break;
		case 3: System.out.println("Enter the number of seats to reserve:");
				int seats = sc.nextInt();
				System.out.println("Enter the email to reserve:");
				String email = sc.next();
				reserve.reserveSeats(seats, email);
				System.out.println("Reserved Seats are:" + seats + "for the custome email" + email);
			break;
		case 4: System.out.println("Enter the number of seats to reserve:");
				int seatsReserved = sc.nextInt();
				System.out.println("Enter the email to reserve:");
				String emailId = sc.next();
				reserve.reserveHoldSeats(seatsReserved, emailId);
				break;
				
		case 5: System.out.println("Have a nice day!");
		
		}
		
		sc.close();
	}
	else
		System.out.println("Please enter valid input.");

	}
}
