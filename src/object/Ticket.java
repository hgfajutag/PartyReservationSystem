package object;

import java.util.UUID;

public class Ticket {
	
	private String id;
	private String number;
	private Guest passenger;
	
	private Reservation reservation;
	private FlightInstance flightinstance;	
	
	public Ticket(Guest passenger) {
		this.id = UUID.randomUUID().toString();
		this.number = UUID.randomUUID().toString();
		this.passenger = passenger;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public FlightInstance getFlightinstance() {
		return flightinstance;
	}
	
	public void setFlightinstance(FlightInstance flightinstance) {
		this.flightinstance = flightinstance;
	}
	
	public Guest getPassenger() {
		return passenger;
	}
	
	public void setPassenger(Guest passenger) {
		this.passenger = passenger;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", number=" + number + ", passenger=" + passenger + ", flightinstance="
				+ flightinstance + "]";
	}



}
