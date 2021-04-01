package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Host extends User {

	private List<Reservation> reservations = new ArrayList<>();

	public Host(String id, String firstName, String lastName, String email, LocalDate dateOfbirth, Address address) {
		super(id, firstName, lastName, email, dateOfbirth, address);
	}

	public List<Reservation> getReservation() {
		return reservations;
	}
	
	@Override
	public String toString() {
		return "Host [ " + super.toString();
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	

}
