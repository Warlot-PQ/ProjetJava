package Controleur;

import GUI.*;

public abstract class JeuControleur {
	protected Jeu maVue;
	private FenetreControleur controleurParent = null;
	
	public JeuControleur(Jeu maVue, FenetreControleur controleurParent){
		this.maVue = maVue;
		this.controleurParent = controleurParent;
	}

	public abstract Jeu getMaVue();

	public FenetreControleur getControleurParent() {
		return controleurParent;
	}
	
	public Partie getMaPartie() {
		return controleurParent.getMaPartie();
	}
}
