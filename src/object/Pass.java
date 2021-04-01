package object;

import java.util.UUID;

public class Pass {
	
	private String id;
	private String number;
	private Guest guest;
	
	private Reservation reservation;
	private PartyInstance partyinstance;	
	
	public Pass(Guest guest) {
		this.id = UUID.randomUUID().toString();
		this.number = UUID.randomUUID().toString();
		this.guest = guest;
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
	
	public PartyInstance getPartyinstance() {
		return partyinstance;
	}
	
	public void setPartyinstance(PartyInstance partyinstance) {
		this.partyinstance = partyinstance;
	}
	
	public Guest getGuest() {
		return guest;
	}
	
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	@Override
	public String toString() {
		return "Pass [id=" + id + ", number=" + number + ", guest=" + guest + ", partyinstance="
				+ partyinstance + "]";
	}



}
