package object;

import java.util.List;

public class ReservationFactory {
	
	public static Reservation buildAReservation(Reservation reservation,
			Guest guest,
            Host host,
           
            List<PartyInstance> PartyInstances           
            ) {
       
        //link reservation and guest
        reservation.setguest(guest);
        guest.addReservation(reservation);
       
        //link reservation and host
        if(host!=null) {
        reservation.sethosts(host);
        host.addReservation(reservation); }      
       
        //link reservation and PartyInstance
        reservation.setpartyinstances(PartyInstances);
       
        //generate pass and link them all
        for (PartyInstance PartyInstance : PartyInstances) {
           PassFactory.buildPass(guest, reservation, PartyInstance);
        }
       
       
        return reservation;
    }
	
}
