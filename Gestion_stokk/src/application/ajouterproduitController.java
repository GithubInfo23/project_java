package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


//liste produit !!!!!!!!!!
public class ajouterproduitController extends Application{
	@FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_produit;
    

    @FXML
    private Button btn_stock;
    @FXML
    private TableView<?> table_view;

    @FXML
    private Button btn_supprimer;

    @FXML
    private TextField text_search;
    
    @FXML 
    private Button btn_retour;
    @FXML
    private Button btn_imprimer;

	private Stage stage;
	@FXML
	private AnchorPane scenePane;

	
    
    
    
    
public void loadScene (ActionEvent event , String fxmlFileName) {
		
	    loginController loginController = new loginController();
        loginController.loadScene(event, fxmlFileName);
   }




    @FXML
    //go to add produit(done)
    void ajouter(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"addproduit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }

  

    @FXML
    //selectionner home(done)
    void home(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"home.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }
    //cliquer sur lougout

  //quitter la page (modifier pour  quitter au login)remove comments and stage.close

    @FXML
    public void logout(ActionEvent event) {
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
    //selectionner un produit click sur Update and go to addproduit to modify(done)

    @FXML
    void modifier(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"addproduit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }
    //selectionner produit(done)

    @FXML
    void produit(ActionEvent event) throws IOException {
    	
    	try{
			loadScene( event ,"produit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }
    //chercher sur un produit 

    @FXML
    void search(ActionEvent event) {

    }
   // selectionner stock(done)

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
    
    //retour to produit(done)
    @FXML 
    void retour(ActionEvent event) {
    	try{
			loadScene( event ,"produit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}
    }
    
    //imprimer produit click sur print
    
    @FXML
    void imprimer(ActionEvent event) {

    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
