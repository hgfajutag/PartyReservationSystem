package object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartyInstance {

	private String id;
	private Party party;
	private LocalDate date;
	
	private List<Crew> crew = new ArrayList<>();
	private List<Pilot> pilots = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();
	private List<Pass> passs = new ArrayList<>();

	public PartyInstance(String id, Party party, LocalDate date) {	
		this.id = id;
		this.party = party;
		this.date = date;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Party getParty() {
		return party;
	}
	
	public void setParty(Party party) {
		this.party = party;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public List<Crew> getCrew() {
		return crew;
	}
	
	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}
	
	public List<Pilot> getPilot() {
		return pilots;
	}
	
	public void setPilot(List<Pilot> pilots) {
		this.pilots = pilots;		
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public List<Pass> getPasss() {
		return passs;
	}
	
	public void addPass(Pass pass) {
		this.passs.add(pass);
	}


	@Override
	public String toString() {
		return "PartyInstance [id=" + id + ", party=" + party + ", date=" + date + "]";
	}






}
