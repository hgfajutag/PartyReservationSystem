package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Guest extends User{
	
	private List<Reservation> reservations = new ArrayList<>();
	private List<Pass> passes = new ArrayList<>();
	
	
	public Guest(String id, String firstName, String lastName, String email, LocalDate dateOfbirth, Address address) {
		super(id, firstName, lastName, email, dateOfbirth, address);
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public List<Pass> getPasses() {
		return passes;
	}
	public void addPass(Pass pass) {
		this.passes.add(pass);
	}
	
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	
	@Override
	public String toString() {
		return "Guest [" + super.toString();
	}
	

}
