package object;

import java.time.LocalTime;

public class Party {

	private String id;
	private String number;
	private int capacity;
	
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	
	private Place departurePlace;
	private Place arrivalPlace;

	public Party(String id, String number, int capacity, 
			LocalTime departureTime, LocalTime arrivalTime,
			Place departurePlace, 
			Place arrivalPlace
			) {
		
		this.id = id;
		this.number = number;
		this.capacity = capacity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		
		this.departurePlace = departurePlace;
		this.departurePlace.addParty(this);
		
		
		this.arrivalPlace = arrivalPlace;
		this.arrivalPlace.addParty(this);
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

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Place getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(Place departurePlace) {
		this.departurePlace = departurePlace;
		
		departurePlace.addParty(this);
	}

	public Place getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(Place arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", number=" + number + ", capacity=" + capacity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", departurePlace=" + departurePlace + ", arrivalPlace="
				+ arrivalPlace + "]";
	}

	public void addPlace(Place place) {
		// TODO Auto-generated method stub
		
	}
	
	


}
