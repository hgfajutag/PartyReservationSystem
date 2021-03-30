package object;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Reservation {
	private String reservationCode;
	private Guest passenger;
	private Host agent;
	private boolean confirmed=false;
	private List<FlightInstance> flightsinstances = new ArrayList<FlightInstance>();
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

	public Guest getPassenger() {
		return passenger;
	}

	public void setPassenger(Guest passenger) {
		this.passenger = passenger;
	}

	public Host getAgent() {
		return agent;
	}

	public void setAgents(Host agent) {
		this.agent = agent;
	}

	public List<FlightInstance> getFlightsinstances() {
		return flightsinstances;
	}

	public void setFlightsinstances(List<FlightInstance> flightsinstances) {
		this.flightsinstances = flightsinstances;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public void addFlightInstance(FlightInstance flightInstance) {
		this.flightsinstances.add(flightInstance);
	}
	
	@Override
	public String toString() {
		
		return "Reservation [confirmed="+ confirmed + " ,reservationCode=" + reservationCode + ", "
				+ "passenger=" + passenger.getFirstName() + " " + passenger.getLastName() + ", "
				+ "agent=" + (agent==null?"null":agent.getId()) + "]";
	}



	
}
