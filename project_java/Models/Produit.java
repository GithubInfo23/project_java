package project_java.project_java.Models;

import java.sql.Date;


public class Produit {
    private int id_produit,quantite;
    private String nom_produit,ref,obs;
    private float prix_unitaire;
    private Date date;
    private int id_famille,id_fiche;

    public Produit(int id_produit,String nom_produit,float prix_unitaire,int quantite,String ref,String obs,Date date){
        this.nom_produit=nom_produit;
        this.id_produit=id_produit;
        this.quantite=quantite;
        this.prix_unitaire=prix_unitaire;
        this.ref=ref;
        this.obs=obs;
        this.date=date;
        this.id_famille=id_famille;
        this.id_fiche=id_fiche;
    }

    public int getId_produit() {
        return id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public int getQuantite() {
        return quantite;
    }
    public int getId_famille(){
        return id_famille;
    }

    public Date getDate() {
        return date;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public String getObs() {
        return obs;
    }

    public String getRef() {
        return ref;
    }

    public int getId_fiche() {
        return id_fiche;
    }

}
