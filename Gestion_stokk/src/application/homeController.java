package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class homeController {
	@FXML
    private AnchorPane ancho;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_produit;

    @FXML
    private Button btn_stock;
    @FXML
    private Label labelname;

	private Stage stage;

	@FXML
	private AnchorPane scenePane;
    
public void loadScene (ActionEvent event , String fxmlFileName) {
		
	    loginController loginController = new loginController();
        loginController.loadScene(event, fxmlFileName);
   }


//go to home(done)
    
    @FXML
    void home(ActionEvent event) {
    	
    	try{
			loadScene( event ,"home.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }
    //go to produit(done)

    @FXML
    void produit(ActionEvent event) {
    	
    	try{
			loadScene( event ,"produit.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}

    }
    //go to stock(done)

    @FXML
    void stock(ActionEvent event) {
    	
    	try{
			loadScene( event ,"stock.fxml");
	}
			
catch(Exception e){
		System.out.println(e);	
		}

    }
    
    
  //quitter la page (modifier pour  quitter au login)remove comments and stage.close
    
    @FXML
public void logout(ActionEvent event) throws IOException {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout");
		alert.setContentText("do you want  to save before exiting?:");
		if (alert.showAndWait().get() == ButtonType.OK) {
		// for a normal logout without alert
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("You successfully Logged out");
			stage.close();
		}
	}
    
    
    
    
    

}
