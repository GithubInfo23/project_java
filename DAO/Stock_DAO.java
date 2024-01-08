package project_java.DAO;
import project_java.Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Stock_DAO {
    public Stock searchStockByName(String stockName) throws SQLException {
        Stock stock = null;

        try (Connection connection = ConnexionBDD.getConnexion();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stock WHERE design = ?")) {

            preparedStatement.setString(1, stockName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    stock = extractStockFromResultSet(resultSet);
                }
            }
        }

        return stock;
    }


    private Stock extractStockFromResultSet(ResultSet resultSet) throws SQLException {
        int idStock = resultSet.getInt("idStock");
        int quttStock = resultSet.getInt("quttStock");
        float pudadd = resultSet.getFloat("pudadd");
        float mondadd = resultSet.getFloat("mondadd");
        String design = resultSet.getString("design");
        String obs = resultSet.getString("obs");
        String uM = resultSet.getString("uM");
        Date date = resultSet.getDate("date");

        return new Stock(idStock, quttStock, pudadd, mondadd, design, obs, uM, date);
    }

    // Méthode pour supprimer un produit de la table stock
    public void delete(String produitID) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Obtenez une connexion à la base de données (assurez-vous d'avoir une classe de connexion appropriée)
            connection = ConnexionBDD.getConnexion();

            // Définissez la requête SQL pour supprimer le produit
            String query = "DELETE FROM stock WHERE idStock = ?";

            // Créez une instruction préparée
            statement = connection.prepareStatement(query);

            // Définissez la valeur du paramètre dans la requête
            statement.setString(1, produitID);

            // Exécutez la requête de suppression
            statement.executeUpdate();
        } catch (SQLException e) {
            // Gérez les exceptions SQL (par exemple, journalisez l'erreur)
            e.printStackTrace();
        } finally {
            // Fermez la connexion et l'instruction
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Gérez les exceptions de fermeture (par exemple, journalisez l'erreur)
                e.printStackTrace();
            }
        }
    }
    public void update(Stock stock) {
        try {
            Connection connection = ConnexionBDD.getConnexion();
            // Votre logique de mise à jour de la base de données ici
            String query = "UPDATE stock SET design=?, obs=?, uM=?, pudadd=?, mondadd=?, idStock=?, quttStock=?, date=? WHERE idStock=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, stock.getDesign());
            preparedStatement.setString(2, stock.getObs());
            preparedStatement.setString(3, stock.getuM());
            preparedStatement.setFloat(4, stock.getPudadd());
            preparedStatement.setFloat(5, stock.getMondadd());
            preparedStatement.setInt(6, stock.getIdStock());
            preparedStatement.setInt(7, stock.getQuttStock());

            // Conversion de java.sql.Date en java.util.Date pour PreparedStatement
            java.util.Date utilDate = stock.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(8, sqlDate);

            preparedStatement.setInt(9, stock.getIdStock()); // Pour la clause WHERE

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mise à jour du stock.");
        }
    }


    public void update(String stockID, int newquttStock, float newpudadd, float newmondadd, String newDesign, String newObs, String newUM, java.sql.Date newDate) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnexionBDD.getConnexion();
            connection.setAutoCommit(true); // Activez le commit automatique

            // Créez la requête SQL pour mettre à jour l'enregistrement
            String query = "UPDATE stock SET quttStock=?, pudadd=?, mondadd=?, design=?, obs=?, uM=?, date=? WHERE idStock=?";
            statement = connection.prepareStatement(query);

            // Définissez les valeurs des paramètres de la requête
            statement.setInt(1, newquttStock);
            statement.setFloat(2, newpudadd);
            statement.setFloat(3, newmondadd);
            statement.setString(4, newDesign);
            statement.setString(5, newObs);
            statement.setString(6, newUM);
            statement.setDate(7, newDate);
            statement.setString(8, stockID);

            // Exécutez la requête
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Gérez les exceptions appropriées selon vos besoins

        } finally {
            // Fermez la déclaration et la connexion
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //ajouter
    public void insert(int quttStock, float pudadd, float mondadd, String design, String obs, String uM, Date date) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnexionBDD.getConnexion();
            connection.setAutoCommit(true); // Activez le commit automatique

            // Créez la requête SQL pour insérer un nouvel enregistrement
            String query = "INSERT INTO stock (quttStock, pudadd, mondadd, design, obs, uM, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Définissez les valeurs des paramètres de la requête
            statement.setInt(1, quttStock);
            statement.setFloat(2, pudadd);
            statement.setFloat(3, mondadd);
            statement.setString(4, design);
            statement.setString(5, obs);
            statement.setString(6, uM);
            statement.setDate(7, date);

            // Exécutez la requête
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Gérez les exceptions appropriées selon vos besoins
        } finally {
            // Fermez la déclaration et la connexion
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //lister
    public List<Stock> lister() {
        List<Stock> listeStocks = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnexionBDD.getConnexion();

            // Écrire la requête SELECT appropriée pour récupérer les stocks
            String query = "SELECT idStock, quttStock, pudadd, mondadd, design, obs, uM, date FROM stock";

            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            // Parcourir les résultats et créer des objets Stock
            while (resultSet.next()) {
                int idStock = resultSet.getInt("idStock");
                int quttStock = resultSet.getInt("quttStock");
                float pudadd = resultSet.getFloat("pudadd");
                float mondadd = resultSet.getFloat("mondadd");
                String design = resultSet.getString("design");
                String obs = resultSet.getString("obs");
                String uM = resultSet.getString("uM");
                java.sql.Date date = resultSet.getDate("date");

                // Créer un objet Stock avec les données récupérées
                Stock stock = new Stock(idStock, quttStock, pudadd, mondadd, design, obs, uM, date);

                // Ajouter l'objet Stock à la liste
                listeStocks.add(stock);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Gérer les exceptions selon vos besoins

        } finally {
            // Fermer les ressources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return listeStocks;
    }

    public List<Stock> search(String searchTerm) {
        List<Stock> searchResults = new ArrayList<>();

        // Utilisez la valeur de searchTerm pour filtrer votre requête SQL
        String query = "SELECT * FROM stock WHERE idStock LIKE '%" + searchTerm + "%' OR design LIKE '%" + searchTerm + "%'";

        try (Connection connection = ConnexionBDD.getConnexion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Créez des objets Stock à partir des résultats de la recherche
                Stock stock = new Stock(
                        resultSet.getInt("idStock"),
                        resultSet.getInt("quttStock"),
                        resultSet.getFloat("pudadd"),
                        resultSet.getFloat("mondadd"),
                        resultSet.getString("design"),
                        resultSet.getString("obs"),
                        resultSet.getString("uM"),
                        resultSet.getDate("date")
                );
                searchResults.add(stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public void deleteStock(Stock stock) {
        try (Connection connection = ConnexionBDD.getConnexion();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM stock WHERE idStock = ?")) {

            preparedStatement.setInt(1, stock.getIdStock());
            preparedStatement.executeUpdate();

            // Vous pouvez également effectuer d'autres opérations nécessaires après la suppression, si nécessaire

        } catch (SQLException e) {
            // Gérez les exceptions SQL de manière appropriée (par exemple, affichez un message à l'utilisateur ou enregistrez l'erreur)
            e.printStackTrace(); // À adapter selon vos besoins
        }
    }

}



