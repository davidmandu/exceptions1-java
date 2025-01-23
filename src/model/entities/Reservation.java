package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public Long duration() {

		return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
	}
	
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		
		return "Reservation: Room " 
		+ roomNumber 
		+ ", check-in: "
		+ checkin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+ ", check-out: "
		+ checkout.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+ ", "
		+ duration()
		+ " nights";
	}

}
