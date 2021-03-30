package object;

import java.util.List;

public class PlaceFactory {
	
	public static Place buildPlace(Place Place, List<Party> parties) {	
		
		Place.setPartys(parties);
		for (Party Party : parties){
			Party.addPlace(Place);
		}
		
		return Place;
	}
}
