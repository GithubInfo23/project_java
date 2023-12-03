package org.model;

import java.util.Date;

public class BonSortie {
    private int num_bs;
    private int qtt_s;
    private boolean consomation;
    private float montda;
    private Date date;

    public BonSortie(int num_bs, int qtt_s, boolean consomation, float montda, Date date) {
        this.num_bs = num_bs;
        this.qtt_s = qtt_s;
        this.consomation = consomation;
        this.montda = montda;
        this.date = date;
    }

    public int getNum_bs() {
        return num_bs;
    }

    public void setNum_bs(int num_bs) {
        this.num_bs = num_bs;
    }

    public int getQtt_s() {
        return qtt_s;
    }

    public void setQtt_s(int qtt_s) {
        this.qtt_s = qtt_s;
    }

    public boolean isConsomation() {
        return consomation;
    }

    public void setConsomation(boolean consomation) {
        this.consomation = consomation;
    }

    public float getMontda() {
        return montda;
    }

    public void setMontda(float montda) {
        this.montda = montda;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BonSortie{" +
                "num_bs=" + num_bs +
                ", qtt_s=" + qtt_s +
                ", consomation=" + consomation +
                ", montda=" + montda +
                ", date=" + date +
                '}';
    }
}
