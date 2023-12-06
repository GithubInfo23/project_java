package project_java.project_java.Models;
import java.sql.*;

public class Fournisseur {
    private int id_fournisseur;
    private String nom_fournisseur;
    private Date date;

    public Fournisseur(int id,String nom,Date date){
        this.nom_fournisseur=nom;
        this.id_fournisseur=id;
        this.date=date;
    }


    //Accesseurs
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public String getNom_fournisseur() {
        return nom_fournisseur;
    }
    public Date getDate(){
        return date;
    }

}
