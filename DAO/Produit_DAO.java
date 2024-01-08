package project_java.DAO;

import project_java.Models.Produit;
import project_java.Models.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


    public class Produit_DAO {
        Connection con;
        ConnexionBDD cn = new ConnexionBDD();
        PreparedStatement statement;

        int id_famille;
        int id_fiche;
        ResultSet resultset;

        public void ajouter_produit(Produit produit) {
            try {
                con = cn.getConnexion();

                // Vérifier si la famille de produits existe avant d'ajouter le produit
                if (!isFamilleExists(produit.getId_famille())) {
                    System.out.println("La famille de produits n'existe pas.");
                    return;  // Ou lancez une exception appropriée si nécessaire
                }

                // Vérifier si la fiche_mvt_stock existe avant d'ajouter le produit
                if (!isFicheExists(produit.getId_fiche())) {
                    System.out.println("La fiche_mvt_stock n'existe pas.");
                    return;  // Ou lancez une exception appropriée si nécessaire
                }

                statement = con.prepareStatement("INSERT INTO produit (id_produit, nom_produit, prix_unitaire, quantite, ref, obs, date, id_famille, id_fiche) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");
                statement.setInt(1, produit.getId_produit());
                statement.setString(2, produit.getNom_produit());
                statement.setDouble(3, produit.getPrix_unitaire());
                statement.setInt(4, produit.getQuantite());
                statement.setString(5, produit.getRef());
                statement.setString(6, produit.getObs());
                statement.setDate(7, produit.getDate());
                statement.setInt(8, produit.getId_famille());
                statement.setInt(9, produit.getId_fiche());
                statement.execute();
            } catch (SQLException e) {
                // Gérez l'erreur de manière appropriée
                System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    // Gérez l'erreur de fermeture de la connexion, si nécessaire
                    System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }

        private boolean isFamilleExists(int idFamille) throws SQLException {
            try (Connection con = cn.getConnexion();
                 PreparedStatement statement = con.prepareStatement("SELECT * FROM famille_des_produits WHERE idFamille = ?")) {
                statement.setInt(1, idFamille);
                ResultSet rs = statement.executeQuery();
                return rs.next();
            }
        }

        public boolean isFicheExists(int idFiche) throws SQLException {
            try (Connection con = cn.getConnexion();
                 PreparedStatement statement = con.prepareStatement("SELECT * FROM fiche_mvt_stock WHERE id_fiche = ?")) {
                statement.setInt(1, idFiche);
                ResultSet rs = statement.executeQuery();
                return rs.next();
            }
        }




    public boolean isProductExists(String ref) throws SQLException {
        try {
            con = cn.getConnexion();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM produit WHERE ref = '" + ref + "'");
            return rs.next();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void updateProduit(Produit produit) {
        try {
            con = cn.getConnexion();
            statement = con.prepareStatement("UPDATE produit SET nom_produit=?, prix_unitaire=?, quantite=?, ref=?, obs=?, date=? WHERE id_produit=?");
            statement.setString(1, produit.getNom_produit());
            statement.setDouble(2, produit.getPrix_unitaire());
            statement.setInt(3, produit.getQuantite());
            statement.setString(4, produit.getRef());
            statement.setString(5, produit.getObs());
            statement.setDate(6, produit.getDate());
            statement.setInt(7, produit.getId_produit());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        public List<Produit> Lister() {
            List<Produit> listePdts = new ArrayList<>();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = ConnexionBDD.getConnexion();

                // Écrire la requête SELECT appropriée pour récupérer les stocks
                String query = "SELECT id_produit, nom_produit, prix_unitaire, quantite, ref, obs, date, id_famille FROM produit";

                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();

                // Parcourir les résultats et créer des objets
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_produit");
                    String nom = resultSet.getString("nom_produit");
                    Double prix = resultSet.getDouble("prix_unitaire");
                    int qte = resultSet.getInt("quantite");
                    String ref = resultSet.getString("ref");
                    String obs = resultSet.getString("obs");
                    Date date = resultSet.getDate("date");
                    int idf = resultSet.getInt("id_famille");

                    // Créer un objet  avec les données récupérées
                    Produit prod = new Produit(id, nom, prix, qte, ref, obs,idf, date);

                    // Ajouter l'objet  à la liste
                    listePdts.add(prod);
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

            return listePdts;
        }

        public void supprimer_produit(int idProduit) {
            try {
                con = cn.getConnexion();
                statement = con.prepareStatement("DELETE FROM produit WHERE id_produit=?");
                statement.setInt(1, idProduit);
                statement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }


        public Produit search(String searchTerm) {
            Produit produit = null;
            try {
                con = cn.getConnexion();

                // Recherche par ID
                if (searchTerm.matches("\\d+")) {
                    int id = Integer.parseInt(searchTerm);
                    produit = searchProduitById(id);
                } else {
                    // Recherche par nom
                    produit = searchProduitByName(searchTerm);
                }

            } catch (SQLException e) {
                // Gérez l'erreur de manière appropriée
                System.out.println("Erreur lors de la recherche du produit : " + e.getMessage());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    // Gérez l'erreur de fermeture de la connexion, si nécessaire
                    System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
            return produit;
        }

        public List<Produit> searchProduit(String searchTerm) {
            List<Produit> produits = new ArrayList<>();
            try {
                con = cn.getConnexion();

                // Recherche par ID
                if (searchTerm.matches("\\d+")) {
                    int id = Integer.parseInt(searchTerm);
                    Produit produit = searchProduitById(id);
                    if (produit != null) {
                        produits.add(produit);
                    }
                } else {
                    // Recherche par nom
                    Produit produit = searchProduitByName(searchTerm);
                    if (produit != null) {
                        produits.add(produit);
                    }
                }

            } catch (SQLException e) {
                // Gérez l'erreur de manière appropriée
                System.out.println("Erreur lors de la recherche du produit : " + e.getMessage());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    // Gérez l'erreur de fermeture de la connexion, si nécessaire
                    System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
            return produits;
        }

        public Produit searchProduitById(int id) throws SQLException {
            try (PreparedStatement statement = con.prepareStatement("SELECT * FROM produit WHERE id_produit = ?")) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    Produit produit = extractProduitFromResultSet(rs);

                    // Ajoutez ces lignes pour récupérer également id_fiche et id_famille
                    produit.setId_fiche(rs.getInt("id_fiche"));
                    produit.setId_famille(rs.getInt("id_famille"));

                    return produit;
                }
            }
            return null;
        }


        private Produit searchProduitByName(String name) throws SQLException {
            try (PreparedStatement statement = con.prepareStatement("SELECT * FROM produit WHERE nom_produit = ?")) {
                statement.setString(1, name);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    Produit produit = extractProduitFromResultSet(rs);

                    // Ajoutez ces lignes pour récupérer également id_fiche et id_famille
                    produit.setId_fiche(rs.getInt("id_fiche"));
                    produit.setId_famille(rs.getInt("id_famille"));

                    return produit;
                }
            }
            return null;
        }

        private Produit extractProduitFromResultSet(ResultSet rs) throws SQLException {
            int id = rs.getInt("id_produit");
            String nom = rs.getString("nom_produit");
            Double prix = rs.getDouble("prix_unitaire");
            int qtt = rs.getInt("quantite");
            String ref = rs.getString("ref");
            String obs = rs.getString("obs");
            java.sql.Date date = rs.getDate("date");
            int id_famille = rs.getInt("id_famille");
            int id_fiche = rs.getInt("id_fiche");
            return new Produit(id, nom, prix, qtt, ref, obs, date, id_famille, id_fiche);
        }
        public String getNomCategorieById(int idFamille) {
            String query = "SELECT nom_categorie FROM categorie WHERE id_categorie = ?";

            try (Connection connection = ConnexionBDD.getConnexion();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idFamille);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("nom_categorie");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

    }
