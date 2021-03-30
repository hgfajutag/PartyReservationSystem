package object;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Reservation {
	private String reservationCode;
	private Guest guest;
	private Host host;
	private boolean confirmed=false;
	private List<PartyInstance> partyinstances = new ArrayList<PartyInstance>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	public Reservation() {
		this.reservationCode = UUID.randomUUID().toString();
		
	}
	public boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	public Guest getguest() {
		return guest;
	}

	public void setguest(Guest guest) {
		this.guest = guest;
	}

	public Host gethost() {
		return host;
	}

	public void sethosts(Host host) {
		this.host = host;
	}

	public List<PartyInstance> getpartyinstances() {
		return partyinstances;
	}

	public void setpartyinstances(List<PartyInstance> partyinstances) {
		this.partyinstances = partyinstances;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public void addPartyInstance(PartyInstance PartyInstance) {
		this.partyinstances.add(PartyInstance);
	}
	
	@Override
	public String toString() {
		
		return "Reservation [confirmed="+ confirmed + " ,reservationCode=" + reservationCode + ", "
				+ "guest=" + guest.getFirstName() + " " + guest.getLastName() + ", "
				+ "host=" + (host==null?"null":host.getId()) + "]";
	}



	
}
