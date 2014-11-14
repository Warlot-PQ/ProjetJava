package GUI;

import Controleur.FenetreControleur;
import Controleur.JeuControleur;
import Controleur.JeuPlacementControleur;
import Controleur.Partie;
import GUI.Plateau.*;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.border.LineBorder;

import Model.Joueur;
import Model.PFs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
//TODO remonter les JPanel dans le père
public class JeuPlacement extends Jeu {
	JPanel panelOuest = new JPanel();
	JPanel panelEst = new JPanel();
	
	public JeuPlacement(FenetreControleur controleurParent, int longueur, int largeur, List<Joueur> listJoueurs, Joueur joueurActuel){
		super(listJoueurs, longueur, largeur);
		this.controleur = new JeuPlacementControleur(this, controleurParent);
		this.panelJoueur1 = new JoueurPlacement(getControleur(), listJoueurs.get(0));
		this.panelJoueur2 = new JoueurPlacement(getControleur(), listJoueurs.get(1));
		this.panelPlateau = new PlateauPlacement(getControleur(), longueur, largeur);
		
		setLayout(new BorderLayout(0, 0));
		
		panelOuest.setLayout(new BoxLayout(panelOuest, BoxLayout.Y_AXIS));
		panelOuest.add(new JLabel(listJoueurs.get(0).getNom()));
		
		JPanel panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout());
		panelCentre.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				majDimension();
			}
		});
		panelCentre.add(panelPlateau);
		
		panelEst.setLayout(new BoxLayout(panelEst, BoxLayout.Y_AXIS));
		panelEst.add(new JLabel(listJoueurs.get(1).getNom()));
		
		JPanel paneljoueur1Box = new JPanel();
		paneljoueur1Box.setLayout(new FlowLayout());
		paneljoueur1Box.add(panelJoueur1);
		
		JPanel paneljoueur2Box = new JPanel();
		paneljoueur2Box.setLayout(new FlowLayout());
		paneljoueur2Box.add(panelJoueur2);
		
		panelOuest.add(paneljoueur1Box);
		panelOuest.add(paneljoueur2Box);

		JPanel panelSud = new JPanel();
		panelSud.setLayout(new FlowLayout());
		JButton boutonSuivant = new JButton("Suivant");
		boutonSuivant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getControleur().suivant();
			}
		});
		panelSud.add(boutonSuivant);
		
		
		add(panelOuest, BorderLayout.WEST);
		add(panelCentre, BorderLayout.CENTER);
		add(panelEst, BorderLayout.EAST);
		add(panelSud, BorderLayout.SOUTH);
		
		if (panelJoueur1.getMonJoueur() == joueurActuel) {
			panelJoueur2.setVisible(false);
		} else {
			panelJoueur1.setVisible(false);
		}

		majDimension();
	}

	private void majDimension() {
		panelOuest.setPreferredSize(new Dimension(
				(int) (getControleur().getControleurParent().getMaVue().getWidth() * 0.25), 
				(int) (getControleur().getControleurParent().getMaVue().getHeight() * 0.25))
		);
		panelEst.setPreferredSize(new Dimension(
				(int) (getControleur().getControleurParent().getMaVue().getWidth() * 0.25), 
				(int) (getControleur().getControleurParent().getMaVue().getHeight() * 0.25))
		);
	}

	
	/******************PUBLIC GETTERS******************/
	public JeuPlacementControleur getControleur() {
		return (JeuPlacementControleur) controleur;
	}
	public JoueurPlacement getPanelJoueur1() {
		return (JoueurPlacement) panelJoueur1;
	}
	public JoueurPlacement getPanelJoueur2() {
		return (JoueurPlacement) panelJoueur2;
	}
	public PlateauPlacement getPanelPlateau() {
		return (PlateauPlacement) panelPlateau;
	}
}
