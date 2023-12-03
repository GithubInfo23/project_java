package org.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utilisateur {
    private static List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    private int id_utilisateur;
    private String login;
    private String password;
    private Date date;

    public Utilisateur(int id_utilisateur, String login, String password, Date date) {
        this.id_utilisateur = id_utilisateur;
        this.login = login;
        this.password = password;
        this.date = date;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "Utilisateurs{" +
                "id_utilisateur=" + id_utilisateur +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
