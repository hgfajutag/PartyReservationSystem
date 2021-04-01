package object;

public class PassFactory {
	public static Pass buildPass(Guest guest, Reservation reservation, PartyInstance partyInstance) {
        Pass pass = new Pass(guest);       
        guest.addPass(pass);
       
        pass.setReservation(reservation);
        reservation.addPass(pass);
       
        pass.setPartyinstance(partyInstance);
        partyInstance.addPass(pass);
       
        return pass;
    }

}
