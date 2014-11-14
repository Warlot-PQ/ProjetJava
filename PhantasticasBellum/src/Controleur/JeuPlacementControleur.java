package Controleur;

import GUI.Fenetre;
import GUI.JeuPlacement;
import GUI.JoueurPlacement;
import Model.PFs;
import Model.Position;

public class JeuPlacementControleur extends JeuControleur{
	public JeuPlacementControleur(JeuPlacement maVue, FenetreControleur controleurParent){
		super(maVue, controleurParent);
	}

	public void selectionnerPFs(PFs o){
		getMaPartie().setPFsActif(o);
	}
	
	public void placerPFs(int x, int y){
		if (getMaPartie().getPFsActif() == null) return;
		JoueurPlacement panelJoueurActuel = null;
		
		if (getMaVue().getPanelJoueur1().getMonJoueur() == getMaPartie().getJoueurActuel()){
			panelJoueurActuel = getMaVue().getPanelJoueur1();
		} else {
			panelJoueurActuel = getMaVue().getPanelJoueur2();
		}
		
		Position oldPosition = getMaPartie().getPFsActif().getPosition();
		//Si position non initialise (vide)
		int oldx = 0, oldy = 0;
		if (oldPosition.equals(new Position())){
			oldx = x;
			oldy = y;
		} else {
			oldx = oldPosition.getX();
			oldy = oldPosition.getY();
		}
		if (getMaPartie().setPositionPFs(new Position(x, y)) == false){
			return;
		}
		
		panelJoueurActuel.indiquerPFsPlace(
				getMaPartie().getPFsActif()
				);
		getMaVue().getPanelPlateau().majBoutonLabel(
				oldx, 
				oldy,
				x,
				y,
				getMaPartie().getPFsActif().getClasse().substring(0,  1)
				);
	}

	public void suivant(){
		System.out.println("Placement des PFs du joueur suivant, ca vient ca vient.");
		System.out.println("Ne lance pas la compilation avant d'avoir coder !");
	}
	
	public JeuPlacement getMaVue(){
		return (JeuPlacement) maVue;
	}
}
