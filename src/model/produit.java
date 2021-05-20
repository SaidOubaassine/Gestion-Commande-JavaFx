package model;

public class produit {

	private String nomProduit;
	private double prixProduit;
	public produit() {
		super();
	}
	public produit(String nomProduit, double prixProduit) {
		super();
		this.nomProduit=nomProduit;
		this.prixProduit=prixProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}	
}