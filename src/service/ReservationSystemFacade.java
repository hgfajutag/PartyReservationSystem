package service;

import java.time.LocalDate;
import java.util.List;

import javafx.scene.control.TextField;
import object.Host;
import object.Place;
import object.Location;
import object.PartyInstance;
import object.Guest;
import object.Reservation;
import object.Pass;

public interface ReservationSystemFacade {
	
	List<Location> findAllLocations();	
	Location findLocationByLocationCode(String locationCode);
	
	
	List<Location> findLocationsByCity(String city); // Location(s) of a city, e.g. Chicago has two major locations	
	List<Place> findPlacesByLocationCode(String locationCode);
	
	List<PartyInstance> findPartysFromTo(String strLocationCode, LocalDate date);	
	List<Reservation> findReservationsByGuestId(String guestId);
	
	List<Guest> findGuestsByHostCode(String hostCode);	
	
	Reservation createReservation(String guest, List<PartyInstance> partyInstances); // Guest reserves
	Reservation createReservation(String host, String guest, List<PartyInstance> partyInstances); // Host reserves
	
	List<Pass> confirmReservation(String reservationCode);	
	boolean cancelReservation(String reservationCode);
	List<Reservation> findReservationsByHostId(String guestId);
	
	
}
