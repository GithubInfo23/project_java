package project_java.Models;
import java.sql.Date;

    public class Stocker {

        private Integer numBe;
        private Integer qttE;
        private Boolean transfert;
        private Float monda;
        private Float montotda;
        private Date date;
        private Integer idProduit;
        private Integer idStock;


        public Stocker( int numBe, int qttE, Boolean transfert, Float monda, Float montotda, Date date, Integer idProduit, Integer idStock) {
            this.numBe = numBe;
            this.qttE = qttE;
            this.transfert = transfert;
            this.monda = monda;
            this.montotda = montotda;
            this.date = date;
            this.idProduit = idProduit;
            this.idStock = idStock;
        }

        // Getters et setters pour chaque attribut

        public Integer getNumBe() {
            return numBe;
        }

        public void setNumBe(Integer numBe) {
            this.numBe = numBe;
        }

        public Integer getQttE() {
            return qttE;
        }

        public void setQttE(Integer qttE) {
            this.qttE = qttE;
        }

        public Boolean getTransfert() {
            return transfert;
        }

        public void setTransfert(Boolean transfert) {
            this.transfert = transfert;
        }

        public Float getMonda() {
            return monda;
        }

        public void setMonda(Float monda) {
            this.monda = monda;
        }

        public Float getMontotda() {
            return montotda;
        }

        public void setMontotda(Float montotda) {
            this.montotda = montotda;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Integer getIdProduit() {
            return idProduit;
        }

        public void setIdProduit(Integer idProduit) {
            this.idProduit = idProduit;
        }

        public Integer getIdStock() {
            return idStock;
        }

        public void setIdStock(Integer idStock) {
            this.idStock = idStock;
        }


    }

