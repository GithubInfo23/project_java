package project_java.Models;
import java.awt.*;
import java.sql.*;

    
/**
 * magasinier
 */
public class Magasinier extends Utilisateur {
    private int id_magasinier;
    private String choix_service;
    private Date date;
    private int id_utilisateur;
    private java.util.List<Fiche_mvt_stock> fiches;

    public Magasinier(String choix_service,int id_utilisateur,Date date) {
        this.choix_service = choix_service;
        this.date = date;
        this.id_utilisateur=id_utilisateur;
    }

    public Magasinier() {

    }

    public int getId_utilisateur() {return id_utilisateur;}

    public int getId_magasinier() {return id_magasinier;}

    public String getChoix_service() {
        return this.choix_service;
    }

    public Date getDate() {
        return this.date;
    }
    public void setChoix_service(String choix_service) {
        this.choix_service = choix_service;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}