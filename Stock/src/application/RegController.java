package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegController implements Initializable {
	private Stage stage;
	private Scene scene; 
	private Parent root;
	@FXML
	private TextField signup_user;
	@FXML
	private TextField signup_email;
	@FXML
	private TextField signup_password;
	@FXML
	private TextField signup_confpassword;
	@FXML
	private Button signupButton;
	@FXML
	private Button loginButton;
	@FXML
	private ChoiceBox<String> myChoiceBox;
	
	private String[] roles = {"Administrator","Storekeeper","Stock Manager"};
	
	//check si on a des cases vides 
	public void register() {
		
		alertMessage alert = new alertMessage();
		
		if(signup_email.getText().isEmpty() || signup_user.getText().isEmpty() || signup_password.getText().isEmpty() || signup_confpassword.getText().isEmpty()) {
			alert.errorMessage("All fields are necessary to be filled");
		} else if(signup_password.getText() == signup_confpassword.getText()) {

			alert.errorMessage("Password does not match !");
		} else if(signup_password.getText().length() < 8) {
//			pourque le mots de passe ne depasse pas 8 chiffres ou caracteres
			alert.errorMessage("Invalid Password,at least 8 characters needed");
		} else {
			alert.successMessage("Registered Successfully");
			registerClearFields();
		}
	}
	
//	pour rendre les cases vides si les champs sont correct
	public void registerClearFields() {
		signup_email.setText("");
		signup_user.setText("");
		signup_password.setText("");
		signup_confpassword.setText("");
	}
	
	//	Cette methode pour le choix de l'utilisateur d'un role
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoiceBox.getItems().addAll(roles);
		myChoiceBox.setValue("Administrator");
		
	}
	
//si en click sur login cette fonct nous derige directement a l'interface de login
	public void login(ActionEvent event) throws IOException {
		
		try{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
			root = loader.load();
			
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e){
			System.out.println(e);	
			}
		

}
	
}
