package project_java.src.application.Controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project_java.DAO.Utilisateur_DAO;
import project_java.Models.Utilisateur;
import project_java.src.application.Controller.LogInController;

public class manageController {

	private Stage stage;

	private Scene scene;

	private Parent root;

	@FXML
	private ChoiceBox<String> myChoiceBox = new ChoiceBox<String>();

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
	private TableView<Utilisateur> tableView=new TableView<>();
	@FXML
	private TableColumn<Utilisateur, Integer> Employe_ID;
	@FXML
	private TableColumn<Utilisateur, String> First_Name;
	@FXML
	private TableColumn<Utilisateur, String> Last_Name;
	@FXML
	private TableColumn<Utilisateur, String> Login;
	@FXML
	private TableColumn<Utilisateur, String> Password;
	@FXML
	private TableColumn<Utilisateur, String> Role;
	@FXML
	private TableColumn<Utilisateur, Date> date;
	private String[] roles = {"Administrator", "Storekeeper", "Stock Manager"};

	private Utilisateur_DAO utilisateurDAO = new Utilisateur_DAO();
	private FilteredList<Utilisateur> filteredData;
	private SortedList<Utilisateur> sortedData;
	List<Utilisateur> userList = utilisateurDAO.Lister();
	ObservableList<Utilisateur> observableList = FXCollections.observableArrayList(userList);
	@FXML
	private TextField TextField_date;

	@FXML
	public void initialize() {
		// Initialize the table columns
		Employe_ID.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
		First_Name.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		Last_Name.setCellValueFactory(new PropertyValueFactory<>("nom"));
		Login.setCellValueFactory(new PropertyValueFactory<>("login"));
		Password.setCellValueFactory(new PropertyValueFactory<>("password"));
		Role.setCellValueFactory(new PropertyValueFactory<>("role"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));

		// Fetch and populate data in the table view
		observableList = FXCollections.observableArrayList(utilisateurDAO.Lister());
		tableView.setItems(observableList);

		// Initialize the filtered list and bind it to the table view
		filteredData = new FilteredList<>(observableList, p -> true);
		sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedData);

		// Enable the delete button only when a user is selected
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				// Enable the delete button when a user is selected
				btn_Delete.setDisable(false);
			} else {
				// Disable the delete button when no user is selected
				btn_Delete.setDisable(true);
			}
		});
		myChoiceBox.getItems().addAll(roles);
		myChoiceBox.setValue("Stock Manager");
	}
	@FXML
	void searchUser(ActionEvent event) {
		// Get the search query from the text field
		String searchQuery = btn_Search_User.getText().toLowerCase();

		// Apply the filter based on the search query
		filteredData.setPredicate(user -> {
			if (searchQuery == null || searchQuery.isEmpty()) {
				return true;
			}

			// Check if any of the user properties contain the search query
			return user.getPrenom().toLowerCase().contains(searchQuery)
					|| user.getNom().toLowerCase().contains(searchQuery)
					|| user.getLogin().toLowerCase().contains(searchQuery);
		});
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
			stage.close();
			loadScene( event ,"/project_java/src/application/View/LogIn.fxml");
		}
	}

	public void loadScene (ActionEvent event , String fxmlFileName) {

		LogInController loginController = new LogInController();
		loginController.loadScene(event, fxmlFileName);
	}


	//go to home(done)


	//go to manageuser(done)



	@FXML
	public void deleteUser(ActionEvent event) {
		Utilisateur selectedUser = tableView.getSelectionModel().getSelectedItem();

		if (selectedUser != null) {
			// Display a confirmation dialog before deleting
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Delete User");
			alert.setContentText("Are you sure you want to delete the selected user?");

			Optional<ButtonType> result = alert.showAndWait();

			if (result.isPresent() && result.get() == ButtonType.OK) {
				// User clicked OK, proceed with deletion
				utilisateurDAO.supprimer_utilisateur(selectedUser);

				// Remove the user from the table view
				observableList.remove(selectedUser); // La liste observable sera automatiquement mise à jour
			}
		} else {
			// No user selected, show a warning message
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("No User Selected");
			alert.setHeaderText(null);
			alert.setContentText("Please select a user to delete.");
			alert.showAndWait();
		}
	}

	//go to stock(done)

	@FXML
	void Consultstock(ActionEvent event) {

		try{
			loadScene( event ,"/project_java/src/application/View/stock.fxml");
		}

		catch(Exception e){
			System.out.println(e);
		}

	}
	@FXML
	void search(ActionEvent event) {

		try{
			loadScene( event ,"/project_java/src/application/View/search.fxml");
		}

		catch(Exception e){
			System.out.println(e);
		}

	}




	@FXML
	public void manageUsers(ActionEvent event) throws IOException {

		try{

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_java/src/application/View/manage.fxml"));
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


	//cette fonction lier au boutton "UPDATE" pour changer les donnees d l'employee dans database
	public String UpdateUser() {
		return null;
	}

	//cette fonction lier au boutton "ADD" pour ajouter l'employee au database
	@FXML
	public void AddUser(ActionEvent event) {
		Utilisateur newUser = new Utilisateur();
		// Get the user input from the text fields and combo box
		String firstName = TextField_FirstName.getText();
		String lastName = TextField_LastName.getText();
		String login = TextField_Login.getText();
		String password = TextField_Password.getText();
		//newUser.setRole(myChoiceBox.getValue());
		Date date = Date.valueOf(TextField_date.getText());

		// Validate the input (you may add more validation as needed)
		if (firstName.isEmpty() || lastName.isEmpty() || login.isEmpty() || password.isEmpty()) {
			// Show an alert for incomplete information
			showAlert(AlertType.ERROR, "Error", "Incomplete Information", "Please fill in all fields.");
			return;
		}

		// Hash the password using SHA-256
		String hashedPassword = hashPassword(password);

		// Create a new Utilisateur object
		newUser = new Utilisateur(firstName, lastName, login, hashedPassword, myChoiceBox.getValue(), date);

		// Add the user to the database
		utilisateurDAO.ajouter_utilisateur(newUser);

		// Add the user to the table view
		observableList.add(newUser);

		// Show a success message
		showAlert(AlertType.INFORMATION, "Success", "User Added", "User has been added successfully.");

		// Clear the input fields
		clearInputFields();
	}

	// Function to hash the password using SHA-256
	private String hashPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes());
			return Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null; // Gérer l'erreur de manière appropriée en production
		}
	}
	private void showAlert(AlertType alertType, String title, String header, String content) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	private void clearInputFields() {
		TextField_FirstName.clear();
		TextField_LastName.clear();
		TextField_Login.clear();
		TextField_Password.clear();
		myChoiceBox.getSelectionModel().clearSelection();
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