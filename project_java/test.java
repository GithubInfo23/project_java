package project_java.project_java;
import project_java.project_java.DAO.*;
import project_java.project_java.Models.*;
import java.util.List;
import java.sql.*;

public class test {
    public static void main(String[] args) {
        Magasinier_DAO magasinierDao=new Magasinier_DAO();
        Utilisateur_DAO utilisateurDao = new Utilisateur_DAO();
        Utilisateur utilisateur = new Utilisateur("Lea","Patrik","b@hotmail.com","");
        utilisateurDao.SetIdUtilisateur(utilisateur);
        String str="2015-03-31";
        Date date=Date.valueOf(str);
        Magasinier magasinier= new Magasinier("a", utilisateur.getId_utilisateur(),date);
        magasinierDao.ajouter_Magasinier(magasinier);
        boolean t=utilisateurDao.authentification("b@hotmail.com","","magasinier");
        System.out.println(t);
    }

}
