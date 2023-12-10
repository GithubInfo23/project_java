package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addproduitController extends Application{
	 @FXML
	    private Button btn_home;

	    @FXML
	    private Button btn_import;

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
	    private Button btn_retour;

	    @FXML
	    private Button btn_stock;

	    @FXML
	    private Button btn_supprimer;

	    @FXML
	    private TextField categorie;

	    @FXML
	    private TextField date;

	    @FXML
	    private ImageView image;

	    @FXML
	    private TextField nom;

	    @FXML
	    private TextField obs;

	    @FXML
	    private TextField prix;

	    @FXML
	    private TextField quantite;

	    @FXML
	    private TextField ref;

	    @FXML
	    private AnchorPane scenePane;

	    @FXML
	    private TextField text_search;

		private Stage stage;
	    
	    
	    
	    public void loadScene (ActionEvent event , String fxmlFileName) {
			
		    loginController loginController = new loginController();
	        loginController.loadScene(event, fxmlFileName);
	   }
	    
	    
	    
	    //go to home(done)

	    @FXML
	    void home(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"home.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}


	    }
	    
	    //for import image click sur import

	    @FXML
	    void importer(ActionEvent event) {

	    }
	    
	    //imprimer les infos du stock by click sur print

	    @FXML
	    void imprimer(ActionEvent event) {

	    }
	    
	    //go to ajouteproduit(interface pour lister produits) (done)

	    @FXML
	    void lister(ActionEvent event) throws IOException{
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
	    //click sur update pour modifier

	    @FXML
	    void modifier(ActionEvent event) {

	    }
	    
	    //go to produit (done)

	    @FXML
	    void produit(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"produit.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}


	    }
	    //go to produit(done)
	    
	    @FXML
	    void retour(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"produit.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}


	    }
	    
	    //pour chercher un produit

	    @FXML
	    void search(ActionEvent event) {

	    }
	    
	    //go to stock(done)

	    @FXML
	    void stock(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"stock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}


	    }
	    
	    //click sur delete pour supprimer

	    @FXML
	    void supprimer(ActionEvent event) {

	    }

		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub
			
		}

}
