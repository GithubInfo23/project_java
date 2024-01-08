package project_java.DAO;
import project_java.Models.*;
import project_java.Models.Fournisseur;

import java.sql.*;

public class Fournisseur_DAO {
    Connection con;
    ConnexionBDD cn=new ConnexionBDD();
    PreparedStatement statement;
    ResultSet resultset;

    public void ajouter_fournisseur(Fournisseur fournisseur){
        try {
            con = cn.getConnexion();
            statement=con.prepareStatement("insert into fournisseur(id_fournisseur,nom_fournisseur,date) values (?,?,?)");
            statement.setDate(3, fournisseur.getDate());
            statement.setInt(1,fournisseur.getId_fournisseur());
            statement.setString(2,fournisseur.getNom_fournisseur());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void supprimer_fournisseur(Fournisseur fournisseur){
        try {
            con = cn.getConnexion();
            statement= con.prepareStatement("Delete from fournisseur where id_fournisseur=?");
            statement.setInt(1,fournisseur.getId_fournisseur());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
