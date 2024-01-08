package project_java.src.application.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import project_java.DAO.ConnexionBDD;
import project_java.DAO.Famille_DAO;
import project_java.DAO.Produit_DAO;
import project_java.Models.Produit;
import project_java.src.application.Controller.LogInController;

public class produitController extends Application {
    public Label idMvtStock;
    @FXML
    public TextField text_id;

    @FXML
    public TextField text_categ;
    @FXML
    public TextField text_nom;
    @FXML
    public TextField text_qte;
    @FXML
    public TextField text_prix;
    @FXML
    public TextField text_ref;
    @FXML
    public TextField text_obs;
    @FXML
    public TextField text_date;
    @FXML
    public TextField text_fich;
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
    private Label categorie;

    @FXML
    private Label date;

    @FXML
    private Label id;
    @FXML
    private Label idfiche;
    @FXML
    private ImageView image;

    @FXML
    private Label nom;

    @FXML
    private Label obs;

    @FXML
    private Label prix;

    @FXML
    private Label quantite;

    @FXML
    private Label ref;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField text_search;


    private Stage stage;


    private Produit_DAO produitDAO=new Produit_DAO();




    public void loadScene(ActionEvent event, String fxmlFileName) {

        LogInController loginController = new LogInController();
        loginController.loadScene(event, fxmlFileName);
    }


