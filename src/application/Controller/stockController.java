package project_java.src.application.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import project_java.DAO.Stock_DAO;
import project_java.Models.Stock;
import project_java.src.application.Controller.LogInController;

public class stockController extends Application{
	@FXML
    private Label ID;

    @FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_imprimer;

    @FXML
    private Button btn_lister;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_produit;

    @FXML
    private Button btn_stock;

    @FXML
    private Button btn_supprimer;

    @FXML
    private Label date;

    @FXML
    private Label design;

    @FXML
    private Label mondadd;

    @FXML
    private Label obs;

    @FXML
    private Label pudadd;

    @FXML
    private Label qutt_stock;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField text_search;

    @FXML
    private Label u_m;

	private Stage stage;
	Stock_DAO stockDAO;
	@FXML
	private TextField text_design;
	@FXML
	private TextField text_u_m;
	@FXML
	private TextField text_date;
	@FXML
	private TextField text_obs;
	@FXML
	private TextField text_qutt_stock;
	@FXML
	private TextField text_pudadd;
	@FXML
	private TextField text_mondadd;
	@FXML
	private TextField text_id;



	public void loadScene (ActionEvent event , String fxmlFileName) {

		    LogInController loginController = new LogInController();
	        loginController.loadScene(event, fxmlFileName);
	   }

	    //ajouter un stock vers add stock(done)

	    @FXML
	    void ajouter(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/addstock.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}


	    }
	    //selectionner home(done)

	    @FXML
	    void home(ActionEvent event) throws IOException{

	    	try{
				loadScene( event ,"/project_java/src/application/View/ChefStock.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}

	    }
	public void imprimer() {
		// Créez une nouvelle instance de PrinterJob
		PrinterJob printerJob = PrinterJob.createPrinterJob();

		// Vérifiez si l'impression est supportée
		if (printerJob != null && printerJob.showPrintDialog(scenePane.getScene().getWindow())) {
			// Créez un nouveau nœud pour contenir toutes les informations sur le produit
			AnchorPane printNode = new AnchorPane();

			// Ajoutez toutes les informations sur le produit au nœud
			Label labelID = new Label("ID: " + ID.getText());
			Label labelDesign = new Label("Design: " + design.getText());
			Label labelUM = new Label("U_M: " + u_m.getText());
			Label labelDate = new Label("Date: " + date.getText());
			Label labelquttStock = new Label("Quantite de stock: " + qutt_stock.getText());
			Label labelpudadd = new Label("pudadd: " + pudadd.getText());
			Label labelobs = new Label("Observations : " + obs.getText());
			Label labelmond = new Label("Mondadd: "+ mondadd.getText());

			// Positionnez les étiquettes dans le nœud
			labelID.setLayoutX(10);
			labelID.setLayoutY(10);

			labelDesign.setLayoutX(10);
			labelDesign.setLayoutY(40);

			labelUM.setLayoutX(10);
			labelUM.setLayoutY(70);

			labelDate.setLayoutX(10);
			labelDate.setLayoutY(100);

			labelquttStock.setLayoutX(10);
			labelquttStock.setLayoutY(130);

			labelpudadd.setLayoutX(10);
			labelpudadd.setLayoutY(160);

			labelobs.setLayoutX(10);
			labelobs.setLayoutY(190);

			labelmond.setLayoutX(10);
			labelmond.setLayoutY(220);

			// Ajoutez les étiquettes au nœud
			printNode.getChildren().addAll(labelID, labelDesign, labelUM, labelDate, labelquttStock, labelpudadd, labelobs, labelmond);

			// Imprimez le nœud
			printerJob.printPage(printNode);

			// Terminez le travail d'impression
			printerJob.endJob();
		}
	}

	//afficher la liste des stocks(done)

	    @FXML
	    void lister(ActionEvent event) throws IOException{

	    	try{
				loadScene( event ,"/project_java/src/application/View/listerstock.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}

	    }
	    //logout to login delete comments and stage.close

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
	    //pour Update les infos du stock go to addstock(done)

	@FXML
	private void modifier(ActionEvent event) {
		// Récupérez l'ID du produit à modifier
		String stockID = text_id.getText(); // Assurez-vous que la variable ID est accessible

		// Récupérez les nouvelles valeurs depuis les champs de texte
		int newquttStock = Integer.parseInt(text_qutt_stock.getText());
		float newpudadd = Float.parseFloat(text_pudadd.getText());
		float newmondadd = Float.parseFloat(text_mondadd.getText());
		String newDesign = text_design.getText();
		String newUM = text_u_m.getText();
		String newDate = text_date.getText();
		String newObs = text_obs.getText();

		// Validate the date format
		if (isValidDate(newDate)) {
			// Parse the date string and convert it to java.sql.Date
			java.sql.Date sqlDate = java.sql.Date.valueOf(newDate);

			// Update the database using the sqlDate
			stockDAO.update(stockID, newquttStock, newpudadd, newmondadd, newDesign, newObs,newUM,sqlDate );

			clearFields();
			showSuccessMessage("Stock updated successfully!");
		} else {
			// Use showError method for invalid date
			showError("Invalid date format. Please enter a valid date.");
		}
		// Effacez les champs après la mise à jour
		clearFields();

		// Ajoutez le message de succès
		showSuccessMessage("Stock updated successfully!");
	}

	// Méthode pour vérifier la validité d'une date
	private boolean isValidDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	private void showError(String errorMessage) {
		// Implement how you want to handle or display the error message
		System.err.println("Error: " + errorMessage);
		// You might also display the error in a dialog or log it
	}

	    //selectionner produit(done)
	    @FXML
	    void produit(ActionEvent event) throws IOException{

	    	try{
				loadScene( event ,"/project_java/src/application/View/produit.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}

	    }
	    //rechercher a un stock

		@FXML
		void search(ActionEvent event) throws SQLException {
			// Récupérer le texte de recherche
			String searchText = text_search.getText();

			// Vérifier si le stockDAO est null
			if (stockDAO == null) {
				// Initialiser le stockDAO si c'est null (remplacez StockDAO avec votre classe DAO réelle)
				stockDAO = new Stock_DAO();
			}

			// Vérifier si le texte de recherche n'est pas vide
			if (!searchText.isEmpty()) {
				// Appeler la méthode searchStockByName seulement si le texte de recherche n'est pas vide
				Stock stock = stockDAO.searchStockByName(searchText);

				// Mettez à jour les labels ou faites quelque chose avec le résultat
				if (stock != null) {
					// Mettez à jour les labels avec les données du stock trouvé
					text_id.setText(String.valueOf(stock.getIdStock()));
					text_qutt_stock.setText(String.valueOf(stock.getQuttStock()));
					text_pudadd.setText(String.valueOf(stock.getPudadd()));
					text_mondadd.setText(String.valueOf(stock.getMondadd()));
					text_design.setText(stock.getDesign());
					text_obs.setText(stock.getObs());
					text_u_m.setText(stock.getuM());
					text_date.setText(String.valueOf(stock.getDate()));
				} else {
					// Afficher une alerte si le stock n'est pas trouvé
					showAlert(Alert.AlertType.INFORMATION, "Information", "Stock not found");
				}
			} else {
				// Afficher une alerte si le champ de recherche est vide
				showAlert(Alert.AlertType.WARNING, "Warning", "Please enter a search term");
			}
		}

	private void showAlert(Alert.AlertType alertType, String title, String content) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
	    //selectionner stock(done)

	    @FXML
	    void stock(ActionEvent event) {
	    	try{
				loadScene( event ,"/project_java/src/application/View/stock.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}

	    }
	    //pour delete un stock

	@FXML
	private void supprimer(ActionEvent event) {
		// Récupérez l'ID du produit à supprimer
		String stockID = ID.getText(); // Assurez-vous que la variable ID est accessible

		// Utilisez la méthode delete de StockDAO pour supprimer l'enregistrement
		stockDAO.delete(stockID);

		// Affichez un message de succès
		showSuccessMessage("stock supprimé avec succès");

		// Effacez les champs après la suppression
		clearFields();
	}
	private void clearFields() {
		text_id.setText("");
		text_qutt_stock.setText("");
		text_pudadd.setText("");
		text_mondadd.setText("");
		text_design.setText("");
		text_obs.setText("");
		text_u_m.setText("");
		text_date.setText("");
	}

	private void showSuccessMessage(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Succès");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
