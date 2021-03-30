package object;

import java.util.List;

public class PartyInstanceFactory {
	
	public static PartyInstance buildAPartyInstance(
            PartyInstance PartyInstance,
           
            List<Pilot> pilots,
            List<Crew> crew
            ) {
       
        PartyInstance.setPilot(pilots);
        for (Pilot pilot : pilots) {
            pilot.addPartyInstance(PartyInstance);
        }
       
        PartyInstance.setCrew(crew);   
        for (Crew c : crew) {
            c.addPartyInstance(PartyInstance);
        }
       
        return PartyInstance;
    }
}
