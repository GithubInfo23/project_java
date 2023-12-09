package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class stockController extends Application{
	@FXML
    private TextField ID;

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
    private TextField text_search;

    @FXML
    private TextField txt_obs;

    @FXML
    private TextField u_m;
    @FXML
    private AnchorPane scenePane;

	private Stage stage;
	
	    
	    public void loadScene (ActionEvent event , String fxmlFileName) {
			
		    loginController loginController = new loginController();
	        loginController.loadScene(event, fxmlFileName);
	   }
	    
	    //ajouter un stock vers add stock(done)

	    @FXML
	    void ajouter(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"addstock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}


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
	    //pour print liste des stocks

	    @FXML
	    void imprimer(ActionEvent event) {

	    }
	    //afficher la liste des stocks(done)

	    @FXML
	    void lister(ActionEvent event) throws IOException{
	    	
	    	try{
				loadScene( event ,"listerstock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    //logout to login delete comments and stage.close

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
	    			//loadScene( event ,"LogIn.fxml");
	    		}
	    	}
	    //pour Update les infos du stock go to addstock(done)

	    @FXML
	    void modifier(ActionEvent event) throws IOException{
	    	
	    	try{
				loadScene( event ,"addstock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
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
	    //rechercher a un stock

	    @FXML
	    void search(ActionEvent event) {

	    }
	    //selectionner stock(done)

	    @FXML
	    void stock(ActionEvent event) {
	    	try{
				loadScene( event ,"stock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    //pour delete un stock

	    @FXML
	    void supprimer(ActionEvent event) {

	    }
	

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
