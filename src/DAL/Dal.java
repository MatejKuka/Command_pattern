package DAL;

import DAL.Connector.DBconnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dal {

    private DBconnector connector;

    public Dal() throws IOException {
        connector = new DBconnector();
    }

    public void testMethod () {
        try(Connection con = connector.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");


        }
        catch (Exception sqle){
            System.out.println("Error: " + sqle);
        }
    }
}
