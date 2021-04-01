package dbcon;

import java.sql.*; 

public class MainTest {

	public static void main(String[] args) throws SQLException {
		Connection n = ConnectionDB.conn(); 
		Statement stmt=n.createStatement(); 
		ResultSet rs=stmt.executeQuery("select a.id, a.code, a.name, ad.id, ad.street, ad.city, ad.state, ad.zip FROM location a INNER JOIN address ad ON a.addressid=ad.id ");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)); 

	}

}
