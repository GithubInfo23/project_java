package project_java.project_java.Models;
import java.sql.Date;

public class Destocker {

    private int numBs;
    private int qttS;
    private int qttD;
    private boolean transfert;
    private float montda;
    private boolean consommation;
    private Date date;
    private int idProduit;
    private int idStock;

    public Destocker() {
        // Constructeur par défaut
    }

    public Destocker(int numBs, int qttS, int qttD, boolean transfert, float montda, boolean consommation, Date date, int idProduit, int idStock) {
        this.numBs = numBs;
        this.qttS = qttS;
        this.qttD = qttD;
        this.transfert = transfert;
        this.montda = montda;
        this.consommation = consommation;
        this.date = date;
        this.idProduit = idProduit;
        this.idStock = idStock;
    }

    // Getters et setters pour chaque attribut

    public int getNumBs() {
        return numBs;
    }

    public void setNumBs(int numBs) {
        this.numBs = numBs;
    }

    public int getQttS() {
        return qttS;
    }

    public void setQttS(int qttS) {
        this.qttS = qttS;
    }

    public int getQttD() {
        return qttD;
    }

    public void setQttD(int qttD) {
        this.qttD = qttD;
    }

    public boolean getTransfert() {
        return transfert;
    }

    public void setTransfert(boolean transfert) {
        this.transfert = transfert;
    }

    public float getMontda() {
        return montda;
    }

    public void setMontda(float montda) {
        this.montda = montda;
    }

    public boolean getConsommation() {
        return consommation;
    }

    public void setConsommation(boolean consommation) {
        this.consommation = consommation;
    }

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

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

}


