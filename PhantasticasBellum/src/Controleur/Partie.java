package Controleur;

import Model.*;
import Exception.ExceptionParamJeu;
import GUI.Fenetre;

import java.util.*;

import Model.PFs;
import Personnages.*;

/**
 * La classe Partie est le controleur du systeme, elle est le pivot etre le model et la vue
 * @author Scrat
 *
 */

public class Partie {
	/******************ATTRIBUT******************/
	/**
	 * Collection PFs disponible lors de la selection des equipes
	 */
	private List<PFs> PFsDisponible = new ArrayList<PFs>();
	
	/**
	 * Taille des equipes
	 */
	private int tailleEquipe = 1;
	
	/**
	 * Taille du plateau de jeu
	 */
	private int plateauLongueur = 3;
	private int plateauLargeur = 3;
	
	/**
	 * Collection de joueurs
	 */
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	
	/**
	 * Iterateur sur la collection de joueurs
	 */
	private Iterator<Joueur> joueurIterateur;
	
	/**
	 * Joueur actuellement en jeu
	 */
	private Joueur joueurActuel = null;

	
	/******************CONSTRUCTEUR******************/
	/**
	 * Constructeur de la classe Partie
	 */
	public Partie(){
		Fenetre maFenetre = new Fenetre(this);
		initJoueurs();
		initPFsDisponible();
	}
	
	
	/******************INITIALISATION******************/
	/**
	 * Initialtion des joueurs du jeu
	 */
	private void initJoueurs(){
		getJoueurs().add(new Joueur("Joueur 1"));
		getJoueurs().add(new Joueur("Joueur 2"));
		joueurIterateur = getJoueurs().iterator();
		//Place l'iterateur sur le premier joueur
		setJoueurActuel(joueurIterateur.next());
	}
	
	
	/**
	 * Initialisation des PFs disponible dans le jeu
	 */
	private void initPFsDisponible(){
		getPFsDisponible().add(new Magicien());
		getPFsDisponible().add(new Guerrier());
	}
	
	
	/**
	 * Determination du joueur qui jouera en premier(=composera son equipe)
	 */
	private void determinerOrdre(){
		//TODO determinerOrdre() affecter joueurActuel
	}
	
	
	/******************JOUEUR******************/
	/**
	 * Renvoi la collection de PFs du joueur actuel
	 * @return collection de PFs
	 */
	public List<PFs> listerEquipeJoueur(){
		return getJoueurActuel().listerEquipe();
	}
	
	/**
	 * Renvoi le nom de PFs du joueur actuel
	 * @return nom du joueur
	 */
	public String getNomJoueur(){
		return getJoueurActuel().getNom();
	}
	
	/**
	 * Ajoute le PFs en parametre au joueur actuel
	 * @param personnage PFs a ajouter au joueur actuel
	 */
	public void ajouterPFsJoueur(PFs personnage){
		getJoueurActuel().ajouterPFs((PFs) personnage.clone());
	}
	
	/**
	 * Passe au joueur suivant, disponible dans l'attibut joueurActuel
	 */
	public void joueurSuivant(){
		if (getJoueurIterateur().hasNext()) {
			setJoueurActuel(getJoueurIterateur().next());
		} else {
			setJoueurActuel(joueurs.get(0));
		}
	}
	
	/**
	 * Fixe le PFs actif du joueurActuel
	 */
	public void setPFsActif(PFs o){
		getJoueurActuel().setPFsActif(o);
		//getJoueurActuel().getEquipe().setPFsActif(o);
	}

	/**
	 * Donne le PFs actif du joueurActuel
	 * @param PFs actif
	 */
	public PFs getPFsActif(){
		return getJoueurActuel().getPFsActif();
	}
	
	public boolean setPositionPFs(Position maPosition){
		for(Joueur o : getJoueurs()){
			for(PFs obj : o.getEquipe().getPFsEquipe()){
				if (obj.getPosition().equals(maPosition)){
					//TODO lever une exception si place deja occupe
					return false;
				}
			}
		}
		getJoueurActuel().getEquipe().setPositionPFs(maPosition);
		return true;
	}
	
	
//	public boolean verifierAjoutPFs(int numJoueur, PFs personnage){
//		
//		return false;
//	}
//	
//	public boolean verifierPlacementPFs(Position position){
//
//		return false;
//	}
//	
//	public void passerTour(){
//		
//	}
//	
//	public Matrice listerDeplacement(){
//		
//		return null;
//	}
//	
//	public void deplacerPFs(Position position){
//		
//	}
//	
//	public List<Attaque> listerAttaque(){
//	
//		return null;
//	}
//	
//	//@param : dimension 1 -> axe x, dimension 2 -> axe y
//	public List<PFs> listerPFsAttaquable(List<List<Position>> position){
//		
//		return null;
//	}
//	
//	public void attaquerPFs(PFs personnage, Attaque attaque){
//		
//	}

	
	/******************PUBLIC SETTERS******************/
	/**
	 * Fixe les tailles d'equipes et de plateau, leve une exception si erreur (taille negative, plateau trop petit)
	 * @param tailleEquipe taille de l'equipe
	 * @param taillePlateauLongueur longueur du plateau
	 * @param taillePlateauLargeur largeur du plateau
	 * @throws ExceptionParamJeu exception taille negative ou plateau trop petit
	 */
	public void setTailleEquipePlateau(int tailleEquipe, int taillePlateauLongueur, int taillePlateauLargeur) throws ExceptionParamJeu{
		if (tailleEquipe <= 0 || taillePlateauLongueur <= 0 || taillePlateauLargeur <= 0){
			throw new ExceptionParamJeu(ExceptionParamJeu.error.NEGATIVE);
		}
		if ((taillePlateauLongueur * taillePlateauLargeur) < (tailleEquipe * 2)){
			throw new ExceptionParamJeu(ExceptionParamJeu.error.PLATEAU);
		}
		setTailleEquipe(tailleEquipe);
		setPlateauLongueur(taillePlateauLongueur);
		setPlateauLargeur(taillePlateauLargeur);
	}
	
	
	/******************PRIVATE SETTERS******************/
	private void setPFsDisponible(List<PFs> pFsDisponible) {
		PFsDisponible = pFsDisponible;
	}
	private void setTailleEquipe(int tailleEquipe) {
		this.tailleEquipe = tailleEquipe;
	}
	private void setPlateauLongueur(int plateauLongueur) {
		this.plateauLongueur = plateauLongueur;
	}
	private void setPlateauLargeur(int plateauLargeur) {
		this.plateauLargeur = plateauLargeur;
	}
	private void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	private void setJoueurIterateur(Iterator<Joueur> joueurIterateur) {
		this.joueurIterateur = joueurIterateur;
	}
	private void setJoueurActuel(Joueur joueurActuel) {
		this.joueurActuel = joueurActuel;
	}
	
	
	/******************PUBLIC GETTERS******************/
	public List<PFs> getPFsDisponible() {
		return PFsDisponible;
	}
	public int getTailleEquipe() {
		return tailleEquipe;
	}
	public int getPlateauLongueur() {
		return plateauLongueur;
	}
	public int getPlateauLargeur() {
		return plateauLargeur;
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public int getNbJoueurs(){
		return getJoueurs().size();
	}
	public Joueur getJoueurActuel() {
		return joueurActuel;
	}
	
	
	/******************PRIVATE GETTERS******************/
	private Iterator<Joueur> getJoueurIterateur() {
		return joueurIterateur;
	}
}