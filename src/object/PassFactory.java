package object;

public class PassFactory {
	public static Pass buildPass(Guest passenger, Reservation reservation, PartyInstance PartyInstance) {
        Pass pass = new Pass(passenger);       
        passenger.addPass(pass);
       
        pass.setReservation(reservation);
        reservation.addPass(pass);
       
        pass.setPartyInstance(PartyInstance);
        PartyInstance.addPass(pass);
       
        return pass;
    }

}
