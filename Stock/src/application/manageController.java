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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class manageController {

	private Stage stage;
	
	private Scene scene; 
	
	private Parent root;
	
    @FXML
    private ComboBox<?> ComboBox_Role;

    @FXML
    private TableColumn<?, ?> Date;

    @FXML
    private DatePicker DatePicker_Date;

    @FXML
    private TableColumn<?, ?> Employee_ID;

    @FXML
    private TableColumn<?, ?> First_Name;

    @FXML
    private ImageView ImageEmployee;

    @FXML
    private TableColumn<?, ?> Last_Name;

    @FXML
    private TableColumn<?, ?> Login;

    @FXML
    private TableColumn<?, ?> Password;

    @FXML
    private TableColumn<?, ?> Role;

    @FXML
    private TextField TextField_FirstName;

    @FXML
    private TextField TextField_LastName;

    @FXML
    private TextField TextField_Login;

    @FXML
    private PasswordField TextField_Password;

    @FXML
    private Button btn_Add;

    @FXML
    private Button btn_Delete;

    @FXML
    private Button btn_Import;

    @FXML
    private TextField btn_Search_User;

    @FXML
    private Button btn_Stock;

    @FXML
    private Button btn_Update;

    @FXML
    private Button btn_Users;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_search;

    @FXML
    private Button btn_workbensh;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private AnchorPane side_anchorpane;

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
	  
	 
	    //cette fonction lier au boutton "DELETE" pour effacer l'employee du database
	    public String DeleteUser() {
			return null;	
	    }
	    
	    //cette fonction lier au boutton "UPDATE" pour changer les donnees d l'employee dans database
	    public String UpdateUser() {
			return null;	
	    }
	    
	    //cette fonction lier au boutton "ADD" pour ajouter l'employee au database
	    public String AddUser() {
			return null;	
	    }
	    
	    //les fonctions qui suit pour extraires les donnees saisit par ADMIN
	    
	    		//Extraire FIRST NAME
	    			public String getFirstName() {
	    				return null;
	    			}
	    
	    		//Extraire LAST NAME
	    			public String getLastName() {
	    				return null;
	    			}
	    			
	      		//Extraire LOGIN
	    			public String getLogin() {
	    				return null;
	    			}
	    			
	    		//Extraire PASSWORD
	    			public String getPassword() {
	    				return null;
	    			}
	    			
	    
	    		//Extraire DATE
	    			public DatePicker getDate() {
	    				return null;
	    			}
	    
	    		//Extraire ROLE
	    			public String getRole() {
	    				return null;
	    			}
	    			
	    		//Extraire IMAGE
	    			public ImageView getImageEmployee() {
	    				return null;
	    			}
	    			
	 // les fonctions pour remplir les champs du tableau a partir du database
	    			
	    			public String Employee_ID() {
	    				return null;
	    			}
	    			
	    			public String First_Name() {
	    				return null;
	    			}
	    			
	    			public String Last_Name() {
	    				return null;
	    			}
	    			
	    			public String Login() {
	    				return null;
	    			}
	    			
	    			public String Password() {
	    				return null;
	    			}
	    			
	    			public String Role() {
	    				return null;
	    			}
	    			
	    			public DatePicker Date() {
	    				return null;
	    			}
	    
	
	}