package object;

public class PassFactory {
	public static Pass buildPass(Guest guest, Reservation reservation, PartyInstance PartyInstance) {
        Pass pass = new Pass(guest);       
        guest.addPass(pass);
       
        pass.setReservation(reservation);
        reservation.addPass(pass);
       
        pass.setPartyInstance(PartyInstance);
        PartyInstance.addPass(pass);
       
        return pass;
    }

}
