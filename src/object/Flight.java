package object;

import java.time.LocalDate;

public class Flight {

	private String id;
	private String number;
	private int capacity;
	
	private LocalDate departureTime;
	private LocalDate arrivalTime;
	
	private Airport departureAirport;
	private Airport arrivalAirport;

	public Flight(String id, String number, int capacity, 
			LocalDate departureTime, LocalDate arrivalTime,
			Airport departureAirport, 
			Airport arrivalAirport
			) {
		
		this.id = id;
		this.number = number;
		this.capacity = capacity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		
		this.departureAirport = departureAirport;
		this.departureAirport.addFlight(this);
		
		
		this.arrivalAirport = arrivalAirport;
		this.arrivalAirport.addFlight(this);
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDate getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
		
		departureAirport.addFlight(this);
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", number=" + number + ", capacity=" + capacity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", departureAirport=" + departureAirport + ", arrivalAirport="
				+ arrivalAirport + "]";
	}
	
	


}
