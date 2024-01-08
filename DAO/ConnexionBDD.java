package project_java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBDD {
    Connection con;

    public static Connection getConnexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/db1", "root", "20060102");

            if (con != null && !con.isClosed()) {
                System.out.println("Connected to the database!");
            }

            return con;
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return null;
    }
}
