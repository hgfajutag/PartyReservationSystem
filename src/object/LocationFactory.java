package object;

import java.util.List;

public class LocationFactory {
	
	public static Location buildLocation(Location location, List<Place> places) {	
		
		location.setPlaces(places);
		for (Place place : places){
			place.addLocation(location);
		}
		
		return location;
	}
}
