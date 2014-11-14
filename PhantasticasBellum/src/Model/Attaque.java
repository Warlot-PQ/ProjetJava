package Model;

import java.util.List;

public class Attaque {
	private String Nom;
	private int degat;
	private int portee;
	private Matrice zone;
	
	public Attaque(){
		
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
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
