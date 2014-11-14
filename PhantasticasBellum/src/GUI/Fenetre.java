package GUI;
/**
 * Savoir si tous les joueurs sont configures => tester joueurActuel et joueurDeTete (a ajouter)
 * 
 * Passer le controleur du parent en parametre en non le parent
 */


import java.awt.Component;
import java.util.*;

import javax.swing.*;

import Controleur.*;
import Exception.ExceptionParamJeu;
import Model.PFs;


public class Fenetre  extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Partie maPartie;
	private FenetreControleur controleur;
	
	public Fenetre(Partie maPartie){
		super("PhantasticasBellum");
		setLocale(Locale.FRENCH);
		//setResizable(false);
		
		this.maPartie = maPartie;
		this.controleur = new FenetreControleur(this, maPartie);
		
		controleur.initVue();

		this.setSize(850, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void naviguer(JPanel panelNew){
		this.getContentPane().removeAll();
		this.getContentPane().revalidate();
		this.getContentPane().add(panelNew);
	}


	/******************PUBLIC GETTERS******************/
	public Partie getMaPartie() {
		return maPartie;
	}
	public FenetreControleur getControleur() {
		return controleur;
	}
}
