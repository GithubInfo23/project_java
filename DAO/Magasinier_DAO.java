package project_java.DAO;
import project_java.Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Magasinier_DAO {
        Connection con;
        ConnexionBDD cn= new ConnexionBDD();
        PreparedStatement statement;

        public void ajouter_Magasinier(Magasinier magasinier){
            try{
                con = cn.getConnexion();
                statement=con.prepareStatement("INSERT INTO magasinier(choix_service,date,id_utilisateur) values (?,?,?)");
                statement.setString(1,magasinier.getChoix_service());
                statement.setDate(2,magasinier.getDate());
                statement.setInt(3,magasinier.getId_utilisateur());
                statement.execute();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    public void supprimer_magasinier(Magasinier magasinier){
        try{
            con = cn.getConnexion();
            statement=con.prepareStatement("DELETE FROM magasinier where id_magasinier=?");
            statement.setInt(1,magasinier.getId_magasinier());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
