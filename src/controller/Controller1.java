package controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import connecte.bdconnecte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import model.client;
import model.commande;



public class Controller1  implements  Initializable{
	
	@FXML private TextField txtN;
	@FXML private TextField txtE;
	@FXML private TextField txtT;
    @FXML private RadioButton rdbtnHomme;
    @FXML private RadioButton rdbtnFemme;
    @FXML private TextField txtQuantite;
	@FXML private TextField txtprixUnit;
	@FXML private TextField txtAdresse;
	public void insertData(MouseEvent event) {
		String nom=txtN.getText();
		String email=txtE.getText();
		String telephone=txtT.getText();
		
		client cln= new client();
		cln.setNom(nom);
		cln.setEmail(email);
		int tele=Integer.parseInt(telephone);
		cln.setNumTel(tele);
		if(rdbtnHomme.isSelected()) {
			cln.setGenre("H");
		}
		else if (rdbtnFemme.isSelected()) {
			cln.setGenre("F");
		}
		
		
		
		int status =bdconnecte.save(cln);
		if(status>0) {
			Alert alert =new Alert(AlertType.INFORMATION);
			alert.setTitle("Add Client !");
			alert.setHeaderText("Information");
			alert.setContentText("Client bien Ajouter");
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert =new Alert(AlertType.INFORMATION);
			alert.setTitle("Add Client !");
			alert.setHeaderText("Information");
			alert.setContentText("Client Non Ajouter");
			alert.showAndWait();
		}	
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup groupe = new ToggleGroup();
		rdbtnHomme.setToggleGroup(groupe);
		rdbtnFemme.setToggleGroup(groupe);
		
	}

}
