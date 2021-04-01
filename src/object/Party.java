package object;

import java.time.LocalDate;

public class Party {

	private String id;
	private String number;
	private int capacity;
	
	private LocalDate startTime;
	private LocalDate endTime;
	
	private Location strLocation;

	public Party(String id, String number, int capacity, 
			LocalDate startTime, LocalDate endTime,
			Location strLocation
			) {
		
		this.id = id;
		this.number = number;
		this.capacity = capacity;
		this.startTime = startTime;
		this.endTime = endTime;
		
		this.strLocation = strLocation;
		this.strLocation.addParty(this);
		
		
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

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public Location getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(Location strLocation) {
		this.strLocation = strLocation;
		
		strLocation.addParty(this);
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", number=" + number + ", capacity=" + capacity + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", strLocation=" + strLocation + "]";
	}
	
	


}
