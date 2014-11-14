package GUI;

import java.util.List;

import javax.swing.JPanel;

import Controleur.*;
import GUI.Plateau.*;
import Model.*;

public abstract class Jeu extends JPanel{
	protected JeuControleur controleur = null;
	
	protected JeuJoueur panelJoueur1 = null;
	protected JeuJoueur panelJoueur2 = null;
	protected Plateau panelPlateau = null;
	
	public Jeu(List<Joueur> listJoueurs, int longueur, int largeur){
		
	}

	public abstract JeuControleur getControleur();
	public abstract JeuJoueur getPanelJoueur1();
	public abstract JeuJoueur getPanelJoueur2();
	public abstract Plateau getPanelPlateau();
}
