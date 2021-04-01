package dto;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import dbcon.ConnectionDB;
import object.Address;
import object.Host;
import object.LocationFactory;
import object.Place;
import object.Location;
import object.Crew;
import object.Party;
import object.PartyInstance;
import object.PartyInstanceFactory;
import object.Guest;
import object.Pilot;
import object.Reservation;
import object.ReservationFactory;
import object.Pass;
import java.sql.*; 

public class DataSource {

	private List<Place> _places = new ArrayList<>();
	private List<Location> _locations = new ArrayList<>();
	private List<Reservation> _reservations = new ArrayList<>();
	private List<Pilot> _pilots = new ArrayList<>();
	private List<Crew> _crew = new ArrayList<>();
	private List<Host> _hosts = new ArrayList<>();
	private List<Guest> _guests = new ArrayList<>();
	
	private List<Pass> _passs = new ArrayList<>();
	
	private List<PartyInstance> _partyInstances = new ArrayList<>();
	private List<Party> _partys = new ArrayList<>();
	
	DataSource() {		
		createPlace();
	}
	
	private void createPlace() {
		
		//String id, String code, String name, String history
		try {
			Connection n = ConnectionDB.conn(); 
			Statement stmt=n.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from place limit 3");  
			//ConnectionDB.close(n);
			while(rs.next()) {  
				String id = String.valueOf(rs.getInt(1));
				this._places.add(new Place(id , rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		this._locations = createLocation();		
		int[][] idx = new int[3][2];
		idx[0][0] = 0;
		idx[0][1] = 1;
		
		idx[1][0] = 1;
		idx[1][1] = 2;
		
		idx[2][0] = 0;
		idx[2][1] = 2;		
		int countX = 0;
		for (Location location : this._locations) {			
			LocationFactory.buildLocation(location, Arrays.asList(this._places.get(idx[countX][0]), this._places.get(idx[countX][1])));			
			countX++;
		}
		
		this._partys = createPartys(this._locations);
		
		this._pilots = createPilots();
		this._crew = createCrews();				
		this._hosts = createHosts();
		
		this._guests = createGuests();		
		this._passs = createPasss(this._guests);		
		
		
		this._partyInstances = createPartyInstaces(this._partys.get(0), this._partys.get(1));
		for (PartyInstance partyInstance : this._partyInstances) {
			PartyInstanceFactory.buildAPartyInstance(partyInstance, this._pilots, this._crew);
		}
		
		this._reservations = createReservations();
		int count = 0;
		for (Reservation reservation : this._reservations) {
			ReservationFactory.buildAReservation(reservation, this._guests.get(count), this._hosts.get(count), this._partyInstances);
			count++;
		}
		
	}
	
	
	private List<Location> createLocation() {
		List<Location> locations = new ArrayList<Location>();

		try {

			Connection n = ConnectionDB.conn(); 
			Statement stmt=n.createStatement(); 
			ResultSet ai=stmt.executeQuery("select a.id, a.code, a.name, ad.id, ad.street, ad.city, ad.state, ad.zip FROM location a INNER JOIN address ad ON a.addressid=ad.id limit 3");  
	
			while(ai.next()) {  
				String aiId = String.valueOf(ai.getInt(1));
				String adId2 = String.valueOf(ai.getInt(4));
				locations.add(new Location(aiId, ai.getString(2), ai.getString(3), new Address(adId2, ai.getString(5), ai.getString(6), ai.getString(7), ai.getString(8))));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return locations;
	}
	
	private List<Party> createPartys(List<Location> locations) {
		List<Party> partys = new ArrayList<Party>();
		try {
			Location strLocation = null;
			Connection n = ConnectionDB.conn(); 
			Statement stmt=n.createStatement(); 
			ResultSet fl=stmt.executeQuery("select * FROM party");
			//ConnectionDB.close(n);
			while(fl.next()) {  
				String aiId = String.valueOf(fl.getInt(1));
				int strlocationid = fl.getInt(6);
 
				Statement stmt2=n.createStatement(); 
				ResultSet airp1=stmt2.executeQuery("select a.id, a.code, a.name, ad.id, ad.street, ad.city, ad.state, ad.zip FROM location a INNER JOIN address ad ON a.addressid=ad.id  WHERE a.id = '"+strlocationid+"'");
				
				while(airp1.next()) {
					String aiId1 = String.valueOf(airp1.getInt(1));
					String adId2 = String.valueOf(airp1.getInt(4));
					strLocation = new Location(aiId1, airp1.getString(2), airp1.getString(3), new Address(adId2, airp1.getString(5), airp1.getString(6), airp1.getString(7), airp1.getString(8)));
					}

				partys.add(new Party(aiId, fl.getString(2), fl.getInt(3),  fl.getDate(4).toLocalDate(), fl.getDate(5).toLocalDate(), strLocation));

				
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		System.out.println(partys);
		//System.out.println(partys);
		return partys;
	}
	
	private List<PartyInstance> createPartyInstaces(Party party1, Party party2) {
		
		List<PartyInstance> res = new ArrayList<PartyInstance>();		
		

		
		PartyInstance f1 = new PartyInstance("FI1", party1, LocalDate.now());
		res.add(f1);
		
		
		PartyInstance f2 = new PartyInstance("FI2", party2, LocalDate.now());
		res.add(f2);
		
		return res;
	}
	
	
	private List<Pilot> createPilots() {		
		List<Pilot> pilots = new ArrayList<Pilot>();
		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM users p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofusers = 'HOST' limit 4");  

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
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM users p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofusers = 'HOST' limit 4");  

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
	
	
	private List<Host> createHosts() {		
		List<Host> res = new ArrayList<Host>();

		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM users p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofusers = 'HOST' limit 4");  

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
	
	private List<Guest> createGuests() {		
		List<Guest> res = new ArrayList<Guest>();
		
		try {

			Connection k = ConnectionDB.conn(); 
			Statement stmt6=k.createStatement(); 
			ResultSet p=stmt6.executeQuery("select p.id, p.firstName,p.lastName, p.email, p.dateOfbirth, ad.id, ad.street, ad.city, ad.state, ad.zip FROM users p INNER JOIN address ad  ON p.addressId = ad.id WHERE p.typeofusers = 'GUEST' limit 4");  

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
	
	
	private List<Pass> createPasss(List<Guest> guests) {
		List<Pass> passs = new ArrayList<Pass>();
		for (Guest p : guests) {
			Pass pass = new Pass(p);
			passs.add(pass);
		}
		
		return passs;
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

	
	
	public List<Place> getPlaces() {
		return _places;
	}

	public List<Location> getLocations() {
		return _locations;
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

	public List<Host> getHosts() {
		return _hosts;
	}

	public List<Guest> getGuests() {
		return _guests;
	}

	/*
	 * public List<Pass> getPasss() { return _passs; }
	 */


	 public List<PartyInstance> getPartyInstances() { return _partyInstances; }
	 

	
	 public List<Party> getPartys() { return this._partys; }
	 
	
	
	
	
	
	
}














