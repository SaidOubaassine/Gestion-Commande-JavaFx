package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controllerCommandes implements Initializable{

	@FXML
	public void Commandes(ActionEvent event) throws IOException{
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		stage.close();
		Scene scene =new Scene(FXMLLoader.load(getClass().getResource("/vue/Modifier.fxml")));
		stage.setScene(scene);
		stage.show();
	} 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}