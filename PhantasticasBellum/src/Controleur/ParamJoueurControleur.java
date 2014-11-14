package Controleur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import GUI.LayeredPanePFs;
import GUI.ParamJoueur;
import Model.PFs;

public class ParamJoueurControleur {
	protected ParamJoueur maVue;
	private FenetreControleur controleurParent = null;

	private List<PFs> collectionPFs = new ArrayList<PFs>();
	private int tailleEquipeTotal = 1;
	private int tailleEquipe = 0;
	
	public ParamJoueurControleur(ParamJoueur maVue, FenetreControleur controleurParent){
		this.maVue = maVue;
		this.controleurParent = controleurParent;
		this.collectionPFs = getMaPartie().getPFsDisponible();
		this.tailleEquipeTotal = getMaPartie().getTailleEquipe();
	}

	public void ajouterPFs(PFs o){
		if (tailleEquipeTotal <= tailleEquipe) return;
		
		tailleEquipe += 1;
		getMaVue().majLabelPlaceRestante(tailleEquipeTotal, tailleEquipe);
		
		LayeredPanePFs monLayeredPanePFs = new LayeredPanePFs(this, o);
		monLayeredPanePFs.ajouterBoutonSup();
		
		getMaVue().ajouterPanelPFsChoisi(monLayeredPanePFs);	
	}

	public void supprimerPFs(LayeredPanePFs o){
		tailleEquipe -= 1;
		getMaVue().majLabelPlaceRestante(tailleEquipeTotal, tailleEquipe);
		
		getMaVue().suprimerPanelPFsChoisi(o);
		
		getMaVue().repaint();
	}
	
	public void suivant(){
		//recherche les PFs seclectionne
		List<PFs> collectionPFsJoueur = new ArrayList<PFs>();
		
		for (int i = 0; i < getMaVue().getPanelPFsChoisi().getComponents().length; i += 1){
			LayeredPanePFs tempPanel = (LayeredPanePFs) getMaVue().getPanelPFsChoisi().getComponents()[i];

			collectionPFsJoueur.add(tempPanel.getPFs());
		}
		
		boolean err = false; 
		getControleurParent().continueParamJoueur(collectionPFsJoueur, err);
		//TODO Lever une exception sur changeGUIplacerPFs si erreur
		if (err){
			JOptionPane.showMessageDialog(getMaVue(), "Equipe non pleine.");
		}
	}
	
	
	
	
	public ParamJoueur getMaVue(){
		return maVue;
	}

	public FenetreControleur getControleurParent() {
		return controleurParent;
	}
	
	public Partie getMaPartie() {
		return getControleurParent().getMaPartie();
	}

	public List<PFs> getCollectionPFs() {
		return collectionPFs;
	}
}
