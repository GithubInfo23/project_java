package project_java.src.application.Controller;

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
import project_java.DAO.Admin_DAO;
import project_java.DAO.ChefStock_DAO;
import project_java.DAO.Magasinier_DAO;
import project_java.DAO.Utilisateur_DAO;
import project_java.Models.Utilisateur;
import project_java.src.application.Controller.alertMessage;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ResourceBundle;

public class RegController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TextField signup_lastname;
	@FXML
	private TextField signup_firstname;
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

	private String[] roles = {"Administrator", "Storekeeper", "Stock Manager"};

	private Utilisateur_DAO utilisateurDAO = new Utilisateur_DAO();
	private Admin_DAO adminDAO = new Admin_DAO();
	private Magasinier_DAO magasinierDAO = new Magasinier_DAO();
	private ChefStock_DAO chef_stockDAO = new ChefStock_DAO();

	public void register() {
		alertMessage alert = new alertMessage();

		if (signup_email.getText().isEmpty() || signup_lastname.getText().isEmpty() || signup_firstname.getText().isEmpty() || signup_password.getText().isEmpty() || signup_confpassword.getText().isEmpty()) {
			alert.errorMessage("All fields are necessary to be filled");
		} else if (!signup_password.getText().equals(signup_confpassword.getText())) {
			alert.errorMessage("Password does not match!");
		} else if (signup_password.getText().length() < 8) {
			alert.errorMessage("Invalid Password, at least 8 characters needed");
		} else {
			// Create a new Utilisateur object with the user's information
			Utilisateur newUser = new Utilisateur();
			newUser.setNom(signup_lastname.getText());
			newUser.setPrenom(signup_firstname.getText());
			newUser.setLogin(signup_email.getText());

			// Hash the password before storing it
			String hashedPassword = hashPassword(signup_password.getText());
			newUser.setPassword(hashedPassword);

			newUser.setDate(new Date(System.currentTimeMillis()));  // Set the current date

			// Set the role based on the selected value in the ChoiceBox
			newUser.setRole(myChoiceBox.getValue());

			// Add the user to the Utilisateur table
			utilisateurDAO.ajouter_utilisateur(newUser);

			alert.successMessage("Registered Successfully");
			registerClearFields();
		}
	}

	private String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(password.getBytes());

			// Convert the byte array to a hexadecimal string
			StringBuilder hexString = new StringBuilder();
			for (byte hashedByte : hashedBytes) {
				String hex = Integer.toHexString(0xff & hashedByte);
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			// Handle the exception appropriately
			return null;
		}
	}

	public void registerClearFields() {
		signup_email.setText("");
		signup_lastname.setText("");
		signup_firstname.setText("");
		signup_password.setText("");
		signup_confpassword.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoiceBox.getItems().addAll(roles);
		myChoiceBox.setValue("Administrator");
	}

	public void login(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_java/src/application/View/login.fxml"));
			root = loader.load();

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
