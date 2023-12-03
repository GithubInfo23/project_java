package org.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class UtilisateurBD {
    Connection con;
    Connexion connexion = new Connexion();
    PreparedStatement pst;
    public boolean AjouterUtilisateur(Utilisateur utlisateur){
        String sql = "INSERT INTO user(id,login,password,date) VALUES (?,?,?,?)";

        try{
            con = connexion.getConnexion();
            pst = con.prepareStatement(sql);
            pst.setInt(1,utlisateur.getId_utilisateur());
            pst.setString(2,utlisateur.getLogin());
            pst.setString(3,utlisateur.getPassword());
            pst.setDate(4,utlisateur.getDate());
            pst.execute();
            return true;
        }catch (Exception e){
            System.out.println("Erreur d'enregistrement");
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public void supprimerUtilisateur(Utilisateur utilisateurASupprimer) {
        try {
            String query = "DELETE FROM utilisateurs WHERE login = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, utilisateurASupprimer.getLogin());

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Utilisateur supprimé avec succès : " + utilisateurASupprimer.getLogin());
                } else {
                    System.out.println("Échec de la suppression. Utilisateur non trouvé : " + utilisateurASupprimer.getLogin());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void authentification(String loginAttempt, String passwordAttempt) {
        try {
            String query = "SELECT * FROM utilisateurs WHERE login = ? AND password = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                pst.setString(1, loginAttempt);
                pst.setString(2, passwordAttempt);

                try (ResultSet resultSet = pst.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Authentification réussie pour l'utilisateur : " + loginAttempt);
                    } else {
                        System.out.println("Échec de l'authentification. Nom d'utilisateur ou mot de passe incorrect.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
