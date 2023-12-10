package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class listerstockController extends Application{
	@FXML
    private TableColumn<?, ?> ID;

    @FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_imprimer;

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
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> design;

    @FXML
    private TableColumn<?, ?> mondadd;

    @FXML
    private TableColumn<?, ?> obs;

    @FXML
    private TableColumn<?, ?> pudadd;

    @FXML
    private TableColumn<?, ?> qut_stock;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField text_search;

    @FXML
    private TableColumn<?, ?> u_m;

		private Stage stage;
	    
	    public void loadScene (ActionEvent event , String fxmlFileName) {
			
		    loginController loginController = new loginController();
	        loginController.loadScene(event, fxmlFileName);
	   }
	    
	    //pour add stock(done)

	    @FXML
	    void ajouter(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"addstock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
	    	
	    	

	    }
	    
	    //go home(done)

	    @FXML
	    void home(ActionEvent event) {
	    	try{
				loadScene( event ,"home.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    //pour print list stock

	    @FXML
	    void imprimer(ActionEvent event) {

	    }
	    //pour quitter vers login(just delete comment and stage.close)

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
	    
	    //pour update stock go to addstock(done)

	    @FXML
	    void modifier(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"addstock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
	    	
	    	

	    }
	    
	    //go to product(done)

	    @FXML
	    void produit(ActionEvent event) {
	    	try{
				loadScene( event ,"produit.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    
	    //for search a stock

	    @FXML
	    void search(ActionEvent event) {

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
	    
	    //for delete product

	    @FXML
	    void supprimer(ActionEvent event) {

	    }
	    //retour vers stock(done)
	    
	    @FXML 
	    void retour(ActionEvent event) {
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
