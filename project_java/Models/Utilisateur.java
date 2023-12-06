package project_java.project_java.Models;
import java.sql.*;

public class Utilisateur {
    private int id_utilisateur;
    private String login,password;
    private Date date;
    private String nom;
    private String prenom;

    public Utilisateur(String nom,String prenom,String login,String password){
        this.login=login;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
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
}
