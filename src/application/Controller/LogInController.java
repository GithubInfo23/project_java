package project_java.src.application.Controller;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project_java.DAO.Utilisateur_DAO;
import project_java.src.application.Controller.alertMessage;

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

	private String[] roles = {"Administrator", "Storekeeper", "Stock Manager"};

	@FXML
	private Button loginButton;

	@FXML
	private Button signupButton;

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
				String selectedJob = myChoiceBox.getValue();

				// Call the authentification method to check login credentials
				Utilisateur_DAO utilisateurDAO = new Utilisateur_DAO();
				if (utilisateurDAO.authentification(username, pass, selectedJob)) {
					switch (selectedJob) {
						case "Administrator":
							loadScene(event, "/project_java/src/application/View/manage.fxml");
							break;
						case "Storekeeper":
							loadScene(event, "/project_java/src/application/View/home.fxml");
							break;
						case "Stock Manager":
							loadScene(event, "/project_java/src/application/View/ChefStock.fxml");
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
		try {
			loadScene(event, "/project_java/src/application/View/SignUp.fxml");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoiceBox.getItems().addAll(roles);
		myChoiceBox.setValue("Stock Manager");  // Set the default value
	}
}
