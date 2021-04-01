package object;

import java.util.List;

public class ReservationFactory {
	
	public static Reservation buildAReservation(Reservation reservation,
            Guest guest,
            Host host,
           
            List<PartyInstance> partyInstances           
            ) {
       
        //link reservation and guest
        reservation.setGuest(guest);
        guest.addReservation(reservation);
       
        //link reservation and host
        if(host!=null) {
        reservation.setHosts(host);
        host.addReservation(reservation); }      
       
        //link reservation and PartyInstance
        reservation.setPartysinstances(partyInstances);
       
        //generate pass and link them all
        for (PartyInstance partyInstance : partyInstances) {
            PassFactory.buildPass(guest, reservation, partyInstance);
        }
       
       
        return reservation;
    }
	
}
