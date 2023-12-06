package project_java.project_java.DAO;
import project_java.project_java.Models.*;


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

    public void ajouter_utilisateur(Utilisateur utilisateur){
        try {
            con = cn.getConnexion();
            statement=con.prepareStatement("insert into utilisateur(nom,prenom,login,password,date) values(?,?,?,?,?)");
            statement.setString(3, utilisateur.getLogin());
            statement.setString(4, utilisateur.getPassword());
            statement.setDate(5,utilisateur.getDate());
            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void supprimer_utilisateur(Utilisateur utilisateur){
        try{
            con=cn.getConnexion();
            statement=con.prepareStatement("Delete from utilisateur where id_utilisateur=?");
            statement.setInt(1,utilisateur.getId_utilisateur());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void SetIdUtilisateur(Utilisateur utilisateur){
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
                Utilisateur utilisateur = new Utilisateur(nom,prenom,login,password);
                utilisateur.setId_utilisateur(id);
                list.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean authentification(String login, String password, String role){
        try {
            con=cn.getConnexion();
            if (role == "admin") {
                statement = con.prepareStatement("select count(*) as nbr from admin inner join utilisateur on admin.id_utilisateur=utilisateur.id_utilisateur Where login = ? and password = ?");
                statement.setString(1, login);
                statement.setString(2, password);
                resultset = statement.executeQuery();
                if (resultset.next()) {
                    int nombre = resultset.getInt("nbr");
                    return nombre != 0;
                }
            }
            if (role == "magasinier") {
                statement = con.prepareStatement("select count(*) as nbr from magasinier inner join utilisateur on magasinier.id_utilisateur=utilisateur.id_utilisateur Where login = ? and password = ?");
                statement.setString(1, login);
                statement.setString(2, password);
                resultset = statement.executeQuery();
                if (resultset.next()) {
                    int nombre = resultset.getInt("nbr");
                    return nombre != 0;
                }
            }
            if (role == "chefstock") {
                statement = con.prepareStatement("select count(*) as nbr from chef_stock inner join utilisateur on chef_stock.id_utilisateur=utilisateur.id_utilisateur Where login = ? and password = ?");
                statement.setString(1, login);
                statement.setString(2, password);
                resultset = statement.executeQuery();
                if (resultset.next()) {
                    int nombre = resultset.getInt("nbr");
                    return nombre != 0;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
