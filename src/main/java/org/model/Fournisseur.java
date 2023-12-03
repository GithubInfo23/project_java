package org.model;
import java.util.Date;
public class Fournisseur {
    private int id_four;
    private String nom_four;
    private Date date;

    public Fournisseur(int id_four, String nom_four, Date date) {
        this.id_four = id_four;
        this.nom_four = nom_four;
        this.date = date;
    }

    public int getId_four() {
        return id_four;
    }

    public void setId_four(int id_four) {
        this.id_four = id_four;
    }

    public String getNom_four() {
        return nom_four;
    }

    public void setNom_four(String nom_four) {
        this.nom_four = nom_four;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id_four=" + id_four +
                ", nom_four='" + nom_four + '\'' +
                ", date=" + date +
                '}';
    }
}
