package project_java.src.application.Controller;

import java.io.IOException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project_java.DAO.Famille_DAO;
import project_java.DAO.Produit_DAO;
import project_java.Models.Produit;

//liste produit !!!!!!!!!!
public class listerController {
	  @FXML
	   private TableView<Produit>tableView = new TableView<>();
	   @FXML
	   private TableColumn<Produit, String> ID;

	    @FXML
	    private TableColumn<Produit, String> Nom;

	    @FXML

	    private TableColumn<Produit, Double> Prix;
	    @FXML

	    private TableColumn<Produit, Integer> Quantite;
	    @FXML

	    private TableColumn<Produit, String> Ref;
	    @FXML

	    private TableColumn<Produit, String> Obs;
	    @FXML

	    private TableColumn<Produit, String> Date;
	    @FXML

	    private TableColumn<Produit, String> Categorie;
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
	    private TextField btn_search;

	    @FXML
	    private Button btn_retour;

	    @FXML
	    private Button btn_stock;

	    @FXML
	    private Button btn_supprimer;

	    @FXML
	    private AnchorPane scenePane;

	    @FXML
	    private TableView<Produit> table_view;

	    @FXML
	    private TextField text_search;

	   private Stage stage;

      Produit_DAO produit;
	private TextField txtCategorie;
	private TextField txtID;
	private TextField txtNom;
	private TextField txtPrix;
	private TextField txtQuantite;
	private TextField txtRef;
	private TextField txtObs;
	private java.awt.TextField txtDate;


