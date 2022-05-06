package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import connecte.bdconnecte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class creerCompte implements Initializable{

	@FXML private TextField txtF;
	@FXML private PasswordField passF;
	@FXML private GridPane login;
	@FXML private Label connecte;
	@FXML private Label nonconnecte;
	@FXML
	public void creerCompte(ActionEvent event) {
		int n=0;
		try{
			String sql="INSERT INTO users (nom, password) VALUES(?,?)";
			Connection con=bdconnecte.connecte();
			PreparedStatement stat;
			stat=con.prepareStatement(sql);
			stat.setString(1, txtF.getText());
			stat.setString(2, passF.getText());
			n=stat.executeUpdate();
			con.close();
			if(n>0) {
				Node node=(Node) event.getSource();
				Stage stage=(Stage) node.getScene().getWindow();
				stage.close();
				Scene scene =new Scene(FXMLLoader.load(getClass().getResource("/vue/loggin.fxml")));
				stage.setScene(scene);
				stage.show();
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
