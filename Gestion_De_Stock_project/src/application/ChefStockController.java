package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChefStockController{

	Stage stage;

	// Variables dyal page page ChefStock 
   
    @FXML
    private Button logoutBotton;
    @FXML
    private Label nbrDemmande;
    @FXML
    private Label nbrProduitDispo;
    @FXML
    private Button produitButton;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button stockButton;
    @FXML
    private Label totalVente;

    //variable de Produit :
    
    @FXML
    private Label IdProduit;

    @FXML
    private AnchorPane ImprimerBotton;

    @FXML
    private Button ajouterProduit;

    @FXML
    private TextField barreRechercheProduit;

    @FXML
    private Label categorieProduit;

    @FXML
    private ImageView image;

    @FXML
    private Button imprimerProduit;

    @FXML
    private Button listProduit;

    @FXML
    private Button modifierProduit;

    @FXML
    private Label nomProduit;

    @FXML
    private Label prixProduit;

    @FXML
    private Label quantite;

    @FXML
    private Button ruptureProduit;

    @FXML
    private Button supprimerProduit;
    
    // Variables dyal page page ProduitAjout

    @FXML
    private TextField CategorieAjout;

    @FXML
    private TextField OBSAjout;

    @FXML
    private TextField RefAjout;

    @FXML
    private AnchorPane addProduit_ImageView;

    @FXML
    private TextField dateAjout;

    @FXML
    private Button enregistrerProduit;

    @FXML
    private Button importerProduit;

    @FXML
    private TextField nomAjout;

    @FXML
    private TextField prixAjout;

    @FXML
    private TextField quantitéAjout;

    // Variables dyal page page ProduitList

    @FXML
    private TableColumn<?, ?> List_Produit_Date;

    @FXML
    private TableColumn<?, ?> List_Produit_ID;

    @FXML
    private TableColumn<?, ?> List_Produit_Obs;

    @FXML
    private TableColumn<?, ?> List_Produit_Ref;

    @FXML
    private TableColumn<?, ?> List_Produit_categorie;

    @FXML
    private TableColumn<?, ?> List_Produit_nom;

    @FXML
    private TableColumn<?, ?> List_Produit_prix;

    @FXML
    private TableColumn<?, ?> List_Produit_quantite;
    
 // Variables dyal page page Stock
    @FXML
    private Button FournisseurBotton;

    @FXML
    private Label Id_Stock;

    @FXML
    private Label TOP;

    @FXML
    private Button ajouterStock;

    @FXML
    private TextField barreRechercheStock;

    @FXML
    private Label date_Stock;

    @FXML
    private Label design_Stock;

    @FXML
    private Button entropotButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button imprimerProduitRupture;

    @FXML
    private Button imprimerStock;

    @FXML
    private Button listStock;

    @FXML
    private Button modifierStock;

    @FXML
    private Label mondadd_Stock;

    @FXML
    private Label obs_Stock;

    @FXML
    private Label pudadd_Stock;

    @FXML
    private Label qut_stock_Stock;

    @FXML
    private Button supprimerStock;

    @FXML
    private Label u_m_Stock;
    
 // Variables dyal page page StockAjout

    @FXML
    private TextField designAjout;

    @FXML
    private Button enregistrerStock;

    @FXML
    private TextField mondaddAjout;

    @FXML
    private TextField obsAjout;

    @FXML
    private TextField pudaddAjout;

    @FXML
    private TextField qut_stockAjout;

    @FXML
    private AnchorPane side_Anchorpane;

    @FXML
    private TextField u_mAjout;
    
 // Variables dyal page page StockListe
    
    @FXML
    private TableColumn<?, ?> List_Stock_ID;

    @FXML
    private TableColumn<?, ?> List_Stock_date;

    @FXML
    private TableColumn<?, ?> List_Stock_design;

    @FXML
    private TableColumn<?, ?> List_Stock_mondadd;

    @FXML
    private TableColumn<?, ?> List_Stock_obs;

    @FXML
    private TableColumn<?, ?> List_Stock_pudadd;

    @FXML
    private TableColumn<?, ?> List_Stock_qutt_stock;

    @FXML
    private TableColumn<?, ?> List_Stock_u_m;

 // Variables dyal page page Fournisseur

    @FXML
    private TextField BarreRecherche;

    @FXML
    private TextField Date_foun_Ajout;

    @FXML
    private TableColumn<?, ?> List_Fournisseur_Date;

    @FXML
    private TableColumn<?, ?> List_Fournisseur_ID;

    @FXML
    private TableColumn<?, ?> List_Fournisseur_Name;

    @FXML
    private TextField Name_foun_Ajout;

    @FXML
    private Button SupprimerBotton;

    @FXML
    private Button enregistrerFournisseur;

 
    
	public void loadScene (ActionEvent event , String fxmlFileName) {
		    LogInController loginController = new LogInController();
	        loginController.loadScene(event, fxmlFileName);
	   }

	
	public void logout(ActionEvent event) throws IOException {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout");
		alert.setContentText("do you want  to save before exiting?:");
		if (alert.showAndWait().get() == ButtonType.OK) {
	
		// for a normal logout without alert
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("You successfully Logged out");
//			
			loadScene(event,"LogIn.fxml");
		}
	}

	public void ouvrirHome(ActionEvent event) throws IOException {
		
		try{
					loadScene( event ,"ChefStock.fxml");
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}
	
	public void ouvrirProduit(ActionEvent event) throws IOException {
			
			try{
				        loadScene( event ,"Produit.fxml");
				}
					
			catch(Exception e){
					System.out.println(e);	
					}
		}
	
	public void ouvrirStock(ActionEvent event) throws IOException {
		
		try{
			 		loadScene( event ,"Stock.fxml");
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}
	
	public void ouvrirEntrepot(ActionEvent event) throws IOException {
		
		try{
					loadScene( event ,"Entropot.fxml");
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}

	public void ouvrirAjoutProduit(ActionEvent event) throws IOException {
		
		try{
					
					loadScene( event ,"ProduitAjout.fxml");
					
					/*Hna khas 9ebl mat2afficha page ibanou les valeurs par defaux dyal
					 *  chi produit lli kayn f base de donnée anaghir katbahoum ghir hakkak 
					 */
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}
	public void ouvrirListProduit(ActionEvent event) throws IOException {
		
		try{
					loadScene( event ,"ProduitListe.fxml");
		
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}
	
	public void ouvrirAjoutStock(ActionEvent event) throws IOException {
		
		try{
					
					loadScene( event ,"StockAjout.fxml");
					
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}
	public void ouvrirListStock(ActionEvent event) throws IOException {
		
		try{
					loadScene( event ,"StockListe.fxml");
		
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
		
	}
	
	public void ouvrirFournisseur(ActionEvent event) throws IOException {
			
			try{
						loadScene( event ,"Fournisseur.fxml");
			
				}
					
			catch(Exception e){
					System.out.println(e);	
					}
		
	}

	
    public void AjoutProduit(ActionEvent event) throws IOException {
		
		try{
			
			// si botton "enregistrerProduit" est activer khasna n ajoutiw produit l base de donnée o n3awdo affichiw produit ajouter avec succer
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}
    
	public void SupprimerProduit(ActionEvent event) throws IOException {
		
		try{
			
			// si boutthon "SupprimerBotton" est activer on fait quoi 
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}
	
	
	public void ProduitEnRupture(ActionEvent event) throws IOException {
		
		try{
			
			// si le boutton "ruptureBotton" est activer qui ce qu'on fait 
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}
	
	
	public void Imprimer(ActionEvent event) throws IOException {
		
		try{
			
			// pour imprimer les information d'un produit definie 
			//utilisons variable boutthon "ImprimerBotton"stock 
			
			/* hna ila kan momkin ndirou fonction lli 3la hsab botton t9dr soit t2afficher fiche 
			produit olla fiche stock olla fiche lli fiha produit en rupture si non khasna nzidou 2 fonction dyal Imprimer*/ 
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				
				}
	}
	
	public void CalculeTotalVente(ActionEvent event) throws IOException {
		
		try{
			
			// Ici on apres le calcule du total du vente du jour en va changer la valeur du variable "totalVente" avec resultat obtenue 
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}

	public void NombreDeDemmandes  (ActionEvent event) throws IOException {
		
		try{

			/* Hadi fach kancliquiw 3la Noubre botton "NombreDeDemmandes" khas i3tina ngeriw les demande ghaydina interface Fournisseur  */
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}
public void RechercherProduit(ActionEvent event) throws IOException {
	
	 System.out.println("chercher button clicked!");
		
		try{
			
			/* Hadi fach kandirou recherche 3la chi produit khas nakhdo contenue dyal recherche o n9lbou f base de donnée variable lli st3ml l barre recherche "BarreRecherche" 
			 * o ijbd les infos mn bd o ihethoum f les labels suivant image ,id , categorie , nom ,quantite  lli kaynin f pagr Produit.fxml 
			 *  ( si non ila mal9ahch i3mrhoum b des X olla nzidou wahd label lli kayt2afficha fiha message d produit introuvable)
			 * */
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}


public void AjoutStock(ActionEvent event) throws IOException {
	
	try{
		
		// si botton "enregistrerStock" est activer khasna n ajoutiw produit l base de donnée o n3awdo affichiw produit ajouter avec succer
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
}
public void SupprimerStock(ActionEvent event) throws IOException {
	
	try{
		
		
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
}

public void RechercherStock(ActionEvent event) throws IOException {
	
	 System.out.println("chercher button clicked!");
		
		try{
			// Nafs principe dyal recherche Produit 
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
	}

public void AjoutFournisseur(ActionEvent event) throws IOException {
	
	try{
		
		
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
}

public void ModifierProduit(ActionEvent event) throws IOException {
	
	try{
		
		
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
}

public void ModifierStock(ActionEvent event) throws IOException {
		
		try{
			
			
			}
				
		catch(Exception e){
				System.out.println(e);	
				}
}
public void importerImage(ActionEvent event) throws IOException {
	
	try{
		
		
		}
			
	catch(Exception e){
			System.out.println(e);	
			}
}



}