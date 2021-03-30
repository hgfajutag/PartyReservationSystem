package object;

import java.util.List;

public class ReservationFactory {
	
	public static Reservation buildAReservation(Reservation reservation,
			Guest passenger,
            Host agent,
           
            List<FlightInstance> flightInstances           
            ) {
       
        //link reservation and passenger
        reservation.setPassenger(passenger);
        passenger.addReservation(reservation);
       
        //link reservation and agent
        if(agent!=null) {
        reservation.setAgents(agent);
        agent.addReservation(reservation); }      
       
        //link reservation and FlightInstance
        reservation.setFlightsinstances(flightInstances);
       
        //generate ticket and link them all
        for (FlightInstance flightInstance : flightInstances) {
            TicketFactory.buildTicket(passenger, reservation, flightInstance);
        }
       
       
        return reservation;
    }
	
}
