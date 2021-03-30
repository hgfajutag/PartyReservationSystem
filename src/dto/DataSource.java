package dto;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import dbcon.ConnectionDB;
import object.Address;
import object.AirPortFactory;
import object.Airline;
import object.Airport;
import object.Crew;
import object.Flight;
import object.FlightInstance;
import object.FlightInstanceFactory;
import object.Guest;
import object.Host;
import object.Pilot;
import object.Reservation;
import object.ReservationFactory;
import object.Ticket;
import java.sql.*; 

public class DataSource {

	private List<Airline> _airlines = new ArrayList<>();
	private List<Airport> _airports = new ArrayList<>();
	private List<Reservation> _reservations = new ArrayList<>();
	private List<Pilot> _pilots = new ArrayList<>();
	private List<Crew> _crew = new ArrayList<>();
	private List<Host> _agents = new ArrayList<>();
	private List<Guest> _passengers = new ArrayList<>();
	
	private List<Ticket> _tickets = new ArrayList<>();
	
	private List<FlightInstance> _flightInstances = new ArrayList<>();
	private List<Flight> _flights = new ArrayList<>();
	
	DataSource() {		
		createAirline();
	}
	
	private void createAirline() {
		
		//String id, String code, String name, String history
		try {
			Connection n = ConnectionDB.conn(); 
			Statement stmt=n.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from airline limit 3");  
			//ConnectionDB.close(n);
			while(rs.next()) {  
				String id = String.valueOf(rs.getInt(1));
				this._airlines.add(new Airline(id , rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		this._airports = createAirport();		
		int[][] idx = new int[3][2];
		idx[0][0] = 0;
		idx[0][1] = 1;
		
		idx[1][0] = 1;
		idx[1][1] = 2;
		
		idx[2][0] = 0;
		idx[2][1] = 2;		
		int countX = 0;
		for (Airport airport : this._airports) {			
			AirPortFactory.buildAirPort(airport, Arrays.asList(this._airlines.get(idx[countX][0]), this._airlines.get(idx[countX][1])));			
			countX++;
		}
		
		this._flights = createFlights(this._airports);
		
		this._pilots = createPilots();
		this._crew = createCrews();				
		this._agents = createAgents();
		
		this._passengers = createPassengers();		
		this._tickets = createTickets(this._passengers);		
		
		
		this._flightInstances = createFlightInstaces(this._flights.get(0), this._flights.get(1));
		for (FlightInstance flightInstance : this._flightInstances) {
			FlightInstanceFactory.buildAFlightInstance(flightInstance, this._pilots, this._crew);
		}
		
		this._reservations = createReservations();
		int count = 0;
		for (Reservation reservation : this._reservations) {
			ReservationFactory.buildAReservation(reservation, this._passengers.get(count), this._agents.get(count), this._flightInstances);
			count++;
		}
		
	}
	
	
	private List<Airport> createAirport() {
		List<Airport> airports = new ArrayList<Airport>();

		try {

			Connection n = ConnectionDB.conn(); 
			Statement stmt=n.createStatement(); 
			ResultSet ai=stmt.executeQuery("select a.id, a.code, a.name, ad.id, ad.street, ad.city, ad.state, ad.zip FROM airport a INNER JOIN address ad ON a.addressid=ad.id limit 3");  
	
			while(ai.next()) {  
				String aiId = String.valueOf(ai.getInt(1));
				String adId2 = String.valueOf(ai.getInt(4));
				airports.add(new Airport(aiId, ai.getString(2), ai.getString(3), new Address(adId2, ai.getString(5), ai.getString(6), ai.getString(7), ai.getString(8))));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return airports;
	}
	
	private List<Flight> createFlights(List<Airport> airports) {
		List<Flight> flights = new ArrayList<Flight>();
		try {
			Airport departureAirpot = null;
			Airport arrivalAirpot = null;
			Connection n = ConnectionDB.conn(); 
			Statement stmt=n.createStatement(); 
			ResultSet fl=stmt.executeQuery("select * FROM flight");
			//ConnectionDB.close(n);
			while(fl.next()) {  
				String aiId = String.valueOf(fl.getInt(1));
				int departureid = fl.getInt(6);
				int arrivalid = fl.getInt(7);
 
				Statement stmt2=n.createStatement(); 
				ResultSet airp1=stmt2.executeQuery("select a.id, a.code, a.name, ad.id, ad.street, ad.city, ad.state, ad.zip FROM airport a INNER JOIN address ad ON a.addressid=ad.id  WHERE a.id = '"+departureid+"'");
				

				Statement stmt3=n.createStatement(); 
				ResultSet airp2=stmt3.executeQuery("select a.id, a.code, a.name, ad.id, ad.street, ad.city, ad.state, ad.zip FROM airport a INNER JOIN address ad ON a.addressid=ad.id  WHERE a.id = '"+arrivalid+"'");  
			
				while(airp1.next()) {
					String aiId1 = String.valueOf(airp1.getInt(1));
					String adId2 = String.valueOf(airp1.getInt(4));
					departureAirpot = new Airport(aiId1, airp1.getString(2), airp1.getString(3), new Address(adId2, airp1.getString(5), airp1.getString(6), airp1.getString(7), airp1.getString(8)));
					}

				while(airp2.next()) {
					String aiId1 = String.valueOf(airp2.getInt(1));
					String adId2 = String.valueOf(airp2.getInt(4));
					arrivalAirpot = new Airport(aiId1, airp2.getString(2), airp2.getString(3), new Address(adId2, airp2.getString(5), airp2.getString(6), airp2.getString(7), airp2.getString(8)));
					}
				flights.add(new Flight(aiId, fl.getString(2), fl.getInt(3),  fl.getDate(4).toLocalDate(), fl.getDate(5).toLocalDate(), departureAirpot, arrivalAirpot));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		System.out.println(flights);
		return flights;
	}
	
	private List<FlightInstance> createFlightInstaces(Flight flight1, Flight flight2) {
		
		List<FlightInstance> res = new ArrayList<FlightInstance>();		
		

		
		FlightInstance f1 = new FlightInstance("FI1", flight1, LocalDate.now());
		res.add(f1);
		
		
		FlightInstance f2 = new FlightInstance("FI2", flight2, LocalDate.now());
		res.add(f2);
		
		return res;
	}
	
	
	private List<Pilot> createPilots() {		
		List<Pilot> pilots = new ArrayList<Pilot>();
		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM person p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofperson = 'AGENT' limit 4");  

			while(p.next()) {  
				String aiId = String.valueOf(p.getInt(1));
				String aiId2 = String.valueOf(p.getInt(6));
				pilots.add(new Pilot(aiId, p.getString(2), p.getString(3), p.getString(4),  p.getDate(5).toLocalDate(), new Address(aiId2, p.getString(7), p.getString(8), p.getString(9), p.getString(10)), 56.41f));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}

		return pilots;
	}
	
	
	private List<Crew> createCrews() {		
		List<Crew> res = new ArrayList<Crew>();
		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM person p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofperson = 'AGENT' limit 4");  

			while(p.next()) {  
				String aiId = String.valueOf(p.getInt(1));
				String aiId2 = String.valueOf(p.getInt(6));
				res.add(new Crew(aiId, p.getString(2), p.getString(3), p.getString(4),  p.getDate(5).toLocalDate(), new Address(aiId2, p.getString(7), p.getString(8), p.getString(9), p.getString(10)), 56.41f));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}

		return res;
	}
	
	
	private List<Host> createAgents() {		
		List<Host> res = new ArrayList<Host>();

		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM person p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofperson = 'AGENT' limit 4");  

			while(p.next()) {  
				String aiId = String.valueOf(p.getInt(1));
				String aiId2 = String.valueOf(p.getInt(6));
				res.add(new Host(aiId, p.getString(2), p.getString(3), p.getString(4),  p.getDate(5).toLocalDate(), new Address(aiId2, p.getString(7), p.getString(8), p.getString(9), p.getString(10))));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}

		return res;
	}
	
	
	private List<Reservation> createReservations() {	
		List<Reservation> res = new ArrayList<Reservation>();
		
		Reservation reservation1 = new Reservation();
		res.add(reservation1);
		
		Reservation reservation2 = new Reservation();
		res.add(reservation2);
		
		return res;
	}
	
	private List<Guest> createPassengers() {		
		List<Guest> res = new ArrayList<Guest>();
		
		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM person p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofperson = 'PASSENGER' limit 4");  

			while(p.next()) {  
				String aiId = String.valueOf(p.getInt(1));
				String aiId2 = String.valueOf(p.getInt(6));
				res.add(new Guest(aiId, p.getString(2), p.getString(3), p.getString(4),  p.getDate(5).toLocalDate(), new Address(aiId2, p.getString(7), p.getString(8), p.getString(9), p.getString(10))));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}

		return res;
	}
	
	
	private List<Ticket> createTickets(List<Guest> passengers) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		for (Guest p : passengers) {
			Ticket ticket = new Ticket(p);
			tickets.add(ticket);
		}
		
		return tickets;
	}
	
	
	
	private Address getRandomAdress() {
		return new Address(getRandomString(), getRandomString(), getRandomString(), getRandomString(), getRandomString());
	}
	
	private String getRandomString() {		
		byte[] array = new byte[4];
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    return generatedString;
	}

	
	
	public List<Airline> getAirlines() {
		return _airlines;
	}

	public List<Airport> getAirports() {
		return _airports;
	}

	public List<Reservation> getReservations() {
		return _reservations;
	}

	/*
	 * public List<Pilot> getPilots() { return _pilots; }
	 */

	/*
	 * public List<Crew> getCrew() { return _crew; }
	 */

	public List<Host> getAgents() {
		return _agents;
	}

	public List<Guest> getPassengers() {
		return _passengers;
	}

	/*
	 * public List<Ticket> getTickets() { return _tickets; }
	 */


	 public List<FlightInstance> getFlightInstances() { return _flightInstances; }
	 

	/*
	 * public List<Flight> getFlights() { return this._flights; }
	 */
	
	
	
	
	
	
}














