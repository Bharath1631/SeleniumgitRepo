package testCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import resources.Base;
import resources.Log;

public class DatabaseConnectionTest extends Base{
	
		
	    @Test
	    public void executeConnection() throws SQLException, InstantiationException, IllegalAccessException, IOException {
	    	
	    	Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
	    	PreparedStatement pstmt = DB.prepareStatement("select * from partners_profile where email=?;");
	    	pstmt.setString(1, readProperties("newEmail"));
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int ID= rs.getInt("id");
				Log.info("ID is" +ID);
			}
			
			DB.close();
	    	Log.info("--------Database connection closed successfully----------");
	    }
	
}

