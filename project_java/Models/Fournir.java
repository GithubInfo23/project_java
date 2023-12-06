package project_java.project_java.Models;
import java.sql.Date;

public class Fournir {

    private Date date;
    private int idProduit;
    private int idFourn;


    // Constructeur avec paramètres
    public Fournir(Date date, int idProduit, int idFourn) {
        this.date = date;
        this.idProduit = idProduit;
        this.idFourn = idFourn;
    }

    // Getters et setters

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdFourn() {
        return idFourn;
    }

    public void setIdFourn(int idFourn) {
        this.idFourn = idFourn;
    }

}

