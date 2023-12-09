package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class produitController extends Application {
	 @FXML
	    private Label Categorielabel;

	    @FXML
	    private Label Nomlabel;

	    @FXML
	    private Label Quantitelabel;

	    @FXML
	    private Button btn_ajouter;

	    @FXML
	    private Button btn_home;

	    @FXML
	    private Button btn_imprimer;

	    @FXML
	    private Button btn_lister;

	    @FXML
	    private Button btn_logout;

	    @FXML
	    private Button btn_modifier;

	    @FXML
	    private Button btn_produit;

	    @FXML
	    private Button btn_stock;

	    @FXML
	    private Button btn_supprimer;

	    @FXML
	    private Label prixlabel;

	    @FXML
	    private AnchorPane scenePane;

	    @FXML
	    private TextField text_search;


	private Stage stage;

	

	
    
   
	public void loadScene (ActionEvent event , String fxmlFileName) {
		
	    loginController loginController = new loginController();
        loginController.loadScene(event, fxmlFileName);
   }
	

    
    
    
    
    
    
    
//go to addproduit(done)
    @FXML
    void ajouter(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"addproduit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
//go to home(done)
    @FXML
    void home(ActionEvent event)  throws IOException{
    	try{
			loadScene( event ,"home.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
//importer une image de produit cliquons sur import
    @FXML
    void importer(ActionEvent event) {

    }
    //imprimer les informations du produit cliqunons sur save

    @FXML
    void imprimer(ActionEvent event) {

    }
    //afficher la liste des produits dans le tableau(done)

    @FXML
    void lister(ActionEvent event)  throws IOException{
    	try{
			loadScene( event ,"ajouterproduit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}
    	
    	

    }
    //quitter la page (modifier pour  quitter au login)remove comments and stage.close

    @FXML
    void logout(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout");
		alert.setContentText("do you want  to save before exiting?:");
		if (alert.showAndWait().get() == ButtonType.OK) {
		// for a normal logout without alert
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("You successfully Logged out");
			stage.close();
			//loadScene( event ,"LogIn.fxml");
		}
    }
//modifier produit click sur update go to addproduit(done)
    @FXML
    void modifier(ActionEvent event)  throws IOException{
    	try{
			loadScene( event ,"addproduit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}
    	
    	

    }
    //selectionner produit (done)

    @FXML
    void produit(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"produit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}
    	
    	

    }
    //rechercher sur un produit par id ou nom

    @FXML
    void search(ActionEvent event) {

    }
//selectionner stock(done)
    @FXML
    void stock(ActionEvent event) throws IOException{
    	
    	try{
			loadScene( event ,"stock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }
    //supprimer produit click sur delete

    @FXML
    void supprimer(ActionEvent event) {

    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
