package project_java.src.application.Controller;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project_java.DAO.ConnexionBDD;
import project_java.Models.Produit;
import project_java.src.application.Controller.LogInController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

//import static sun.jvm.hotspot.oops.CellTypeState.ref;

public class updateproduitcontroller {
    private Stage stage;
    public TextField nom;
    public TextField text_search;
    public Button btn_lister;
    public Button btn_reset;


    @FXML
    private TextField categorie;

    @FXML
    private TextField prix;

    @FXML
    private TextField quantite;

    @FXML
    private TextField ref;

    @FXML
    private TextField obs;

    @FXML
    private TextField date;
    @FXML
    private TextField ficheMvtStockField;
    @FXML
    private AnchorPane scenePane;
    public void initData(Produit selectedProduit) {
        // Set the data to the text fields
        if (nom != null) {
            nom.setText(selectedProduit.getNom_produit());
        }
        if (categorie != null) {
            categorie.setText(String.valueOf(selectedProduit.getId_famille()));
        }
        if (prix != null) {
            prix.setText(String.valueOf(selectedProduit.getPrix_unitaire()));
        }
        if (quantite != null) {
            quantite.setText(String.valueOf(selectedProduit.getQuantite()));
        }
        if (ref != null) {
            ref.setText(selectedProduit.getRef());
        }
        if (obs != null) {
            obs.setText(selectedProduit.getObs());
        }
        if (date != null) {
            date.setText(String.valueOf(selectedProduit.getDate()));
        }

        // You can also update an ImageView if needed
        // For example, if your ImageView is named 'image', you can set its image like this:
        // image.setImage(new Image(selectedProduit.getImagePath()));
    }
@FXML
void home(ActionEvent event) throws IOException {
    try {
        loadScene(event, "/project_java/src/application/View/home.fxml");
    } catch (Exception e) {
        System.out.println(e);
    }
}

    @FXML
    void produit(ActionEvent event) throws IOException{
        try{
            loadScene( event ,"/project_java/src/application/View/produit.fxml");
        }

        catch(Exception e){
            System.out.println(e);
        }


    }

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
    public void logout(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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

    public void importer(ActionEvent actionEvent) {
    }

    public void addproduit(ActionEvent actionEvent) {
    }


    public void loadScene (ActionEvent event , String fxmlFileName) {

        LogInController loginController = new LogInController();
        loginController.loadScene(event, fxmlFileName);
    }
    @FXML
    void lister(ActionEvent event) throws IOException{
        try{
            loadScene( event ,"/project_java/src/application/View/lister.fxml");
        }

        catch(Exception e){
            System.out.println(e);
        }


    }

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


    @FXML
    void retour(ActionEvent event) throws IOException {
        try {
            loadScene(event, "lister.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void save(ActionEvent event) throws SQLException {
        // Get the updated values from the text fields
        String updatedNom = nom.getText();
        String updatedCategorie = categorie.getText();
        float updatedPrix = Float.parseFloat(prix.getText());
        int updatedQuantite = parseInt(quantite.getText());
        String updatedRef = ref.getText();
        String updatedObs = obs.getText();
        String updatedDate = date.getText();
        //String updatedidfich = String.valueOf(ficheMvtStockField);
        String updatedidfich = ficheMvtStockField.getText();

        // Validate the input if needed

        // Update the selectedProduit object with the new values
        Produit selectedProduit=new Produit();
        selectedProduit.setNom_produit(updatedNom);
        selectedProduit.setId_famille(parseInt(updatedCategorie));
        selectedProduit.setPrix_unitaire(Double.parseDouble(String.valueOf(updatedPrix)));
        selectedProduit.setQuantite(parseInt(String.valueOf(updatedQuantite)));
        selectedProduit.setRef(updatedRef);
        selectedProduit.setObs(updatedObs);
        selectedProduit.setDate(Date.valueOf(updatedDate));
        selectedProduit.setId_fiche(parseInt(updatedidfich));

        // Save the changes to the database
        saveChangesToDatabase(selectedProduit);

        // Show a success message
        showAlert("Changes Saved", "The changes have been saved successfully.");
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void saveChangesToDatabase(Produit produit) throws SQLException {
        try (Connection connection = ConnexionBDD.getConnexion();
             // Create SQL query to update the database
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE produit SET nom_produit=?, id_famille=?, prix_unitaire=?, " +
                             "quantite=?, ref=?, obs=?, date=? WHERE id_produit=?")) {

            preparedStatement.setString(1, produit.getNom_produit());
            preparedStatement.setInt(2, produit.getId_famille());
            preparedStatement.setDouble(3, produit.getPrix_unitaire());
            preparedStatement.setInt(4, produit.getQuantite());
            preparedStatement.setString(5, produit.getRef());
            preparedStatement.setString(6, produit.getObs());
            preparedStatement.setString(7, String.valueOf(produit.getDate()));
            preparedStatement.setInt(8, produit.getId_produit());  // Assuming id is the primary key

            // Execute the update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save changes to the database.");
            throw e; // Re-throw the exception after handling
        }
    }
}
