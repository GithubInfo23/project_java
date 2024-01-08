package project_java.src.application.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import project_java.DAO.Stock_DAO;
import project_java.Models.Stock;

import static java.time.zone.ZoneRulesProvider.refresh;

public class listerstockController  {

	@FXML
	private TableView<Stock> tableView = new TableView<>();
    @FXML
    private Button btn_ajouter;
	@FXML
	private TextField btn_search;

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

	//@FXML
	//private TableView<Stock> tableView=new TableView<>();
	@FXML
	private TableColumn<Stock, Integer> ID;

	@FXML
	private TableColumn<Stock, Float> pudadd;
	@FXML
	private TableColumn<Stock, Float> mondadd;
	@FXML
	private TableColumn<Stock, String> design;
	@FXML
	private TableColumn<Stock, String> obs;
	@FXML
	private TableColumn<Stock, String> u_m;
	@FXML
	private TableColumn<Stock, Date> date;

	@FXML
	private TableColumn<Stock, Integer> qut_stock;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField text_search;


	private Stock_DAO stockDAO=new Stock_DAO();
	private Stock selectedstock;

	private FilteredList<Stock> filteredData;
	private SortedList<Stock> sortedData;
	@FXML
	public void initialize() {
		// Initialize the table columns
		ID.setCellValueFactory(new PropertyValueFactory<>("idStock"));
		qut_stock.setCellValueFactory(new PropertyValueFactory<>("quttStock"));
		pudadd.setCellValueFactory(new PropertyValueFactory<>("pudadd"));
		mondadd.setCellValueFactory(new PropertyValueFactory<>("mondadd"));
		design.setCellValueFactory(new PropertyValueFactory<>("design"));
		obs.setCellValueFactory(new PropertyValueFactory<>("obs"));
		u_m.setCellValueFactory(new PropertyValueFactory<>("um"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));


		// Fetch and populate data in the table view
		List<Stock> stock =stockDAO.lister();
		ObservableList<Stock> observableList = FXCollections.observableArrayList(stock);
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
				btn_supprimer.setDisable(false);
			} else {
				// Disable the delete button when no user is selected
				btn_supprimer.setDisable(true);
			}
		});
		refresh();
	}


		private Stage stage;
	    
	    public void loadScene (ActionEvent event , String fxmlFileName) {
			
		    LogInController loginController = new LogInController();
	        loginController.loadScene(event, fxmlFileName);
	   }
	    
	    //pour add stock(done)

	    @FXML
	    void ajouter(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/addstock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
	    	
	    	

	    }
	    
	    //go home(done)

	    @FXML
	    void home(ActionEvent event) {
	    	try{
				loadScene( event ,"/project_java/src/application/View/home.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    //pour print list stock

	    @FXML
		private void imprimer(ActionEvent event) {
			PrinterJob job = PrinterJob.createPrinterJob();
			if (job != null && job.showPrintDialog(tableView.getScene().getWindow())) {
				job.printPage(tableView);
				job.endJob();
			}
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
	    			loadScene( event ,"/project_java/src/application/View/LogIn.fxml");
	    		}
	    	}
	    
	    //pour update stock go to addstock(done)

	@FXML
	void modifier(ActionEvent event) {
		// Get the selected item from the TableView
		Stock selectedStock = tableView.getSelectionModel().getSelectedItem();

		if (selectedStock != null) {
			// Create a new FXMLLoader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_java/src/application/View/updatestock.fxml"));
			Parent root;

			try {
				// Load the updatestock.fxml file
				root = loader.load();

				// Get the controller associated with the updatestock.fxml
				updatestockcontroller updateController = loader.getController(); // Fix the variable name to UpdateStockController

				// Pass the selected stock object to the update controller
				updateController.initData(selectedStock);

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
			// No stock selected, show an alert
			showAlert("No Stock Selected", "Please select a stock to update.");
		}
	}

	private void showAlert(String title, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}



	//go to product(done)

	    @FXML
	    void produit(ActionEvent event) {
	    	try{
				loadScene( event ,"/project_java/src/application/View/produit.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    
	    //for search a stock
		@FXML
		void search(ActionEvent event) {
			// Get the search query from the text field
			String searchQuery = btn_search.getText().toLowerCase();

			// Apply the filter based on the search query
			filteredData.setPredicate(stock -> {
				if (searchQuery == null || searchQuery.isEmpty()) {
					return true;
				}

				// Check if any of the user properties contain the search query
				return stock.getDesign().toLowerCase().contains(searchQuery);
			});
		}


	//supprimer un stock selectionne
 @FXML
 private void supprimer(ActionEvent event) {
	 Stock selectedStock = tableView.getSelectionModel().getSelectedItem();
	 if (selectedStock != null) {
		 // Utilisez votre objet stock_dao pour supprimer l'élément sélectionné
		 stockDAO.deleteStock(selectedStock);

		 // Actualisez le TableView après la suppression
		 tableView.getItems().remove(selectedStock);

		 System.out.println("Stock deleted: " + selectedStock.getDesign());
	 }
 }

	private void afficherMessageSucces(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Succès");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	public void refrech() {
		// Votre code existant pour récupérer les données depuis la base de données

		// Effacez les données actuelles dans la TableView
		tableView.getItems().clear();

		// Chargez à nouveau la liste mise à jour depuis la base de données
		List<Stock> stockList = stockDAO.lister();  // Assurez-vous d'adapter cela à votre implémentation

		// Ajoutez les nouvelles données à la TableView
		tableView.getItems().addAll(stockList);
	}


	//go to stock(done)

	    @FXML
	    void stock(ActionEvent event) {
	    	try{
				loadScene( event ,"/project_java/src/application/View/stock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}

	    }
	    

	    //retour vers stock(done)
	    
	    @FXML 
	    void retour(ActionEvent event) {
	    	try{
				loadScene( event ,"/project_java/src/application/View/stock.fxml");
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
	    }
	    
	    
	    
	
	

	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
