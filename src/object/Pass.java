package object;

import java.util.UUID;

public class Pass {
	
	private String id;
	private String number;
	private Guest guest;
	
	private Reservation reservation;
	private PartyInstance PartyInstance;	
	
	public Pass(Guest passenger) {
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
	
	public PartyInstance getPartyInstance() {
		return PartyInstance;
	}
	
	public void setPartyInstance(PartyInstance PartyInstance) {
		this.PartyInstance = PartyInstance;
	}
	
	public Guest getGuest() {
		return guest;
	}
	
	public void setPassenger(Guest guest) {
		this.guest = guest;
	}
	
	@Override
	public String toString() {
		return "Pass [id=" + id + ", number=" + number + ", guest=" + guest + ", PartyInstance="
				+ PartyInstance + "]";
	}



}
