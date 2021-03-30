package object;

public class TicketFactory {
	public static Ticket buildTicket(Guest passenger, Reservation reservation, PartyInstance PartyInstance) {
        Ticket ticket = new Ticket(passenger);       
        passenger.addTicket(ticket);
       
        ticket.setReservation(reservation);
        reservation.addTicket(ticket);
       
        ticket.setPartyInstance(PartyInstance);
        PartyInstance.addTicket(ticket);
       
        return ticket;
    }

}
