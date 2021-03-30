package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Crew extends Person {
	private float salary;
	private List<PartyInstance> Partylist = new ArrayList<>();
	
	public Crew(String id, String firstName, String lastName, String email, LocalDate dateOfbirth, Address address,
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
		return Partylist;
	}

	public void setPartylist(List<PartyInstance> Partylist) {
		this.Partylist = Partylist;
	}
	
	public void addPartyInstance(PartyInstance PartyInstance) {
		this.Partylist.add(PartyInstance);
	}
	
	@Override
	public String toString() {
		return "Crew [salary=" + salary + "," + super.toString() + "]";
	}


}
