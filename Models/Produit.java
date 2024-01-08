package project_java.Models;

import javafx.beans.property.DoubleProperty;
import project_java.Models.Fournisseur;


import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Produit {
    private int id_produit,quantite;
    private String nom_produit,ref,obs;
    private Double prix_unitaire;
    private Date date;
    private int id_famille,id_fiche;
    private Famille_des_produits familleProduits;
    private Stocker bonEntree;
    private Destocker bonSortie;
    private Fiche_mvt_stock ficheMvtStock;
    private Fournir fornProduit;
    private List<Stock> stocks ;
    private List<project_java.Models.Fournisseur> fournisseurs ;




    public Produit(int id_produit, String nom_produit, Double prix_unitaire, int quantite, String ref, String obs, Date date, int id_famille, int id_fiche){
        this.nom_produit=nom_produit;
        this.id_produit=id_produit;
        this.quantite=quantite;
        this.prix_unitaire=prix_unitaire;
        this.ref=ref;
        this.obs=obs;
        this.date=date;
        this.id_famille= this.id_famille;
        this.id_fiche= this.id_fiche;
    }

    public Produit() {

    }

    public Produit(int id, String nom, Double prix_unitaire, int qtt, String ref, String obs, Date date) {
        this.id_produit=id;
        this.nom_produit=nom;
        this.quantite=qtt;
        this.ref=ref;
        this.obs=obs;
        this.date=date;
        this.prix_unitaire=prix_unitaire;
    }

    public Produit(int id, String nom, Double prix, int qte, String ref, String obs, int idf, Date date){
        this.id_produit=id;
        this.nom_produit=nom;
        this.quantite=qte;
        this.ref=ref;
        this.obs=obs;
        this.date=date;
        this.prix_unitaire=prix;
        this.id_famille=idf;
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

    public Double getPrix_unitaire() {
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


    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId_famille(int id_famille) {
        this.id_famille = id_famille;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
