package DAL;

import DAL.Connector.DBconnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dall {

    private DBconnector connector;

    public Dall() throws IOException {
        connector = new DBconnector();
    }

    public void testMethod () {
        try(Connection con = connector.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            System.out.println("si gay? " + rs);

            //String readSQL = rs.getNString("Name");
            //System.out.println(readSQL);
        }
        catch (Exception sqle){
            System.out.println("Error: " + sqle);
        }
    }
}
