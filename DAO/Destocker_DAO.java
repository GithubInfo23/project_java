package project_java.DAO;
import project_java.Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Destocker_DAO {

    Connection con;
    ConnexionBDD cn = new ConnexionBDD();
    PreparedStatement statement;

    public void destocker(Destocker destocker) {
        try {
            con = cn.getConnexion();
            statement = con.prepareStatement("INSERT INTO destocker(num_bs,qtt_s,qtt_d,transfert,montda,consommation,date,id_produit,id_stock) values(?,?,?,?,?,?,?,?,?)");
            statement.setInt(1, destocker.getNumBs());
            statement.setInt(2, destocker.getQttS());
            statement.setInt(3, destocker.getQttD());
            statement.setBoolean(4, destocker.getTransfert());
            statement.setFloat(5, destocker.getMontda());
            statement.setBoolean(6, destocker.getConsommation());
            statement.setDate(7, destocker.getDate());
            statement.setInt(8, destocker.getIdProduit());
            statement.setInt(9, destocker.getIdStock());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

