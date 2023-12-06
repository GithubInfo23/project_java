package project_java.project_java.Models;
import java.util.Date;

public class Stock {

    private int idStock;
    private Integer quttStock;
    private Float pudadd;
    private Float mondadd;
    private String design;
    private String obs;
    private String uM;
    private Date date;

    public Stock(int idStock, Integer quttStock, Float pudadd, Float mondadd, String design, String obs, String uM, Date date) {
        this.idStock = idStock;
        this.quttStock = quttStock;
        this.pudadd = pudadd;
        this.mondadd = mondadd;
        this.design = design;
        this.obs = obs;
        this.uM = uM;
        this.date = date;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Integer getQuttStock() {
        return quttStock;
    }

    public void setQuttStock(Integer quttStock) {
        this.quttStock = quttStock;
    }

    public Float getPudadd() {
        return pudadd;
    }

    public void setPudadd(Float pudadd) {
        this.pudadd = pudadd;
    }

    public Float getMondadd() {
        return mondadd;
    }

    public void setMondadd(Float mondadd) {
        this.mondadd = mondadd;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getuM() {
        return uM;
    }

    public void setuM(String uM) {
        this.uM = uM;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}



