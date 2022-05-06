package controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import connecte.bdconnecte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.commande;

public class controller_Chercher_commande implements Initializable{

	@FXML private Pane pane1;
	@FXML private Pane pane2;
	@FXML private Pane pane3;
	int idc1=0,idc2=0,idc3=0;
	
	
	@FXML
	public void Retour(MouseEvent event) throws IOException{
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		stage.close();
		Scene scene =new Scene(FXMLLoader.load(getClass().getResource("/vue/Home.fxml")));
		stage.setScene(scene);
		stage.show();
	} 
	@FXML
	public void Chercher1(ActionEvent event) throws IOException{
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		stage.close();
		Scene scene =new Scene(FXMLLoader.load(getClass().getResource("/vue/Chercher1.fxml")));
		stage.setScene(scene);
		stage.show();
	} 
	public void Chercher2(ActionEvent event) throws IOException{
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		stage.close();
		Scene scene =new Scene(FXMLLoader.load(getClass().getResource("/vue/Chercher2.fxml")));
		stage.setScene(scene);
		stage.show();
	} 
	
	public ObservableList<commande> listt=FXCollections.observableArrayList();
	public ObservableList<commande> list1=FXCollections.observableArrayList();
	public ObservableList<commande> list2=FXCollections.observableArrayList();
	public ObservableList<commande> list3=FXCollections.observableArrayList();
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection con = bdconnecte.connecte();
			String sql="SELECT idcommande, nom, dateCommande, prixUnit ,status, quantite, commande.idClient, commande.nomProduit FROM commande, client, produit WHERE client.idClient=commande.idClient and commande.nomProduit=produit.nomProduit";
			PreparedStatement stat=con.prepareStatement(sql);
			ResultSet rs=stat.executeQuery();
			int  i=0, j=0;
			while(rs.next()) { 
				listt.add(new commande(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6), rs.getInt(7)));
			    if(listt.size()==1) idc1=rs.getInt(7);
				else if(idc1!=rs.getInt(7) && i!=1) { idc2=rs.getInt(7); i++;}
				else if (idc1!=rs.getInt(7) && idc2!=rs.getInt(7) && j!=1) { idc3=rs.getInt(7); j++;}
			    
			    
				if(idc1==rs.getInt(7) && idc1!=0) {
					list1.add(new commande(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6), rs.getInt(7)));
				}else if(idc2==rs.getInt(7) && idc2!=0) {
					list2.add(new commande(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6), rs.getInt(7)));
				}else if(idc3==rs.getInt(7) && idc3!=0) {
					list3.add(new commande(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6), rs.getInt(7)));
				}
			}
			if(idc1!=0) {
			try {
				Connection con1 = bdconnecte.connecte();
				String sql1="SELECT idcommande, nom, dateCommande, prixUnit ,status, quantite, commande.idClient, commande.nomProduit FROM commande, client, produit WHERE client.idClient=commande.idClient and commande.nomProduit=produit.nomProduit and commande.idClient="+idc1;
				PreparedStatement stat1=con1.prepareStatement(sql1);
				ResultSet rs1=stat1.executeQuery();
			    int y1=0,prix1=0;
				while(rs1.next()) {
					Text text1=new Text("Commande #"+rs1.getInt(1)+" "+rs1.getString(2));
					text1.setTranslateY(20);
					Text text2=new Text(rs1.getInt(6)+"*"+rs1.getString(8));
					text2.setTranslateY(60+y1);
					y1+=20;
					prix1+=rs1.getInt(4);
					
					
					pane1.getChildren().add(text1);
					pane1.getChildren().add(text2);
					
					Text dateCommmande =new Text(rs1.getString(3));
					dateCommmande.setTranslateY(80);
					pane1.getChildren().add(dateCommmande);
						
					
				}
				Text text3=new Text(prix1+" DH");
				text3.setTranslateY(40);
				pane1.getChildren().add(text3);
				Text status=new Text("En cours");
				status.setTranslateY(100);
				pane1.getChildren().add(status);
				con1.close();
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
			if(idc2!=0) {
			try {
				Connection con2 = bdconnecte.connecte();
				String sql2="SELECT idcommande, nom, dateCommande, prixUnit ,status, quantite, commande.idClient, commande.nomProduit FROM commande, client, produit WHERE client.idClient=commande.idClient and commande.nomProduit=produit.nomProduit and commande.idClient="+idc2;
				PreparedStatement stat2=con2.prepareStatement(sql2);
				ResultSet rs2=stat2.executeQuery();
			    int y2=0,prix2=0;
				while(rs2.next()) {
					Text text4=new Text("Commande #"+rs2.getInt(1)+" "+rs2.getString(2));
					text4.setTranslateY(20);
					Text text5=new Text(rs2.getInt(6)+"*"+rs2.getString(8));
					text5.setTranslateY(60+y2);
					y2+=20;
					prix2+=rs2.getInt(4);
					
					
					pane2.getChildren().add(text4);
					pane2.getChildren().add(text5);
					Text dateCommmande =new Text(rs2.getString(3));
					dateCommmande.setTranslateY(80);
					pane2.getChildren().add(dateCommmande);
					
						
					
				}
				Text text6=new Text(prix2+" DH");
				text6.setTranslateY(40);
				pane2.getChildren().add(text6);
				Text status=new Text("En cours");
				status.setTranslateY(100);
				pane2.getChildren().add(status);
				con2.close();
			}catch(Exception e) {
				e.printStackTrace(); 
			}
			}
		if(idc3!=0) {	
			try {
				Connection con3 = bdconnecte.connecte();
				String sql3="SELECT idcommande, nom, dateCommande, prixUnit ,status, quantite, commande.idClient, commande.nomProduit FROM commande, client, produit WHERE client.idClient=commande.idClient and commande.nomProduit=produit.nomProduit and commande.idClient="+idc3;
				PreparedStatement stat3=con3.prepareStatement(sql3);
				ResultSet rs3=stat3.executeQuery();
			    int y3=0,prix3=0;
				while(rs3.next()) {
					Text text7=new Text("Commande #"+rs3.getInt(1)+" "+rs3.getString(2));
					text7.setTranslateY(20);
					Text text8=new Text(rs3.getInt(6)+"*"+rs3.getString(8));
					text8.setTranslateY(60+y3);
					y3+=20;
					prix3+=rs3.getInt(4);
					
					
					pane3.getChildren().add(text7);
					pane3.getChildren().add(text8);
					
					
					Text dateCommmande =new Text(rs3.getString(3));
					dateCommmande.setTranslateY(80);
					pane3.getChildren().add(dateCommmande);
					
						
					
				}
				Text text9=new Text(prix3+" DH");
				text9.setTranslateY(40);
				pane3.getChildren().add(text9);
				Text status=new Text("En cours");
				status.setTranslateY(100);
				pane3.getChildren().add(status);
				con3.close();
			}catch(Exception e) {
				e.printStackTrace(); 
			}	
		}
		}catch(Exception e) {
		e.printStackTrace(); 
	}
}
	
	
}