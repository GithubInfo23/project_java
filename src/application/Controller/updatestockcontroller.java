package project_java.src.application.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project_java.DAO.ConnexionBDD;
import project_java.Models.Stock;
import project_java.src.application.Controller.LogInController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class updatestockcontroller {
    public TextField qutt_stock;
    public TextField pudadd;
    public TextField mondadd;
    public TextField obs;
    public TextField design;
    public TextField u_m;
    public TextField date;
    private Stage stage;
    @FXML
    private Node scenePane;

    @FXML
    private TableView<Stock> tableView;
    @FXML
    void home(ActionEvent event) throws IOException{
        try{
            loadScene( event ,"/project_java/src/application/View/home.fxml");
        }

        catch(Exception e){
            System.out.println(e);
        }


    }

    @FXML
    void retour(ActionEvent event) throws IOException{
        try{
            loadScene( event ,"/project_java/src/application/View/listerstock.fxml");
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




    public void initData(Stock selectedStock) {
        qutt_stock.setText(String.valueOf(selectedStock.getQuttStock()));
        pudadd.setText(String.valueOf(selectedStock.getPudadd()));
        mondadd.setText(String.valueOf(selectedStock.getMondadd()));
        obs.setText(String.valueOf(selectedStock.getObs()));
        design.setText(selectedStock.getDesign());  // Set the 'ref' field
        obs.setText(selectedStock.getObs());
        u_m.setText(selectedStock.getuM());
        date.setText(String.valueOf(selectedStock.getDate()));
    }





    @FXML
    private void save(ActionEvent event) throws SQLException {
        // Get the updated values from the text fields
        String updatedDesign = design.getText();
        String updatedum = u_m.getText();
        float updatedmonadd = Float.parseFloat(mondadd.getText());
        int updatedQuantite = Integer.parseInt(qutt_stock.getText()); // Fix variable name
        float updatedpudadd = Float.parseFloat(pudadd.getText());
        String updatedObs = obs.getText();
        Date updatedDate = Date.valueOf(date.getText());

        // Validate the input if needed

        // Update the selectedStock object with the new values
        Stock selectedStock=new Stock();
        selectedStock.setDesign(updatedDesign);
        selectedStock.setuM(updatedum); // Assuming uM is a String property
        selectedStock.setPudadd(updatedpudadd);
        selectedStock.setQuttStock(updatedQuantite);
        selectedStock.setMondadd(updatedmonadd);
        selectedStock.setDate(updatedDate);
        selectedStock.setObs(updatedObs);


        // Save the changes to the database
        saveChangesToDatabase(selectedStock); // Assuming you have a method to save changes in your DAO

        // Show a success message
        showAlert("Changes Saved", "The changes have been saved successfully.");
    }
    private void saveChangesToDatabase(Stock stock) throws SQLException {
        try (Connection connection = ConnexionBDD.getConnexion();
             // Create SQL query to update the database
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE stock SET quttStock=?, pudadd=?, mondadd=?, " +
                             "design=?, obs=?, uM=?, date=? WHERE idStock=?")) {

            preparedStatement.setInt(1, stock.getQuttStock());
            preparedStatement.setFloat(2, stock.getPudadd());
            preparedStatement.setFloat(3, stock.getMondadd());
            preparedStatement.setString(4, stock.getDesign());
            preparedStatement.setString(5, stock.getObs());
            preparedStatement.setString(6, stock.getuM());
            preparedStatement.setString(7, String.valueOf(stock.getDate()));
            preparedStatement.setInt(8, stock.getIdStock());  // Assuming id is the primary key

            // Execute the update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save changes to the database.");
            throw e; // Re-throw the exception after handling
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void search(ActionEvent actionEvent) {
    }

    @FXML
    void lister(ActionEvent event) throws IOException {
        try{
            loadScene( event ,"/project_java/src/application/View/listerstock.fxml");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void loadScene (ActionEvent event , String fxmlFileName) {

        LogInController loginController = new LogInController();
        loginController.loadScene(event, fxmlFileName);
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
    void logout(ActionEvent event) {
        {
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

    }


}
