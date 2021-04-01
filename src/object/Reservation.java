package object;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Reservation {
	private String reservationCode;
	private Guest guest;
	private Host host;
	private boolean confirmed=false;
	private List<PartyInstance> partysinstances = new ArrayList<PartyInstance>();
	private List<Pass> passs = new ArrayList<Pass>();
	
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

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Host getHost() {
		return host;
	}

	public void setHosts(Host host) {
		this.host = host;
	}

	public List<PartyInstance> getPartysinstances() {
		return partysinstances;
	}

	public void setPartysinstances(List<PartyInstance> partysinstances) {
		this.partysinstances = partysinstances;
	}

	public List<Pass> getPasss() {
		return passs;
	}

	public void addPass(Pass pass) {
		this.passs.add(pass);
	}
	
	public void addPartyInstance(PartyInstance partyInstance) {
		this.partysinstances.add(partyInstance);
	}
	
	@Override
	public String toString() {
		
		return "Reservation [confirmed="+ confirmed + " ,reservationCode=" + reservationCode + ", "
				+ "guest=" + guest.getFirstName() + " " + guest.getLastName() + ", "
				+ "host=" + (host==null?"null":host.getId()) + "]";
	}



	
}
