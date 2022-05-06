package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class controllerLogin implements Initializable{

	@FXML private TextField nom;
	@FXML private PasswordField pass;
	@FXML private GridPane login;
	@FXML
	public void login(ActionEvent event) throws SQLException{
		Connection con=bdconnecte.connecte();
		PreparedStatement stat=null;
		ResultSet rs=null;
		String sql="SELECT * FROM users WHERE nom = ? AND password= ?";
		try {
			stat=con.prepareStatement(sql);
			stat.setString(1, nom.getText().toString());
			stat.setString(2, pass.getText().toString());
			rs=stat.executeQuery();
			if(rs.next()) {
				Node node=(Node) event.getSource();
				Stage stage=(Stage) node.getScene().getWindow();
				stage.close();
				Scene scene =new Scene(FXMLLoader.load(getClass().getResource("/vue/Home.fxml")));
				stage.setScene(scene);
				stage.show();
			}
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	@FXML
	public void creerCompte(MouseEvent event) throws IOException {
		 GridPane root =(GridPane) FXMLLoader.load(getClass().getResource("/vue/creercompte.fxml"));
		 login.getChildren().setAll(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
