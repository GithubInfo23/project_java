package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornisseurBD {
    Connection con;
    Connexion connexion = new Connexion();
    PreparedStatement pst;
    public boolean AjouterFornisseur(Fournisseur fournisseur){
        String sql = "INSERT INTO user(id,nom,date) VALUES (?,?,?)";

        try{
            con = connexion.getConnexion();
            pst = con.prepareStatement(sql);
            pst.setInt(1,fournisseur.getId_four());
            pst.setString(2,fournisseur.getNom_four());
            pst.setDate(3,fournisseur.getDate());
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
}
