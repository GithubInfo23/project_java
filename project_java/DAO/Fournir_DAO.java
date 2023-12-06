package project_java.project_java.DAO;
import project_java.project_java.Models.*;

import java.sql.*;

public class Fournir_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;
    ResultSet resultSet;

    public void ajout_fournir(Fournisseur fournisseur, Produit produit, Date date){
        try{
            con=cn.getConnexion();
            statement=con.prepareStatement("INSERT INTO fournir(date,id_fournisseur,id_produit) values(?,?,?)");
            statement.setInt(2,produit.getId_produit());
            statement.setInt(3,fournisseur.getId_fournisseur());
            statement.setDate(1,date);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
