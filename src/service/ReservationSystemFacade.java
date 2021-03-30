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
	
	List<PartyInstance> findFlightsFromTo(String departurePlaceCode, String arrivalPlaceCode, LocalDate date);	
	List<Reservation> findReservationsByPassengerId(String passengerId);
	
	List<Guest> findPassengersByAgentCode(String agentCode);	
	
	Reservation createReservation(String passenger, List<PartyInstance> PartyInstances); // Passenger reserves
	Reservation createReservation(String agent, String passenger, List<PartyInstance> PartyInstances); // Agent reserves
	
	List<Pass> confirmReservation(String reservationCode);	
	boolean cancelReservation(String reservationCode);
	List<Reservation> findReservationsByAgentId(String passengerId);
	
	
}
