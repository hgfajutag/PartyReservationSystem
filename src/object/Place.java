package object;

import java.util.ArrayList;
import java.util.List;

public class Place {
	private String id;
	private String code;
	private String name;
	private Address address;
	
	private List<Location> location = new ArrayList<>();
	private List<Party> Partys = new ArrayList<>();
	
	public Place(String id, String code, String name, Address address) {
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

	public List<Location> getlocation() {
		return location;
	}

	public void setlocation(List<Location> location) {
		this.location = location;
	}

	public List<Party> getPartys() {
		return Partys;
	}

	public void setPartys(List<Party> Partys) {
		this.Partys = Partys;
	}
	
	public void addParty(Party Party) {
		this.Partys.add(Party);
	}
	
	public void addLocation(Location Location) {
		this.location.add(Location);
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	

	
	


}
