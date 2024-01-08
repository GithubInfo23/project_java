package project_java.DAO;
import project_java.Models.Admin;
import project_java.Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Admin_DAO {
    Connection con;
    ConnexionBDD cn = new ConnexionBDD();
    PreparedStatement statement;

    public void ajouter_Admin(Admin admin) {
        try {
            con = cn.getConnexion();
            statement = con.prepareStatement("INSERT INTO admin(id_admin, id_utilisateur) VALUES (?,?)");
            statement.setInt(1, admin.getId_admin());
            statement.setInt(2, admin.getId_utilisateur());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supprimer_admin(Admin admin) {
        try {
            con = cn.getConnexion();
            statement = con.prepareStatement("DELETE FROM admin WHERE id_admin=?");
            statement.setInt(1, admin.getId_admin());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
