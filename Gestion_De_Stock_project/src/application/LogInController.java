package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController implements Initializable {
	
	private Stage stage;
	private Scene scene; 
	private Parent root;
	

	@FXML
	private TextField nameTextField;
	
	@FXML
	private PasswordField passTextField;
	@FXML
	private ChoiceBox<String> myChoiceBox;
	private String[] job= {"Administrator","Storekeeper","Stock Manager"};
	
	@FXML
	private Button loginBotton;
	@FXML
	private Button SignBotton;
	
	
	public void loadScene(ActionEvent event, String fxmlFileName) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
	        root = loader.load();
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	public void login(ActionEvent event) throws IOException {

	    try {

	        alertMessage alert = new alertMessage();

	        String username = nameTextField.getText();
	        String pass = passTextField.getText();
	     
	        if (username.isEmpty() || pass.isEmpty()) {
	            alert.errorMessage("Veuillez remplir tous les champs !! ");
	        } else {
	        	
	        	// hna fblast manst3ml username="Maryam" login="123" b des valeurs mn base de données
	        	
	            if (username.equals("Maryam") && pass.equals("123")) {

	                String selectedJob = myChoiceBox.getValue();
	         
	                switch (selectedJob) {
	                    case "Administrator":
	                        loadScene(event, "admin.fxml");
	                        break;
	                    case "Storekeeper":
	                        loadScene(event, "home.fxml");
	                        break;
	                    case "Stock Manager":
	                    	
	                        loadScene(event, "ChefStock.fxml");
	                        break;

	                    default:
	                        break;
	                }

	            } else {
	                alert.errorMessage("User Name or Password incorrect !!");
	            }

	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

	
	public void signup(ActionEvent event) throws IOException {
		
			try{
				
				loadScene(event , "SignUp.fxml");
			}
			catch(Exception e){
				System.out.println(e);	
				}
		
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		myChoiceBox.getItems().addAll(job);
		myChoiceBox.setValue("Stock Manager");  // Définir la valeur par défaut
	}
	
}
