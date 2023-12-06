package project_java.project_java.Models;

import java.sql.Date;

/**
 * chef_stock
 */
public class Chef_stock {
    private int id_chefstock;
    private String choix_service;
    private Date date;
    private int id_utilisateur;


    public Chef_stock(int id_chefstock, String choix_service, int id_utilisateur,Date date) {
        this.id_chefstock=id_chefstock;
        this.choix_service = choix_service;
        this.date = date;
        this.id_utilisateur=id_utilisateur;
    }

    public int getId_chefstock() {
        return id_chefstock;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getChoix_service() {
        return this.choix_service;
    }

    public void setChoix_service(String choix_service) {
        this.choix_service = choix_service;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}