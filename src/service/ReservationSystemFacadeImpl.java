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
	public List<Party> findPartiesByPlaceCode(String PlaceCode) {
		List<Party> res = new ArrayList<Party>();
		for (Place Place : dataSource.getPlaces()) {
			if (Place.getCode().equalsIgnoreCase(PlaceCode)) {
				List<Party> Parties = Place.getPartys();
				
				res.addAll(Parties);
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
        for (PartyInstance flighte : dataSource.getPartiesInstances()) {
            String dep = flighte.getLocation().getDeparturePlace().getCode();
            String arv = flighte.getLocation().getArrivalPlace().getCode();
            LocalDate dateV=flighte.getDate();
            
       if ((departurePlaceCode.equalsIgnoreCase(dep)) && (arrivalPlaceCode.equals(arv)&& dateV.equals(date))) {
                res.add(flighte);
            }
        }
        return res;
    }
	
	@Override
    public List<Reservation> findReservationsByGuestId(String guestId) {
        List<Reservation> res = new ArrayList<>();
        for (Reservation r : dataSource.getReservations()) {
            if (r.getGuest().getId().equalsIgnoreCase(guestId)) {
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
    public List<Guest> findGuestsByHostCode(String HostCode) {
        List<Guest> guest = new ArrayList<>();
        for (Reservation res : dataSource.getReservations()) {
            if (res.getHost() != null && res.getHost().getId().equalsIgnoreCase(HostCode)) {
                if (!guest.contains(res.getGuest())) {
                    guest.add(res.getGuest());
                }
            }
        }
        return guest;
    }
	
		
	@Override
	public List<Pass> confirmReservation(String reservationCode) {
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
		return reservation.getPasses();
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
       
        Guest guest = getGuestById(pId);
        
        if (guest != null) {
            ReservationFactory.buildAReservation(reservation, guest, null, PartyInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }
       
        return null;       
    }
   
    private Guest getGuestById(String pID) {
        for (Guest p : dataSource.getGuests()) {
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
        Guest passenger = getGuestById(pID);
       
        if (Host != null && guest != null) {
            ReservationFactory.buildAReservation(reservation, guest, Host, PartyInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }       
       
        return null;
    }
    
}
