package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.DataSource;
import dto.DataSourceFactory;
import object.Host;
import object.Place;
import object.Location;
import object.PartyInstance;
import object.Guest;
import object.Reservation;
import object.ReservationFactory;
import object.Pass;

public class ReservationSystemFacadeImpl implements ReservationSystemFacade {

	private DataSource dataSource = DataSourceFactory.getDataSource();
	
	@Override
	public List<Location> findAllLocations() {
		return dataSource.getLocations();
	}

	@Override
	public Location findLocationByLocationCode(String locationCode) {			
		for (Location location : dataSource.getLocations()) {			
			if (location.getCode().equalsIgnoreCase(locationCode)) {
				return location;
			}
		}		
		return null;
	}
	
	@Override
	public List<Place> findPlacesByLocationCode(String locationCode) {
		List<Place> res = new ArrayList<Place>();
		for (Location location : dataSource.getLocations()) {
			if (location.getCode().equalsIgnoreCase(locationCode)) {
				List<Place> ltPlaces = location.getPlaces();
				
				res.addAll(ltPlaces);
			}
		}
		return res;
	}


	
	public List<Location> findLocationsByCity(String city) {
        List<Location> res = new ArrayList<Location>();
        for (Location location : dataSource.getLocations()) {
            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
                res.add(location);
            }
        }
        return res;
    }

    @Override
    public List<PartyInstance> findPartysFromTo(String strLocationCode, 
            LocalDate date)  
    {
        List<PartyInstance> res = new ArrayList<PartyInstance>();
        for (PartyInstance partye : dataSource.getPartyInstances()) {
            String dep = partye.getParty().getStrLocation().getCode();
            LocalDate dateV=partye.getDate();
            
       if ((strLocationCode.equalsIgnoreCase(dep)) &&  dateV.equals(date)) {
                res.add(partye);
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
    public List<Reservation> findReservationsByHostId(String guestId) {

        List<Reservation> res = new ArrayList<>();
        for (Reservation r : dataSource.getReservations()) {
            if (r.getHost().getId().equalsIgnoreCase(guestId)) {
                res.add(r);
            }
        }

 

        return res;
    }

    @Override
    public List<Guest> findGuestsByHostCode(String hostCode) {
        List<Guest> psgr = new ArrayList<>();
        for (Reservation res : dataSource.getReservations()) {
            if (res.getHost() != null && res.getHost().getId().equalsIgnoreCase(hostCode)) {
                if (!psgr.contains(res.getGuest())) {
                    psgr.add(res.getGuest());
                }
            }
        }
        return psgr;
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
		return reservation.getPasss();
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
    public Reservation createReservation(String pId, List<PartyInstance> partyInstances) {
        Reservation reservation = new Reservation();
       
        Guest guest = getGuestById(pId);
        
        if (guest != null) {
            ReservationFactory.buildAReservation(reservation, guest, null, partyInstances);
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
        for (Host host : dataSource.getHosts()) {
            if (host.getId().equalsIgnoreCase(aID)) {
                return host;
            }
        }
        return null;
    }
   
   
    @Override
    public Reservation createReservation(String hostId, String pID, List<PartyInstance> partyInstances) {   
        Reservation reservation = new Reservation();
       
        Host host = getHostById(hostId);
        Guest guest = getGuestById(pID);
       
        if (host != null && guest != null) {
            ReservationFactory.buildAReservation(reservation, guest, host, partyInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }       
       
        return null;
    }
    
}