    //go to addproduit(done)
    @FXML
    void ajouter(ActionEvent event) throws IOException {
        try {
            loadScene(event, "/project_java/src/application/View/addproduit.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    //go to home(done)
    @FXML
    void home(ActionEvent event) throws IOException {
        try {
            loadScene(event, "/project_java/src/application/View/ChefStock.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    //importer une image de produit cliquons sur import
    @FXML
    void importer(ActionEvent event) {

    }
    //imprimer les informations du produit cliqunons sur imprimer

    @FXML
    private void imprimer(ActionEvent event) {
        // Code to handle printing
        printProductInfo();

        // Code to handle PDF generation
        generatePDF();
    }

    private void printProductInfo() {
        // Create a new AnchorPane to represent the printable content
        AnchorPane printableContent = new AnchorPane();

        // Add the specific product information to the printable content
        Label productNameLabel = new Label("Product Name: " + nom.getText());
        Label categoryLabel = new Label("Category: " + categorie.getText());
        Label referenceLabel = new Label("Reference: " + ref.getText());
        Label quantiteLabel = new Label("Quantite: " + quantite.getText());
        Label obsLabel = new Label("Observation: " + obs.getText());
        Label dateLabel = new Label("Date: " + date.getText());

        // Set the layout for the labels
        productNameLabel.setLayoutY(20.0);
        categoryLabel.setLayoutY(50.0);
        referenceLabel.setLayoutY(80.0);
        quantiteLabel.setLayoutY(110.0);
        obsLabel.setLayoutY(140.0);
        dateLabel.setLayoutY(170.0);

        // Add labels to the printable content
        printableContent.getChildren().addAll(
                productNameLabel, categoryLabel, referenceLabel,
                quantiteLabel, obsLabel, dateLabel
        );

        // Create a new printer job
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(null)) {
            // Print the printable content
            printerJob.printPage(printableContent);

            // End the print job
            printerJob.endJob();
        }
    }

    private void generatePDF() {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();

            // Add product information to the PDF
            contentStream.newLineAtOffset(100, 700); // Set the starting position
            contentStream.showText("Product ID: " + id.getText());
            contentStream.newLineAtOffset(0, -20); // Adjust the vertical position
            contentStream.showText("Product Name: " + nom.getText());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Category: " + categorie.getText());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Price: " + prix.getText());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Quantity: " + quantite.getText());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Reference: " + ref.getText());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Date: " + date.getText());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Observations: " + obs.getText());

            contentStream.endText();
            contentStream.close();

            // Save the PDF file
            document.save("product_info.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //afficher la liste des produits dans le tableau(done)

    @FXML
    void lister(ActionEvent event) throws IOException {
        try {
            loadScene(event, "/project_java/src/application/View/lister.fxml");
        } catch (Exception e) {
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
//modifier produit click sur update
@FXML
private void updateProduct(ActionEvent event) {
    try {
        // Récupérez l'ID du produit à mettre à jour
        int productId = Integer.parseInt(text_id.getText());

        // Récupérez les nouvelles valeurs depuis les champs de texte
        String newNom = text_nom.getText();
        double newPrix = Double.parseDouble(text_prix.getText());
        int newQte = Integer.parseInt(text_qte.getText());
        String newRef = text_ref.getText();
        String newObs = text_obs.getText();
        String newDateStr = text_date.getText();
        int newidfich = Integer.parseInt(text_fich.getText());

        // Récupérez l'ID de la catégorie depuis les champs de texte
        String newCateNom = text_categ.getText();
        Famille_DAO famille_DAO = new Famille_DAO();

        // Utilisez la méthode getcategidbyname pour obtenir l'ID de la catégorie
        int newCateId = famille_DAO.getCategorieIdByName(newCateNom);

        // Validez le format de la date
        if (isValidDate(newDateStr)) {
            // Parsez la chaîne de date et convertissez-la en java.sql.Date
            java.sql.Date newDate = java.sql.Date.valueOf(newDateStr);

            // Créez un nouvel objet Produit avec les nouvelles valeurs
            Produit updatedProduit = new Produit(productId, newNom, newPrix, newQte, newRef, newObs, newDate, newCateId, newidfich);

            // Utilisez la méthode existante de mise à jour dans ProduitDAO
            produitDAO.updateProduit(updatedProduit);

            // Effacez les champs après la mise à jour
            clearFields();

            // Ajoutez le message de succès
            showSuccessMessage("Product updated successfully!");
        } else {
            // Utilisez la méthode showError pour le format de date invalide
            showError("Invalid date format. Please enter a valid date.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Utilisez la méthode showError pour toute autre erreur
        showError("Error updating product. Please try again.");
    }
}


    private void clearFields() {
        // Effacez les champs de texte
        text_id.clear();
        text_categ.clear();
        text_nom.clear();
        text_prix.clear();
        text_qte.clear();
        text_ref.clear();
        text_obs.clear();
        text_date.clear();
        text_fich.clear();
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
    	
    	

    //selectionner produit (done)

    @FXML
    void produit(ActionEvent event) throws IOException {
        try {
            loadScene(event, "/project_java/src/application/View/produit.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    //rechercher sur un produit par id ou nom
    @FXML
    void search(ActionEvent event) {
        String searchTerm = text_search.getText().trim();

        if (!searchTerm.isEmpty()) {
            Produit_DAO produitDAO = new Produit_DAO();
            Produit produit = produitDAO.search(searchTerm);

            if (produit != null) {
                // Mettez à jour les champs dans l'interface graphique avec les informations du produit
                text_id.setText(String.valueOf(produit.getId_produit()));
                text_nom.setText(produit.getNom_produit());

                // Récupérez le nom de la catégorie en utilisant l'ID de la famille
                int idFamille = produit.getId_famille();
                String nomCategorie = getCategorieNameById(idFamille);
                text_categ.setText(nomCategorie);

                text_prix.setText(String.valueOf(produit.getPrix_unitaire()));
                text_qte.setText(String.valueOf(produit.getQuantite()));
                text_ref.setText(produit.getRef());
                text_obs.setText(produit.getObs());
                text_date.setText(String.valueOf(produit.getDate()));

                // Mettez à jour les champs pour id_fiche
                text_fich.setText(String.valueOf(produit.getId_fiche()));

            } else {
                // Affichez un message si le produit n'est pas trouvé
                showAlert(AlertType.INFORMATION, "Produit non trouvé", "Aucun produit trouvé pour : " + searchTerm);
            }
        } else {
            // Affichez un message si le champ de recherche est vide
            showAlert(AlertType.WARNING, "Champ de recherche vide", "Veuillez saisir un terme de recherche.");
        }
    }

    private String getCategorieNameById(int idFamille) {
        ConnexionBDD cn = new ConnexionBDD();
        try (Connection con = cn.getConnexion();
             PreparedStatement statement = con.prepareStatement("SELECT nomFamille FROM famille_des_produits WHERE idFamille = ?")) {
            statement.setInt(1, idFamille);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("nomFamille");
            }
        } catch (SQLException e) {
            // Gérez l'erreur de manière appropriée
            System.out.println("Erreur lors de la récupération du nom de la catégorie : " + e.getMessage());
        }
        // Retournez une valeur par défaut ou null en cas d'erreur
        return null;
    }


    // Méthode utilitaire pour afficher une boîte de dialogue d'alerte
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


    //selectionner stock(done)
    @FXML
    void stock(ActionEvent event) throws IOException {

        try {
            loadScene(event, "/project_java/src/application/View/stock.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //supprimer produit click sur delete
    @FXML
    void supprimer(ActionEvent event) {
        String idProduitText = text_id.getText();

        if (idProduitText != null && !idProduitText.isEmpty()) {
            int idProduit = Integer.parseInt(idProduitText);
            Produit_DAO produitDAO = new Produit_DAO();

            // Affichez une boîte de dialogue de confirmation avant de supprimer le produit
            Alert confirmation = new Alert(AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation de suppression");
            confirmation.setHeaderText("Supprimer le produit");
            confirmation.setContentText("Êtes-vous sûr de vouloir supprimer le produit ?");

            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Si l'utilisateur confirme, supprimez le produit
                produitDAO.supprimer_produit(idProduit);

                // Ajoutez ici le code pour mettre à jour votre interface ou effectuer d'autres actions nécessaires après la suppression
                clearProductDetails(); // Efface les détails du produit après la suppression
            }
        } else {
            // Gérez le cas où l'ID du produit n'est pas disponible
            showAlert(AlertType.WARNING, "ID du produit non disponible", "Impossible de supprimer le produit sans ID.");
        }
    }


    // Méthode pour effacer les détails du produit après la suppression
    private void clearProductDetails() {
        // Effacer également le champ de recherche
        text_search.clear();

        // Effacer les détails du produit
        id.setText("");
        nom.setText("");
        categorie.setText("");
        prix.setText("");
        quantite.setText("");
        ref.setText("");
        obs.setText("");
        date.setText("");
        idfiche.setText("");
    }


    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub

    }



}
