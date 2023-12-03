package org.model;

import java.util.ArrayList;
import java.util.Date;

public class FornProduit {
    private Date date ;
    private ArrayList<Fournisseur> fournisseurs;

    public FornProduit(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FornProduit{" +
                "date=" + date +
                '}';
    }
}
