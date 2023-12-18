package application;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class stockController {

	private Stage stage;
	
	private Scene scene; 
	
	private Parent root;
	
    @FXML
    private AreaChart<?, ?> DataChart;

    @FXML
    private TextField TextField_SearchStock;

    @FXML
    private Button btn_Stock;

    @FXML
    private Button btn_Users;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_search;

    @FXML
    private Button btn_workbensh;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> design;

    @FXML
    private TableColumn<?, ?> id_stock;

    @FXML
    private TableColumn<?, ?> mondadd;

    @FXML
    private TableColumn<?, ?> obs;

    @FXML
    private TableColumn<?, ?> pudadd;

    @FXML
    private TableColumn<?, ?> qutt_stock;

    @FXML
    private AnchorPane side_anchorpane;

    @FXML
    private TableColumn<?, ?> u_m;
    
    @FXML
    private AnchorPane scenePane;
    
    @FXML
  	public void logout(ActionEvent event) throws IOException {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout");
		alert.setContentText("do you want  to save before exiting?:");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			
		// for a normal logout without alert
			
			stage = (Stage)scenePane.getScene().getWindow();
			System.out.println("You successfully Logged out");
  			FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUP.fxml"));
  			root = loader.load();
  			
  			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
  			scene = new Scene(root);
  			stage.setScene(scene);
  			stage.show();
  			
		}
	}

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
	   
	  //des fonctions pour remplir le tableau a partir du database
		
		public String id_stock() {
			return null;
		}
		
		public String qutt_stock() {
			return null;
		}
		
		public String pudadd() {
			return null;
		}
		
		public String mondadd() {
			return null;
		}
		
		public String design() {
			return null;
		}
		
		public String obs() {
			return null;
		}
		
		public String u_m() {
			return null;
		}

		public DatePicker date() {
			return null;
		}

// une fonction pour le tracage du DATACHART
	
}
