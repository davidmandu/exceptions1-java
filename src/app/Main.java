package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), dtf);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), dtf);

		if (checkout.isBefore(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} 
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), dtf);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), dtf);
			
			if(checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (checkout.isBefore(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println(reservation);
			}
				
		}
		sc.close();
	}
}