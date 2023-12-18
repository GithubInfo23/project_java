package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loginController implements Initializable{
	
	
	private Stage stage;
	private Scene scene; 
	private Parent root;
	
	
	//fonctionne pour lier entre les interfaces (done)
	
	public void loadScene(ActionEvent event, String fxmlFileName) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
	        root = loader.load();
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
