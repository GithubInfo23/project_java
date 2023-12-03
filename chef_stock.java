package project_java;
import java.util.Date;

/**
 * chef_stock
 */
public class chef_stock {

    String choix_service;
    Date date;

    public chef_stock(String choix_service, Date date) {
        this.choix_service = choix_service;
        this.date = date;
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