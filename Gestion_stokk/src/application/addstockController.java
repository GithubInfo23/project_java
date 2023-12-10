package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addstockController extends Application{
	
	
	@FXML
    private Button btn_home;

    @FXML
    private Button btn_lister;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_produit;

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_stock;

    @FXML
    private TextField date;

    @FXML
    private TextField design;

    @FXML
    private TextField mondadd;

    @FXML
    private TextField pudadd;

    @FXML
    private TextField qutt_stock;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField text_search;

    @FXML
    private TextField txt_obs;

    @FXML
    private TextField u_m;

	private Stage stage;
    
public void loadScene (ActionEvent event , String fxmlFileName) {
		
	    loginController loginController = new loginController();
        loginController.loadScene(event, fxmlFileName);
   }
    
    
    
    //selectionner home(done)

    @FXML
    void home(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"home.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    
    //afficher list des stocks(done)

    @FXML
    void lister(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"listerstock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    
    //pour quitter et aller vers login(just supprimer stage.close et supprimer comentaire loadScene

    @FXML
    void logout(ActionEvent event) {
    	{
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

    }
    
    //selectionner produit(done)

    @FXML
    void produit(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"produit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    
    //pour back(done)

    @FXML
    void retour(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"stock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    
    //pour save les informations saisie

    @FXML
    void save(ActionEvent event) {

    }
    
    //pour search un stock

    @FXML
    void search(ActionEvent event) {

    }
    
    //done
    

    @FXML
    void stock(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"stock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
