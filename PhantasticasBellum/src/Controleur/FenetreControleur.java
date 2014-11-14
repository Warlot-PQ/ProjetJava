package Controleur;

import java.util.List;

import Exception.*;
import GUI.*;
import Model.*;

public class FenetreControleur{
	private Fenetre maVue;
	private Partie maPartie;

	private static int nbJoueurConfigurer = 0;
	
	public FenetreControleur(Fenetre frameVue, Partie maPartie){
		this.maVue = frameVue;
		this.maPartie = maPartie;
	}
	
	public void initVue(){
		getMaVue().naviguer(
				new ParamJeu(this)
				);
	}

	public void continueParamJeu(int tailleEquipe, int longueurPlateau, int largeurPlateau){
		try {
			maPartie.setTailleEquipePlateau(tailleEquipe, longueurPlateau, largeurPlateau);
		} catch (ExceptionParamJeu e) {
			e.printStackTrace();
			return;
		}
		FenetreControleur.nbJoueurConfigurer = 0;
		getMaVue().naviguer(
				new ParamJoueur(
						this,
						getMaPartie().getNomJoueur()
					)
				);
	}

	public void continueParamJoueur(List<PFs> collectionPFsJoueur, boolean err){
		err = false;
		
		int tailleEquipe = collectionPFsJoueur.size();
		int tailleEquipeTotal = getMaPartie().getTailleEquipe();

		//Test equipe compete ou non
		if (tailleEquipeTotal != tailleEquipe) {
			err = true;
			return;
		};

		//Sauvegarde PFs joueurActuel
		for(PFs o : collectionPFsJoueur){
			getMaPartie().ajouterPFsJoueur(o);
		}
		
		//Joueur suivant
		FenetreControleur.nbJoueurConfigurer += 1;
		getMaPartie().joueurSuivant();
		
		//si tous les joueurs sont parametres, on passe a l'etape de placement
		if (getMaPartie().getNbJoueurs() == FenetreControleur.nbJoueurConfigurer){
			//Placer PFs
			getMaVue().naviguer(
					new JeuPlacement(
							this,
							getMaPartie().getPlateauLongueur(),
							getMaPartie().getPlateauLargeur(),
							getMaPartie().getJoueurs(),
							getMaPartie().getJoueurActuel()
						)
					);
		} else {
			//sinon on parametre le joueur suivant
			getMaVue().naviguer(
					new ParamJoueur(
							this,
							getMaPartie().getNomJoueur()
						)
					);
		}
	}
	
	public Fenetre getMaVue(){
		return maVue;
	}

	public Partie getMaPartie(){
		return maPartie;
	}
}
