package GUI.Plateau;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controleur.JeuControleur;
import Controleur.JeuPlacementControleur;

public abstract class Plateau extends JPanel {
	protected JeuControleur controleur;
	private CasePlateau[][] map;
	
	public Plateau(JeuControleur controleur, int longueur, int largeur){
		this.controleur = controleur;
		
		map = new CasePlateau[longueur][largeur];
		setLayout(new GridLayout(longueur, largeur));
		
		for (int i = 0; i < longueur; i += 1){
			for (int j = 0; j < largeur; j += 1){
				CasePlateau bouton = new CasePlateau(i, j);
				bouton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						actionClickCase(e);
					}
				});
				
				map[i][j] = bouton;
				add(bouton);
			}
		}
	}
	
	protected abstract void actionClickCase(ActionEvent e);
	
	public abstract JeuControleur getControleur();

	public CasePlateau[][] getMap() {
		return map;
	}
}
