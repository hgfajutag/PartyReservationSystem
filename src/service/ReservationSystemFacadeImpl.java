package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.DataSource;
import dto.DataSourceFactory;
import object.Agent;
import object.Airline;
import object.Airport;
import object.FlightInstance;
import object.Passenger;
import object.Reservation;
import object.ReservationFactory;
import object.Ticket;

public class ReservationSystemFacadeImpl implements ReservationSystemFacade {

	private DataSource dataSource = DataSourceFactory.getDataSource();
	
	@Override
	public List<Airport> findAllAirports() {
		return dataSource.getAirports();
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {			
		for (Airport airport : dataSource.getAirports()) {			
			if (airport.getCode().equalsIgnoreCase(airportCode)) {
				return airport;
			}
		}		
		return null;
	}
	
	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		List<Airline> res = new ArrayList<Airline>();
		for (Airport airport : dataSource.getAirports()) {
			if (airport.getCode().equalsIgnoreCase(airportCode)) {
				List<Airline> airLines = airport.getAirlines();
				
				res.addAll(airLines);
			}
		}
		return res;
	}


	
	public List<Airport> findAirportsByCity(String city) {
        List<Airport> res = new ArrayList<Airport>();
        for (Airport airport : dataSource.getAirports()) {
            if (city.equalsIgnoreCase(airport.getAddress().getCity())) {
                res.add(airport);
            }
        }
        return res;
    }

    @Override
    public List<FlightInstance> findFlightsFromTo(String departureAirPortCode,String arrivalAirportCode, 
            LocalDate date)  
    {
        List<FlightInstance> res = new ArrayList<FlightInstance>();
        for (FlightInstance flighte : dataSource.getFlightInstances()) {
            String dep = flighte.getFlight().getDepartureAirport().getCode();
            String arv = flighte.getFlight().getArrivalAirport().getCode();
            LocalDate dateV=flighte.getDate();
            
       if ((departureAirPortCode.equalsIgnoreCase(dep)) && (arrivalAirportCode.equals(arv)&& dateV.equals(date))) {
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
    public List<Reservation> findReservationsByAgentId(String passengerId) {

        List<Reservation> res = new ArrayList<>();
        for (Reservation r : dataSource.getReservations()) {
            if (r.getAgent().getId().equalsIgnoreCase(passengerId)) {
                res.add(r);
            }
        }

 

        return res;
    }

    @Override
    public List<Passenger> findPassengersByAgentCode(String agentCode) {
        List<Passenger> psgr = new ArrayList<>();
        for (Reservation res : dataSource.getReservations()) {
            if (res.getAgent() != null && res.getAgent().getId().equalsIgnoreCase(agentCode)) {
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
    public Reservation createReservation(String pId, List<FlightInstance> flightInstances) {
        Reservation reservation = new Reservation();
       
        Passenger passenger = getPassengerById(pId);
        
        if (passenger != null) {
            ReservationFactory.buildAReservation(reservation, passenger, null, flightInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }
       
        return null;       
    }
   
    private Passenger getPassengerById(String pID) {
        for (Passenger p : dataSource.getPassengers()) {
            if (p.getId().equalsIgnoreCase(pID)) {
                return p;
            }
        }
        return null;
    }
   
    private Agent getAgentById(String aID) {
        for (Agent agent : dataSource.getAgents()) {
            if (agent.getId().equalsIgnoreCase(aID)) {
                return agent;
            }
        }
        return null;
    }
   
   
    @Override
    public Reservation createReservation(String agentId, String pID, List<FlightInstance> flightInstances) {   
        Reservation reservation = new Reservation();
       
        Agent agent = getAgentById(agentId);
        Passenger passenger = getPassengerById(pID);
       
        if (agent != null && passenger != null) {
            ReservationFactory.buildAReservation(reservation, passenger, agent, flightInstances);
            dataSource.getReservations().add(reservation);
            return reservation;
        }       
       
        return null;
    }
    
}
