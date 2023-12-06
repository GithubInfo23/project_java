package project_java.project_java.DAO;
import project_java.project_java.Models.*;
import java.util.*;
import java.sql.*;

public class Produit_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;
    ResultSet resultset;

    public void ajouter_produit(Produit produit){
        try {
            con = cn.getConnexion();
            statement = con.prepareStatement("insert into produit(id_produit,nom_produit,prix_unitaire,quantite) values(?,?,?,?)");
            statement.setInt(1, produit.getId_produit());
            statement.setString(2, produit.getNom_produit());
            statement.setFloat(3, produit.getPrix_unitaire());
            statement.setInt(4, produit.getQuantite());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List Lister(){
        List<Produit> list= new ArrayList<Produit>();
        try{
            con=cn.getConnexion();
            statement= con.prepareStatement("Select * from produit");
            resultset=statement.executeQuery();
            while ( resultset.next()) {
                int id=resultset.getInt("id_produit");
                String nom=resultset.getString("nom_produit");
                float prix=resultset.getFloat("prix_unitaire");
                int qtt=resultset.getInt("quantite");
                String ref=resultset.getString("ref");
                String obs=resultset.getString("obs");
                java.sql.Date date=resultset.getDate("date");
               Produit produit= new Produit(id,nom,prix,qtt,ref,obs,date);
               list.add(produit);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void supprimer_produit(Produit produit){
        try {
            con = cn.getConnexion();
            statement= con.prepareStatement("Delete from produit where id_produit=?");
            statement.setInt(1,produit.getId_produit());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
