package object;

import java.util.ArrayList;
import java.util.List;

public class Place {
	private String id;
	private String code;
	private String name;
	private String history;
	
	
	private List<Party> partys = new ArrayList<>();
	private List<Location> locations = new ArrayList<>();
	
	public Place(String id, String code, String name, String history) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.history = history;	
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
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public List<Party> getPartys() {
		return partys;
	}
	public void setPartys(List<Party> partys) {
		this.partys = partys;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	
	public void addLocation(Location location) {
		this.locations.add(location);
	}
	
	public void addParty(Party party) {
		this.partys.add(party);
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", code=" + code + ", name=" + name + ", history=" + history + "]";
	}
	
	
	
	
	
	
}




