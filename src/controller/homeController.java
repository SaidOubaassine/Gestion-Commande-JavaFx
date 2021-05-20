package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class homeController implements Initializable{
	@FXML private Group nvlCommande;
	@FXML private Rectangle rectnvlCommande;
	@FXML private HBox hboxHome;
	
	@FXML
	public void Changer_Color(MouseEvent event) {
		rectnvlCommande.setFill(Color.WHITE);
		nvlCommande.setTranslateY(rectnvlCommande.getY()+2);
		
	}
	@FXML
	public void Retour_Color(MouseEvent event){
		rectnvlCommande.setFill(Color.ORANGE);
		nvlCommande.setTranslateY(rectnvlCommande.getY()-2);
		}
	@FXML
	public void nouvelle_Commande(MouseEvent event) throws IOException{
	 HBox root =(HBox) FXMLLoader.load(getClass().getResource("/vue/Nouvelle_Commande.fxml"));
	 hboxHome.getChildren().setAll(root);
	} 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}


}