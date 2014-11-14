package GUI.Plateau;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import Controleur.*;
import Model.PFs;

public class PlateauPlacement extends Plateau {
	public PlateauPlacement(JeuPlacementControleur controleur, int longueur, int largeur){
		super(controleur, longueur, largeur);
	}
	
	protected void actionClickCase(ActionEvent e) {
		CasePlateau myCase = (CasePlateau) e.getSource();
		
		getControleur().placerPFs(myCase.getXPlateau(), myCase.getYPlateau());
	}
	
	public void majBoutonLabel(int oldx, int oldy, int x, int y, String text){
		getMap()[oldx][oldy].setText(oldx + " " + oldy);
		getMap()[x][y].setText(text);
	}

	public JeuPlacementControleur getControleur() {
		return (JeuPlacementControleur) controleur;
	}
}
