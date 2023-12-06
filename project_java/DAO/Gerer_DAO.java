package project_java.project_java.DAO;
import project_java.project_java.Models.*;

import java.sql.*;


public class Gerer_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;

    public void assigner(Utilisateur utilisateur, Stock stock){
        try {
            con = cn.getConnexion();
            statement=con.prepareStatement("INSERT INTO gerer(id_stock,id_utilisateur) values(?,?)");
            statement.setInt(2,utilisateur.getId_utilisateur());
            statement.setInt(1,stock.getIdStock());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void desassigner(Utilisateur utilisateur, Stock stock){
        try {
            con = cn.getConnexion();
            statement=con.prepareStatement("Delete from gerer where id_stock=? and id_utilisateur=?");
            statement.setInt(2,utilisateur.getId_utilisateur());
            statement.setInt(1,stock.getIdStock());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
