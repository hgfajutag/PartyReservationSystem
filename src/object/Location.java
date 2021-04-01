package object;

import java.util.ArrayList;
import java.util.List;

public class Location {
	private String id;
	private String code;
	private String name;
	private Address address;
	
	private List<Party> partys = new ArrayList<>();
	private List<Place> places = new ArrayList<>();
	
	public Location(String id, String code, String name, Address address) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Party> getPartys() {
		return partys;
	}

	public void setPartys(List<Party> partys) {
		this.partys = partys;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	public void addPlace(Place place) {
		this.places.add(place);
	}
	
	public void addParty(Party party) {
		this.partys.add(party);
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + "]";
	}	
	
	
	
	

	
	


}
