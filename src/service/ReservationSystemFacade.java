package service;

import java.time.LocalDate;
import java.util.List;

import object.Host;
import object.Party; //Airline
import object.Place; //Aiport
import object.PartyInstance; //PartyInstance
import object.Guest;
import object.Reservation;
import object.Pass;

public interface ReservationSystemFacade {
	
	List<Place> findAllPlaces();	
	Place findPlaceByPlaceCode(String PlaceCode);
	
	
	List<Place> findPlacesByCity(String city); // Place(s) of a city, e.g. Chicago has two major Places	
	List<Party> findPartysByPlaceCode(String PlaceCode);
	
	List<PartyInstance> findLocationsFromTo(String departurePlaceCode, String arrivalPlaceCode, LocalDate date);	
	List<Reservation> findReservationsByGuestId(String guestId);
	
	List<Guest> findPassengersByHostCode(String hostCode);	
	
	Reservation createReservation(String guest, List<PartyInstance> PartyInstances); // Guest reserves
	Reservation createReservation(String host, String guest, List<PartyInstance> PartyInstances); // Host reserves
	
	List<Pass> confirmReservation(String reservationCode);	
	boolean cancelReservation(String reservationCode);
	List<Reservation> findReservationsByHostId(String guestId);
	
	
}
