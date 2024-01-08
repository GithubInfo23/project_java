package project_java.DAO;
import project_java.Models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur_DAO {
    Connection con;
    ConnexionBDD cn= new ConnexionBDD();
    PreparedStatement statement;
    ResultSet resultset;

    public void ajouter_utilisateur(project_java.Models.Utilisateur utilisateur){
        try {
            con = ConnexionBDD.getConnexion();
            statement=con.prepareStatement("insert into utilisateur(nom,prenom,login,password,date,role) values(?,?,?,?,?,?)");
            statement.setString(3, utilisateur.getLogin());
            statement.setString(4, utilisateur.getPassword());
            statement.setDate(5,utilisateur.getDate());
            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setString(6,utilisateur.getRole());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void supprimer_utilisateur(project_java.Models.Utilisateur utilisateur) {
        try {
            con = cn.getConnexion();

            // Delete associated rows in magasinier
            PreparedStatement deleteMagasinier = con.prepareStatement("DELETE FROM magasinier WHERE id_utilisateur=?");
            deleteMagasinier.setInt(1, utilisateur.getId_utilisateur());
            deleteMagasinier.execute();

            // Delete associated rows in chef_stock
            PreparedStatement deleteChefStock = con.prepareStatement("DELETE FROM chef_stock WHERE id_utilisateur=?");
            deleteChefStock.setInt(1, utilisateur.getId_utilisateur());
            deleteChefStock.execute();

            // Delete associated rows in admin
            PreparedStatement deleteAdmin = con.prepareStatement("DELETE FROM admin WHERE id_utilisateur=?");
            deleteAdmin.setInt(1, utilisateur.getId_utilisateur());
            deleteAdmin.execute();

            // Delete the user from utilisateur
            PreparedStatement deleteUser = con.prepareStatement("DELETE FROM utilisateur WHERE id_utilisateur=?");
            deleteUser.setInt(1, utilisateur.getId_utilisateur());
            deleteUser.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SetIdUtilisateur(project_java.Models.Utilisateur utilisateur){
        try{
            con=cn.getConnexion();
            statement=con.prepareStatement("Select * from utilisateur where nom=? and prenom=? and login=? and password=?");
            statement.setString(1,utilisateur.getNom());
            statement.setString(2,utilisateur.getPrenom());
            statement.setString(3,utilisateur.getLogin());
            statement.setString(4,utilisateur.getPassword());
            resultset = statement.executeQuery();
            while (resultset.next()) {
                int id = resultset.getInt("id_utilisateur");
                utilisateur.setId_utilisateur(id);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List Lister() {
        List<Utilisateur> list = new ArrayList<Utilisateur>();
        try {
            con = cn.getConnexion();
            statement = con.prepareStatement("Select * from utilisateur");
            resultset = statement.executeQuery();
            while (resultset.next()) {
                int id = resultset.getInt("id_utilisateur");
                String login = resultset.getString("login");
                String password = resultset.getString("password");
                String nom= resultset.getString("nom");
                String prenom=resultset.getString("prenom");
                String role=resultset.getString("role");
                Date date=resultset.getDate("date");
                Utilisateur utilisateur = new Utilisateur(nom,prenom,login,password,role,date);
                utilisateur.setId_utilisateur(id);
                list.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean authentification(String login, String password, String role) {
        try {
            con = cn.getConnexion();
            String query = "";
            String table = "";

            switch (role) {
                case "Administrator":
                    query = "SELECT COUNT(*) AS nbr FROM admin INNER JOIN utilisateur ON admin.id_utilisateur = utilisateur.id_utilisateur WHERE login = ? AND password = ?";
                    table = "admin";
                    break;
                case "Storekeeper":
                    query = "SELECT COUNT(*) AS nbr FROM magasinier INNER JOIN utilisateur ON magasinier.id_utilisateur = utilisateur.id_utilisateur WHERE login = ? AND password = ?";
                    table = "magasinier";
                    break;
                case "Stock Manager":
                    query = "SELECT COUNT(*) AS nbr FROM chef_stock INNER JOIN utilisateur ON chef_stock.id_utilisateur = utilisateur.id_utilisateur WHERE login = ? AND password = ?";
                    table = "chef_stock";
                    break;
            }

            statement = con.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            resultset = statement.executeQuery();

            if (resultset.next()) {
                int nombre = resultset.getInt("nbr");

                if (nombre != 0) {
                    // Retrieve the user's ID and other information if needed
                    // Example: utilisateur.setId_utilisateur(resultset.getInt("id_utilisateur"));
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
