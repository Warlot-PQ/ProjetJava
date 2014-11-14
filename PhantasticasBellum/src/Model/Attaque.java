package Model;

import java.util.List;

public class Attaque {
	private String nom;
	private int degat;
	private int portee;
	private Matrice zone;
	private Effet effetProduit = null;
	
	public Attaque(String nom, int degat, int portee, Matrice zone, Effet effetProduit){
		this.nom = nom;
		this.degat = degat;
		this.portee = portee;
		this.zone = zone;
		this.effetProduit = effetProduit;
	}
	
	public Effet getEffetProduit() {
		return effetProduit;
	}

	public void setEffetProduit(Effet effetProduit) {
		this.effetProduit = effetProduit;
	}

	public Attaque(String nom, int degat, int portee, Matrice zone){
		this(nom, degat, portee, zone,  null);
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public Matrice getZone() {
		return zone;
	}

	public void setZone(Matrice zone) {
		this.zone = zone;
	}
}
