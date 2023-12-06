package project_java.project_java.DAO;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnexionBDD {
    Connection con;

    public static Connection getConnexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "03112002");
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null ;
    }
}
