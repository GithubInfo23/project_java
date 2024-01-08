package project_java.DAO;
import project_java.Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Famille_DAO {
    private Connection connection;

    public Famille_DAO() {
        this.connection = ConnexionBDD.getConnexion();
    }

    public String getCategorieNameById(int categoryId) {
        String categoryName = null;
        try {
            String query = "SELECT nomFamille FROM famille_des_produits WHERE idFamille=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                categoryName = resultSet.getString("nomFamille");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryName;
    }
    public int getCategorieIdByName(String categoryName) {
        int categoryId = -1; // Une valeur par défaut pour indiquer l'absence d'une correspondance

        try {
            // Établissez la connexion à la base de données (assurez-vous d'avoir une instance de connexion)
            Connection con = ConnexionBDD.getConnexion();

                    // Préparez la requête SQL pour récupérer l'ID de la catégorie par son nom
                    String query = "SELECT idFamille FROM famille_des_produits WHERE nomFamille = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                // Paramètrez la valeur du nom de la catégorie dans la requête
                preparedStatement.setString(1, categoryName);

                // Exécutez la requête
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Vérifiez si une ligne a été renvoyée
                    if (resultSet.next()) {
                        // Récupérez l'ID de la catégorie à partir du résultat
                        categoryId = resultSet.getInt("idFamille");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérez les exceptions SQL de manière appropriée dans votre application
        }

        return categoryId;
    }

    // Méthode pour ajouter une famille dans la base de données
    public void addFamille(Famille_des_produits famille) {
        try {
            String query = "INSERT INTO famille_des_produits (nom_famille, date) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, famille.getNomFamille());
            preparedStatement.setDate(2, famille.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer toutes les familles de la base de données
    public List<Famille_des_produits> getAllFamilles() {
        List<Famille_des_produits> familles = new ArrayList<>();
        try {
            String query = "SELECT * FROM famille_des_produits";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idFamille = resultSet.getInt("id_famille");
                String nomFamille = resultSet.getString("nom_famille");
                Date date = resultSet.getDate("date");

                Famille_des_produits famille = new Famille_des_produits(idFamille, nomFamille, date);
                familles.add(famille);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return familles;
    }

    // Méthode pour récupérer une famille par son ID
    public Famille_des_produits getFamilleById(int idFamille) {
        Famille_des_produits famille = null;
        try {
            String query = "SELECT * FROM famille_des_produits WHERE id_famille=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idFamille);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nomFamille = resultSet.getString("nom_famille");
                Date date = resultSet.getDate("date");

                famille = new Famille_des_produits(idFamille, nomFamille, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return famille;
    }

    // Méthode pour mettre à jour une famille dans la base de données
    public void updateFamille(Famille_des_produits famille) {
        try {
            String query = "UPDATE famille_des_produits SET nom_famille=?, date=? WHERE id_famille=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, famille.getNomFamille());
            preparedStatement.setDate(2, famille.getDate());
            preparedStatement.setInt(3, famille.getIdFamille());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une famille de la base de données
    public void deleteFamille(int idFamille) {
        try {
            String query = "DELETE FROM famille_des_produits WHERE id_famille=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idFamille);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

