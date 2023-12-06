package com.example.models;

import java.util.Date;

public class fiche_mvt_stock {
    int id_fiche;
    int n_bone;
    int n_bones;
    String fourn;
    int qtt_e;
    int qtt_s;
    String obser;
    Date date;

    void creer_fichemvstock() {
    }

    void consulter_fiche() {
    }

    void imprimer_fiche() {
    }

    public fiche_mvt_stock(int id_fiche, int n_bone, int n_bones, String fourn, int qtt_e, int qtt_s, String obser,
            Date date) {
        this.id_fiche = id_fiche;
        this.n_bone = n_bone;
        this.n_bones = n_bones;
        this.fourn = fourn;
        this.qtt_e = qtt_e;
        this.qtt_s = qtt_s;
        this.obser = obser;
        this.date = date;
    }

    public int getId_fiche() {
        return this.id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    public int getN_bone() {
        return this.n_bone;
    }

    public void setN_bone(int n_bone) {
        this.n_bone = n_bone;
    }

    public int getN_bones() {
        return this.n_bones;
    }

    public void setN_bones(int n_bones) {
        this.n_bones = n_bones;
    }

    public String getFourn() {
        return this.fourn;
    }

    public void setFourn(String fourn) {
        this.fourn = fourn;
    }

    public int getQtt_e() {
        return this.qtt_e;
    }

    public void setQtt_e(int qtt_e) {
        this.qtt_e = qtt_e;
    }

    public int getQtt_s() {
        return this.qtt_s;
    }

    public void setQtt_s(int qtt_s) {
        this.qtt_s = qtt_s;
    }

    public String getObser() {
        return this.obser;
    }

    public void setObser(String obser) {
        this.obser = obser;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}