	public listerController(TableColumn<Produit, String> categorie, TableColumn<Produit, String> date,
							TableColumn<Produit, String> iD, TableColumn<Produit, String> nom, TableColumn<Produit, String> obs,
							TableColumn<Produit, Double> prix, TableColumn<Produit, Integer> quantite,
							TableColumn<Produit, String> ref) {
		super();
		Categorie = categorie;
		Date = date;
		ID = iD;
		Nom = nom;
		Obs = obs;
		Prix = prix;
		Quantite = quantite;
		Ref = ref;
	}
	public listerController() {
		produit = new Produit_DAO(); // Initialisation du Produit_DAO
	}





//   =====================================================
public void loadScene (ActionEvent event , String fxmlFileName) {

	    LogInController loginController = new LogInController();
        loginController.loadScene(event, fxmlFileName);
   }


/*public ObservableList<Produit> addProducList(){
	 ObservableList <Produit> produitList=FXCollections.observableArrayList();
	 produitList =(ObservableList<Produit>) produit.Lister();
	 return produitList;

}
*/
/*private ObservableList<Produit> addproduitlist;
public  void addProduitShowList() {
	addproduitlist=addProducList();
	ID.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
	Nom.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
	Prix.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
	Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
	Ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
	Obs.setCellValueFactory(new PropertyValueFactory<>("obs"));
	Date.setCellValueFactory(new PropertyValueFactory<>("date"));
	Categorie.setCellValueFactory(new PropertyValueFactory<>("id_famille"));

	addProducts_tableView.setItems(addproduitlist);

}
 public void removeProduct() {


 }*/
private ObservableList<Produit> observableList;
	@FXML
	void ajouter(ActionEvent event) throws IOException {
		try {
			// Charger la scène "addproduit.fxml"
			FXMLLoader loader = new FXMLLoader(getClass().getResource("addproduit.fxml"));
			Parent root = loader.load();

			// Récupérer le contrôleur associé à la scène "addproduit.fxml"
			addproduitController addProduitController = loader.getController();

			// Initialiser la liste observable dans le contrôleur "addProduitController"
			addProduitController.setObservableList(observableList);

			// Afficher la scène
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}






    @FXML
    //selectionner home(done)
    void home(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"home.fxml");
	}

catch(Exception e){
		System.out.println(e);
		}

    }
    //cliquer sur lougout

  //quitter la page (modifier pour  quitter au login)remove comments and stage.close

    @FXML
    public void logout(ActionEvent event) {
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
    //selectionner un produit click sur Update and go to addproduit to modify(done)
@FXML
	void modifier(ActionEvent event) {
		// Get the selected item from the TableView
		Produit selectedProduit = table_view.getSelectionModel().getSelectedItem();

		if (selectedProduit != null) {
			// Create a new FXMLLoader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_java/src/application/View/updateproduit.fxml"));
			Parent root;

			try {
				// Load the updateproduit.fxml file
				root = loader.load();

				// Get the controller associated with the updateproduit.fxml
				updateproduitcontroller updateController = loader.getController();

				// Pass the selected Produit object to the update controller
				updateController.initData(selectedProduit); // Fix the variable name to updateController

				// Create a new scene with the loaded root
				Scene scene = new Scene(root);

				// Get the stage from the event
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				// Set the new scene to the stage
				stage.setScene(scene);

				// Show the stage
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// No product selected, show an alert
			showAlert("No Product Selected", "Please select a product to update.");
		}
	}
	//selectionner produit(done)

    @FXML
    void produit(ActionEvent event) throws IOException {

    	try{
			loadScene( event ,"/project_java/src/application/View/produit.fxml");
	}

catch(Exception e){
		System.out.println(e);
		}

    }
    //chercher sur un produit


	@FXML
	void search(ActionEvent event) {
		// Get the search query from the text field
		String searchQuery = btn_search.getText().toLowerCase();

		// Apply the filter based on the search query
		filteredData.setPredicate(produit -> {
			if (searchQuery == null || searchQuery.isEmpty()) {
				return true;
			}

			// Compare the search query with various fields of the product (e.g., name, reference, etc.)
			return produit.getNom_produit().toLowerCase().contains(searchQuery)
					|| produit.getRef().toLowerCase().contains(searchQuery)
					|| produit.getObs().toLowerCase().contains(searchQuery);
		});
	}



	// selectionner stock(done)

    @FXML
    void stock(ActionEvent event) throws IOException{

    	try{
			loadScene( event ,"/project_java/src/application/View/stock.fxml");
	}

catch(Exception e){
		System.out.println(e);
		}

    }
    //supprimer produit click sur delete

	@FXML
	void supprimer(ActionEvent event) {
		Produit selectedProduit = table_view.getSelectionModel().getSelectedItem();

		if (selectedProduit != null) {
			// Display a confirmation dialog
			Dialog<ButtonType> confirmationDialog = new Dialog<>();
			confirmationDialog.setTitle("Confirmation");
			confirmationDialog.setHeaderText("Delete Product");
			confirmationDialog.setContentText("Are you sure you want to delete the selected product?");
			confirmationDialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

			// Handle the user's response
			confirmationDialog.showAndWait().ifPresent(response -> {
				if (response == ButtonType.YES) {
					// Delete the selected product from the TableView
					table_view.getItems().remove(selectedProduit);

					// Call your DAO method to delete the product from the database
					int idToDelete = selectedProduit.getId_produit();
					produit.supprimer_produit(idToDelete);
				}
			});
		} else {
			// No product selected, show an alert
			showAlert("No Product Selected", "Please select a product to delete.");
		}
	}


	private void showAlert(String title, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}

    //retour to produit(done)
    @FXML
    void retour(ActionEvent event) {
    	try{
			loadScene( event ,"/project_java/src/application/View/produit.fxml");
	}

catch(Exception e){
		System.out.println(e);
		}
    }

    //imprimer produit click sur print


	@FXML
	private void imprimer(ActionEvent event) {
		PrinterJob job = PrinterJob.createPrinterJob();
		if (job != null && job.showPrintDialog(table_view.getScene().getWindow())) {
			job.printPage(table_view);
			job.endJob();
		}
	}

	private FilteredList<Produit> filteredData;
	private SortedList<Produit> sortedData;
	@FXML
	public void initialize() {
		// Initialize the table columns
		ID.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
		Nom.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
		Prix.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
		//Categorie.setCellValueFactory(new PropertyValueFactory<>("id_famille"));
		Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
		Ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
		Obs.setCellValueFactory(new PropertyValueFactory<>("obs"));
		Date.setCellValueFactory(new PropertyValueFactory<>("date"));

		Categorie.setCellValueFactory(cellData -> {
			Famille_DAO fdao=new Famille_DAO();
					// cellData.getValue() renvoie un Produit, utilisez cette instance pour obtenir le nom de la catégorie
					int idFamille = cellData.getValue().getId_famille();
					String nomCategorie = fdao.getCategorieNameById(idFamille);
					return new SimpleStringProperty(nomCategorie);
		});
		// Fetch and populate data in the table view
		List<Produit> userpdt =produit.Lister();
		ObservableList<Produit> observableList = FXCollections.observableArrayList(userpdt);
		table_view.setItems(observableList);
        // Initialize the filtered list and bind it to the table view
		filteredData = new FilteredList<>(observableList, p -> true);
		sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedData);

		// Enable the delete button only when a user is selected
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				// Enable the delete button when a user is selected
				btn_supprimer.setDisable(false);
			} else {
				// Disable the delete button when no user is selected
				btn_supprimer.setDisable(true);
			}
		});
	}





	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}





}
