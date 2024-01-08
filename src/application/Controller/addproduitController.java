package project_java.src.application.Controller;
import javafx.collections.ObservableList;
import  project_java.Models.Produit;
import  project_java.DAO.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addproduitController extends Application{
	@FXML
	public Button btn_reset;
	@FXML
	    private Button btn_home;

	    @FXML
	    private Button btn_import;

	    @FXML
	    private Button btn_save;

	    @FXML
	    private Button btn_lister;

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

	    @FXML
	    private TextField categorie;

	    @FXML
	    private TextField date;

	    @FXML
	    private ImageView image;

	    @FXML
	    private TextField nom;

	    @FXML
	    private TextField obs;

		@FXML
		private TextField quantite;

		@FXML
		private TextField prix;

	    @FXML
	    private TextField ref;
		@FXML
		private TextField ficheMvtStockField;


	    @FXML
	    private AnchorPane scenePane;

	    @FXML
	    private TextField text_search;

		private Stage stage;
	    private ObservableList<Produit> observableList;

	   public void setObservableList(ObservableList<Produit> observableList) {
		   this.observableList = observableList;
	   }


	    public void loadScene (ActionEvent event , String fxmlFileName) {

		    LogInController loginController = new LogInController();
	        loginController.loadScene(event, fxmlFileName);
	   }
		private Produit produit = new Produit();
	// Add a method to initialize the Produit_DAO
	public void initializeDAO() {
		// Assuming Produit_DAO has a default constructor
		produitd = new Produit_DAO();
	}

		private Produit_DAO produitd;
	    //btn-save
		public void addproduit() {
			produitd = new Produit_DAO();
			Alert alert;
			try {
				// Validate numeric values before attempting to parse
				if (!isNumeric(prix.getText()) || !isNumeric(quantite.getText())) {
					throw new NumberFormatException("Invalid numeric values");
				}

				// Set values for the produit object
				produit.setNom_produit(nom.getText());
				produit.setPrix_unitaire(Double.parseDouble(prix.getText()));
				produit.setQuantite(Integer.parseInt(quantite.getText()));
				produit.setRef(ref.getText());
				produit.setObs(obs.getText());

				// Parse the date string using DateTimeFormatter
				String inputDate = date.getText().trim();
				DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate parsedDate = LocalDate.parse(inputDate, inputFormat);
				Date sqlDate = Date.valueOf(parsedDate);

				produit.setDate(sqlDate);

				// Utilisez la méthode getCategorieIdByName pour obtenir l'ID de la catégorie
				String categoryName = categorie.getText();
				Famille_DAO famille_DAO=new Famille_DAO();
				int categoryId = famille_DAO.getCategorieIdByName(categoryName);
				produit.setId_famille(categoryId);

				produit.setId_fiche(Integer.parseInt(ficheMvtStockField.getText()));

				// Validate non-empty fields
				if (nom.getText().isEmpty() || prix.getText().isEmpty() || quantite.getText().isEmpty()
						|| ref.getText().isEmpty() || obs.getText().isEmpty() || date.getText().isEmpty()
						|| categorie.getText().isEmpty()) {
					alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all blank fields");
					alert.showAndWait();
				} else {
					// Check if product with the same reference code exists
					boolean productExists = produitd.isProductExists(produit.getRef());

					// Check if the fiche_mvt_stock with the specified ID exists
					boolean ficheExists = produitd.isFicheExists(produit.getId_fiche());

					if (!ficheExists) {
						alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Error message");
						alert.setHeaderText(null);
						alert.setContentText("La fiche_mvt_stock avec l'ID spécifié n'existe pas.");
						alert.showAndWait();
						return;
					} else if (productExists) {
						// Display confirmation message
						alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Confirmation");
						alert.setHeaderText(null);
						alert.setContentText("Le produit existe déjà. Voulez-vous le mettre à jour ?");
						Optional<ButtonType> result = alert.showAndWait();

						if (result.isPresent() && result.get() == ButtonType.OK) {
							// Update existing product
							produitd.updateProduit(produit);
							addProductsRest();
						}
					} else {
						// Add new product
						produitd.ajouter_produit(produit);
						addProductsRest();
					}
				}
			} catch (NumberFormatException e) {
				alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error message");
				alert.setHeaderText(null);
				alert.setContentText("Please enter valid numeric values for 'Prix' and 'Quantite'");
				alert.showAndWait();
			} catch (DateTimeParseException e) {
				alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error message");
				alert.setHeaderText(null);
				alert.setContentText("Invalid date format. Please enter a valid date.");
				alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	// Validate if a string is a numeric value
	private boolean isNumeric(String str) {
		try {
			Float.parseFloat(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

//	    btn-delete
	   /* public void removePrdoduit() {
	    	produitd.supprimer_produit(produit);


	    }*/
//reset
@FXML
private void Reset(ActionEvent event) {
	nom.clear();
	prix.clear();
	quantite.clear();
	ref.clear();
	obs.clear();
	date.clear();
	categorie.clear();
	ficheMvtStockField.clear();
}

	public void addProductsRest() {
	nom.setText("");
	prix.setText("");  // Assuming prix is a TextField in your FXML
	quantite.setText("");  // Assuming quantite is a TextField in your FXML
	ref.setText("");
	obs.setText("");
	date.setText("");
	categorie.setText("");
}


	//go to home(done)

	    @FXML
	    void home(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/home.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}


	    }



	    //imprimer les infos du stock by click sur print

	    //@FXML
	    /*void imprimer(ActionEvent event) {

	    }*/

	    //go to ajouteproduit(interface pour lister produits) (done)

	    @FXML
	    void lister(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/lister.fxml");
		}

     	catch(Exception e){
			System.out.println(e);
			}


	    }

	  //quitter la page (modifier pour  quitter au login)remove comments and stage.close

	    @FXML
	    void logout(ActionEvent event) {
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
	    //click sur update pour modifier

	    @FXML
	    void modifier(ActionEvent event) {

	    }

	    //go to produit (done)

	    @FXML
	    void produit(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/produit.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}


	    }
	    //go to produit(done)

	    @FXML
	    void retour(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/produit.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}


	    }

	    //pour chercher un produit

	    @FXML
	    void search(ActionEvent event) {

	    }

	    //go to stock(done)

	    @FXML
	    void stock(ActionEvent event) throws IOException{
	    	try{
				loadScene( event ,"/project_java/src/application/View/stock.fxml");
		}

	catch(Exception e){
			System.out.println(e);
			}


	    }

	    //click sur delete pour supprimer

	    @FXML
	    void supprimer(ActionEvent event) {

	    }

		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub

		}



	private void showAlert(AlertType alertType, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}




}
