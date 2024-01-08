package project_java.Models;
import java.awt.*;
import java.sql.*;

public class Utilisateur {
    private int id_utilisateur;
    private String login,password;
    private Date date;
    private String nom;
    private String role;
    private String prenom;
    private java.util.List<Stock> stocks;

    public Utilisateur(String nom,String prenom,String login,String password,String role,Date date){
        this.login=login;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.role=role;
        this.date=date;
    }

    public Utilisateur() {

    }

    public String getLogin() {
        return login;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate() {
        return date;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
