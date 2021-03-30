package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.DataSource;
import dto.DataSourceFactory;
import object.Host;
import object.Party;
import object.Place;
import object.PartyInstance;
import object.Guest;
import object.Reservation;
import object.ReservationFactory;
import object.Ticket;

public class ReservationSystemFacadeImpl implements ReservationSystemFacade {

	private DataSource dataSource = DataSourceFactory.getDataSource();
	
	@Override
	public List<Place> findAllPlaces() {
		return dataSource.Place();
	}

	@Override
	public Place findPlaceByPlaceCode(String PlaceCode) {			
		for (Place Place : dataSource.getPlaces()) {			
			if (Place.getCode().equalsIgnoreCase(PlaceCode)) {
				return Place;
			}
		}		
		return null;
	}
	
	@Override
	public List<Party> findPartysByPlaceCode(String PlaceCode) {
		List<Party> res = new ArrayList<Party>();
		for (Place Place : dataSource.getPlaces()) {
			if (Place.getCode().equalsIgnoreCase(PlaceCode)) {
				List<Party> Partys = Place.getPartys();
				
				res.addAll(Partys);
			}
		}
		return res;
	}


	
	public List<Place> findPlacesByCity(String city) {
        List<Place> res = new ArrayList<Place>();
        for (Place Place : dataSource.getPlaces()) {
            if (city.equalsIgnoreCase(Place.getAddress().getCity())) {
                res.add(Place);
            }
        }
        return res;
    }

    @Override
    public List<PartyInstance> findFlightsFromTo(String departurePlaceCode,String arrivalPlaceCode, 
            LocalDate date)  
    {
        List<PartyInstance> res = new ArrayList<PartyInstance>();
        for (PartyInstance flighte : dataSource.getPartyInstances()) {
            String dep = flighte.getFlight().getDeparturePlace().getCode();
            String arv = flighte.getFlight().getArrivalPlace().getCode();
            LocalDate dateV=flighte.getDate();
            
       if ((departurePlaceCode.equalsIgnoreCase(dep)) && (arrivalPlaceCode.equals(arv)&& dateV.equals(date))) {
                res.add(flighte);
            }
        }
        return res;
    }
	
	@Override
    public List<Reservation> findReservationsByPassengerId(String passengerId) {
        List<Reservation> res = new ArrayList<>();
        for (Reservation r : dataSource.getReservations()) {
            if (r.getPassenger().getId().equalsIgnoreCase(passengerId)) {
                res.add(r);
            }
        }
        return res;
    }
	
	@Override
    public List<Reservation> findReservationsByHostId(String passengerId) {

        List<Reservation> res = new ArrayList<>();
        for (Reservation r : dataSource.getReservations()) {
            if (r.getHost().getId().equalsIgnoreCase(passengerId)) {
                res.add(r);
            }
        }

 

        return res;
    }

    @Override
    public List<Guest> findPassengersByHostCode(String HostCode) {
        List<Guest> psgr = new ArrayList<>();
        for (Reservation res : dataSource.getReservations()) {
            if (res.getHost() != null && res.getHost().getId().equalsIgnoreCase(HostCode)) {
                if (!psgr.contains(res.getPassenger())) {
                    psgr.add(res.getPassenger());
                }
            }
        }
        return psgr;
    }
	
		
	@Override
	public List<Ticket> confirmReservation(String reservationCode) {
		Reservation reservation=null;
		for (Reservation reservation1 : dataSource.getReservations()) {			
			if (reservation1.getReservationCode().equalsIgnoreCase(reservationCode)) {
				reservation=reservation1;
				break;
			}
		}
		if(reservation!=null) {
			reservation.setConfirmed(true);
		}
		return reservation.getTickets();
	}

	@Override
	public boolean cancelReservation(String reservationCode) {
		for (Reservation reservation1 : dataSource.getReservations()) {			
			if (reservation1.getReservationCode().equalsIgnoreCase(reservationCode)) {
				dataSource.getReservations().remove(reservation1);
				return true;
			};
		}
		return false;
	}
		
	
    @Override
    public Reservation createReservation(String pId, List<PartyInstance> PartyInstances) {
        Reservation reservation = new Reservation();
       
        Guest passenger = getPassengerById(pId);
        
        if (passenger != null) {
            ReservationFactory.buildAReservation(reservation, passenger, null, PartyInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }
       
        return null;       
    }
   
    private Guest getPassengerById(String pID) {
        for (Guest p : dataSource.getPassengers()) {
            if (p.getId().equalsIgnoreCase(pID)) {
                return p;
            }
        }
        return null;
    }
   
    private Host getHostById(String aID) {
        for (Host Host : dataSource.getHosts()) {
            if (Host.getId().equalsIgnoreCase(aID)) {
                return Host;
            }
        }
        return null;
    }
   
   
    @Override
    public Reservation createReservation(String HostId, String pID, List<PartyInstance> PartyInstances) {   
        Reservation reservation = new Reservation();
       
        Host Host = getHostById(HostId);
        Guest passenger = getPassengerById(pID);
       
        if (Host != null && passenger != null) {
            ReservationFactory.buildAReservation(reservation, passenger, Host, PartyInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }       
       
        return null;
    }
    
}
