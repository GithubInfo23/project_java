package project_java.src.application.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project_java.DAO.Stock_DAO;

public class addstockController extends Application{

    @FXML
    public TextField obs;
    @FXML
    private Button btn_home;

    @FXML
    private Button btn_lister;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_produit;

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_stock;

    @FXML
    private TextField date;

    @FXML
    private TextField design;

    @FXML
    private TextField mondadd;

    @FXML
    private TextField pudadd;

    @FXML
    private TextField qutt_stock;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField text_search;


    @FXML
    private TextField u_m;

	private Stage stage;
    Stock_DAO  stockDAO = new Stock_DAO();

    public void loadScene (ActionEvent event , String fxmlFileName) {
		
	    LogInController loginController = new LogInController();
        loginController.loadScene(event, fxmlFileName);
   }
    
    
    
    //selectionner home(done)

    @FXML
    void home(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"/project_java/src/application/View/home.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    
    //afficher list des stocks(done)

    @FXML
    void lister(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"/project_java/src/application/View/listerstock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    
    //pour quitter et aller vers login(just supprimer stage.close et supprimer comentaire loadScene

    @FXML
    void logout(ActionEvent event) {
    	{
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
    
    //pour back(done)

    @FXML
    void retour(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"/project_java/src/application/View/listerstock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    

    
    //pour search un stock

    @FXML
    void search(ActionEvent event) {

    }
    
    //done
    

    @FXML
    void stock(ActionEvent event) throws IOException{
    	try{
			loadScene( event ,"/project_java/src/application/View/stock.fxml");
	}
		
catch(Exception e){
		System.out.println(e);	
		}


    }
    @FXML
    private void save(ActionEvent event) {
        // Récupérez les valeurs depuis les champs de texte
        int newquttStock = Integer.parseInt(qutt_stock.getText());
        float newpudadd = Float.parseFloat(pudadd.getText());
        float newmondadd = Float.parseFloat(mondadd.getText());
        String newDesign = design.getText();
        String newUM = u_m.getText();
        String newDate = date.getText();
        String newObs = obs.getText();

        // Validate the date format
        if (isValidDate(newDate)) {
            // Parse the date string and convert it to java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(newDate);

            // Ajoutez le nouveau stock à la base de données
            stockDAO.insert(newquttStock, newpudadd, newmondadd, newDesign, newObs, newUM, sqlDate);

            // Effacez les champs après l'ajout
            clearFields();

            // Ajoutez le message de succès
            showSuccessMessage("Stock added successfully!");
        } else {
            // Utilisez la méthode showError pour une date invalide
            showError("Invalid date format. Please enter a valid date.");
        }
    }
    private void showSuccessMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showError(String errorMessage) {
        // Implement how you want to handle or display the error message
        System.err.println("Error: " + errorMessage);
        // You might also display the error in a dialog or log it
    }
    private void clearFields() {
        qutt_stock.setText("");
        pudadd.setText("");
        mondadd.setText("");
        design.setText("");
        obs.setText("");
        u_m.setText("");
        date.setText("");
    }
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

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
