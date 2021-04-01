package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pilot extends User {
	private float salary;
	private List<PartyInstance> partylist = new ArrayList<>();
	
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

	public List<PartyInstance> getPartylist() {
		return partylist;
	}

	public void setPartylist(List<PartyInstance> partylist) {
		this.partylist = partylist;
	}
	
	public void addPartyInstance(PartyInstance partyInstance) {
		this.partylist.add(partyInstance);
	}
	
	@Override
	public String toString() {
		return "Pilot [salary=" + salary + "," + super.toString() + "]";
	}
	

}
