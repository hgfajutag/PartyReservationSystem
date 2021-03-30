package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pilot extends Person {
	private float salary;
	private List<PartyInstance> flightlist = new ArrayList<>();
	
	public Pilot(String id, String firstName, String lastName, String email, LocalDate dateOfbirth, Address address,
			float salary) {
		super(id, firstName, lastName, email, dateOfbirth, address);
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public List<PartyInstance> getFlightlist() {
		return flightlist;
	}

	public void setFlightlist(List<PartyInstance> flightlist) {
		this.flightlist = flightlist;
	}
	
	public void addPartyInstance(PartyInstance PartyInstance) {
		this.flightlist.add(PartyInstance);
	}
	
	@Override
	public String toString() {
		return "Pilot [salary=" + salary + "," + super.toString() + "]";
	}
	

}
