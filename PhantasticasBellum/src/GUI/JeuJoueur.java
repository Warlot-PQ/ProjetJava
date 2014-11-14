package GUI;

import javax.swing.JPanel;

import Controleur.JeuControleur;
import Model.Joueur;

public abstract class JeuJoueur extends JPanel{
	protected JeuControleur controleur;
	private Joueur monJoueur;

	public JeuJoueur(JeuControleur controleur, Joueur monJoueur){
		this.controleur = controleur;
		this.monJoueur = monJoueur;
	}

	public abstract JeuControleur getControleur();
	
	public Joueur getMonJoueur() {
		return monJoueur;
	}
}
