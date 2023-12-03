package project_java;

import java.util.Date;

    
/**
 * magasinier
 */
public class magasinier {

    String choix_service;
    Date date;

    public magasinier(String choix_service, Date date) {
        this.choix_service = choix_service;
        this.date = date;
    }

    public String getChoix_service() {
        return this.choix_service;
    }

    public Date getDate() {
        return this.date;
    }
    public void setChoix_service(String choix_service) {
        this.choix_service = choix_service;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}