package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class searchController {
	
	private Stage stage;
	
	private Scene scene; 
	
	private Parent root;
	
    @FXML
    private Button btn_AddUser;

    @FXML
    private TextField btn_Enter_Employee_ID;

    @FXML
    private Button btn_Stock;

    @FXML
    private Button btn_Users;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_search;

    @FXML
    private Button btn_toprint;

    @FXML
    private Button btn_workbensh;

    @FXML
    private ImageView image_user;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private AnchorPane side_anchorpane;

	public void loadScene (ActionEvent event , String fxmlFileName) {
			
		    loginController loginController = new loginController();
	        loginController.loadScene(event, fxmlFileName);
	   }
	
	
	//go to home(done)
	    
	    @FXML
	    void Workbensh(ActionEvent event) {
	    	
	    	try{
				loadScene( event ,"admin.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
	
	    }
	    //go to manageuser(done)
	
	    @FXML
	    void manageUsers(ActionEvent event) {
	    	
	    	try{
				loadScene( event ,"manage.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
	
	    }
	    //go to stock(done)
	
	    @FXML
	    void Consultstock(ActionEvent event) {
	    	
	    	try{
				loadScene( event ,"stock.fxml");
		}
				
	catch(Exception e){
			System.out.println(e);	
			}
	
	    }
	    @FXML
	    void search(ActionEvent event) {
	    	
	    	try{
				loadScene( event ,"search.fxml");
		}
				
	catch(Exception e){
			System.out.println(e);	
			}
	
	    }
	    
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
  			FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUP.fxml"));
  			root = loader.load();
  			
  			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
  			scene = new Scene(root);
  			stage.setScene(scene);
  			stage.show();
  			
		}
	}
    
  //extraire les donnees du database et l'afficher sur les texts fields suivantes
	public String GetFirst_Name() {
		return null;
	}
	
	public String GetLast_Name() {
		return null;
	}
	
	public String GetLogin() {
		return null;
	}
	
	public String GetPassword() {
		return null;
	}
	
	public String GetRole() {
		return null;
	}
	
	public String GetSalary() {
		return null;
	}
	
	public ImageView GetImage() {
		return null;
	}
	

}