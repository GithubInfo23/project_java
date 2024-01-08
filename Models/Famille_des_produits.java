package project_java.Models;
import java.sql.Date;
    public class Famille_des_produits {

        private int idFamille;
        private String nomFamille;
        private Date date;


        // Constructeur avec paramètres
        public Famille_des_produits(int idFamille, String nomFamille, Date date) {
            this.idFamille = idFamille;
            this.nomFamille = nomFamille;
            this.date = date;
        }

        // Getters et setters

        public int getIdFamille() {
            return idFamille;
        }

        public void setIdFamille(int idFamille) {
            this.idFamille = idFamille;
        }

        public String getNomFamille() {
            return nomFamille;
        }

        public void setNomFamille(String nomFamille) {
            this.nomFamille = nomFamille;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }


