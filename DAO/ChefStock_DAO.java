package project_java.DAO;
import project_java.Models.Admin;
import project_java.Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ChefStock_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;

    public void ajouter_ChefStock(Chef_stock chefStock){
        try{
            con = cn.getConnexion();
            statement=con.prepareStatement("INSERT INTO chef_stock(choix_service,date,id_utilisateur) values (?,?,?)");
            statement.setString(1,chefStock.getChoix_service());
            statement.setDate(2,chefStock.getDate());
            statement.setInt(3,chefStock.getId_utilisateur());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void supprimer_chefStock(Chef_stock chefStock){
        try{
            con = cn.getConnexion();
            statement=con.prepareStatement("DELETE FROM chef_stock where id_chefstock=?");
            statement.setInt(1,chefStock.getId_chefstock());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
