package model;

import java.sql.Date;
import java.time.LocalDate;

public class commande {
  private String nomProduit;
  private float quntite;
  private float prixUnit;
  private String adresse;
  private Date dateCommande;
  private int idClient;
  private String status;
  private Date date;
  
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public float getPrixUnit() {
	return prixUnit;
}
public void setPrixUnit(float prixUnit) {
	this.prixUnit = prixUnit;
}
public String getNomProduit() {
	return nomProduit;
}
public void setNomProduit(String nomProduit) {
	this.nomProduit = nomProduit;
}
public float getQuntite() {
	return quntite;
}
public void setQuntite(float quntite) {
	this.quntite = quntite;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public Date getDateCommande() {
	return dateCommande;
}
public void setDateCommande(Date dateCommande) {
	this.dateCommande = dateCommande;
}
public int getIdClient() {
	return idClient;
}
public void setIdClient(int idClient) {
	this.idClient = idClient;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

  
}
