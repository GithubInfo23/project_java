package project_java.project_java.Models;
public class Gerer {

    private int idStock;
    private int idUtilisateur;


    // Constructeur avec paramètres
    public Gerer(int idStock, int idUtilisateur) {
        this.idStock = idStock;
        this.idUtilisateur = idUtilisateur;
    }

    // Getters et setters

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}
