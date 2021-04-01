package object;

import java.util.List;

public class PartyInstanceFactory {
	
	public static PartyInstance buildAPartyInstance(
            PartyInstance partyInstance,
           
            List<Pilot> pilots,
            List<Crew> crew
            ) {
       
        partyInstance.setPilot(pilots);
        for (Pilot pilot : pilots) {
            pilot.addPartyInstance(partyInstance);
        }
       
        partyInstance.setCrew(crew);   
        for (Crew c : crew) {
            c.addPartyInstance(partyInstance);
        }
       
        return partyInstance;
    }
}
