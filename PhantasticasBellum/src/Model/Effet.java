package Model;

public class Effet {
	private int nbTourRestant;
	private int paRetirer;
	private int pmRetirer;
	private int bouclier;
	
	public Effet(){
		
	}

	public int getNbTourRestant() {
		return nbTourRestant;
	}

	public void setNbTourRestant(int nbTourRestant) {
		this.nbTourRestant = nbTourRestant;
	}

	public int getPaRetirer() {
		return paRetirer;
	}

	public void setPaRetirer(int paRetirer) {
		this.paRetirer = paRetirer;
	}

	public int getPmRetirer() {
		return pmRetirer;
	}

	public void setPmRetirer(int pmRetirer) {
		this.pmRetirer = pmRetirer;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}
}
