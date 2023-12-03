package org.model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connexion {
    Connection conn;
    public Connection getConnexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/STOCK","root","");
            return conn;
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Erreur de connexion");
        }
        return null;
    }

}
