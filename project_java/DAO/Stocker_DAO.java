package project_java.project_java.DAO;
import project_java.project_java.Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Stocker_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;

    public void stocker(Stocker stocker){
        try{
            con=cn.getConnexion();
            statement=con.prepareStatement("INSERT INTO stocker(num_be,qtt_e,transfert,monda,montotda,date,id_produit,id_stock) values(?,?,?,?,?,?,?,?)");
            statement.setInt(1,stocker.getNumBe());
            statement.setInt(2,stocker.getQttE());
            statement.setBoolean(3,stocker.getTransfert());
            statement.setFloat(4,stocker.getMonda());
            statement.setFloat(5,stocker.getMontotda());
            statement.setDate(6,stocker.getDate());
            statement.setInt(7,stocker.getIdProduit());
            statement.setInt(8,stocker.getIdStock());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
