package project_java.DAO;
import project_java.Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import project_java.Models.Fiche_mvt_stock;

public class fiche_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;

    public void ajouter_fich(Fiche_mvt_stock fiche){
        try{
            con=cn.getConnexion();
            statement=con.prepareStatement("INSERT INTO fiche_mvt_stock(id_fiche,n_bone,n_bons,fourn,qtt_e,qtt_s,obser,date,id_magasinier) values (?,?,?,?,?,?,?,?,?)");
            statement.setInt(1,fiche.getId_fiche());
            statement.setInt(2,fiche.getN_bone());
            statement.setInt(3,fiche.getN_bones());
            statement.setInt(5,fiche.getQtt_e());
            statement.setInt(6,fiche.getQtt_s());
            statement.setString(4, fiche.getFourn());
            statement.setString(7, fiche.getObser());
            statement.setDate(8,fiche.getDate());
            statement.setInt(9,fiche.getId_magasinier());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
