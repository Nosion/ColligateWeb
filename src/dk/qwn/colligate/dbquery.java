package dk.qwn.colligate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dbquery {
	
	public static String getGraphString() throws ClassNotFoundException {
		
		String GraphData2 = null;
	
		
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		
		try {
		connection = DriverManager.getConnection("jdbc:sqlite:C://Auctions.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);

			ResultSet rs = statement.executeQuery("SELECT * FROM Alliance WHERE Item = '18661'");
			
			List<String> AllianceItemIDlist = new ArrayList<String>();
			
			while(rs.next())
			{
				String itemId = rs.getString("auctionNumber");
				String bid = rs.getString("buyout");
				AllianceItemIDlist.add( "[" + itemId + ", " + bid + "], ");
			}
						
			int i = AllianceItemIDlist.size();
			System.out.println(i);
			//Manipulating the String GraphData
			//Because the index starts at 0 and not 1
			i = i - 1;
			String GraphData = "[";
			for(int j = 0; j <= i; ++j){
				GraphData += AllianceItemIDlist.get(j); 
				System.out.println(AllianceItemIDlist.get(j));	
			}
			//Removes the last "," and space, and adds "]"
			if(GraphData.endsWith(", ")){
			GraphData2 = GraphData.substring(0, GraphData.length() -2);
			}
			GraphData2 += "]";
			System.out.println("bot");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	         if(connection.isClosed() == false){
	    	  connection.close();
	    	  }

	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
		//Output to console to ensure String is ok.
		
		return GraphData2;
	}
}
