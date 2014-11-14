package Model;

import java.util.List;
/**
 * 
 * La classe Joueur represente virtuellement le participant, chaque joueur est caracterise par son nom et son equipe
 * @author Scrat
 *
 */

public class Joueur {
	/******************ATTRIBUT******************/
	/**
	 * Nom du joueur
	 */
	private String nom = "Non defini";
	
	/**
	 * Equipe du joueur, compostion d'une collection de PFs
	 */
	private Equipe equipe = new Equipe();
	
	/******************CONSTRUCTEUR******************/
	/**
	 * Constructeur de la classe Joueur
	 * @param nom nom du joueur
	 */
	public Joueur(String nom){
		setNom(nom);
	}

	
	/******************EQUIPE******************/
	/**
	 * Donne l'equipe du joueur
	 * @return collection de PFs composant l'equipe du joueur
	 */
	public List<PFs> listerEquipe(){
		return getEquipe().getPFsEquipe();
	}
	
	/**
	 * Ajoute un PFs a l'equipe du joueur
	 * @param personnage PFs a ajouter
	 */
	public void ajouterPFs(PFs personnage){
		System.out.println(nom);
		getEquipe().ajouterPFs(personnage);
	}
	
	/**
	 * Fixe le PFs actif du joueurActuel
	 */
	public void setPFsActif(PFs o){
		getEquipe().setPFsActif(o);
	}

	/**
	 * Donne le PFs actif du joueurActuel
	 * @param PFs actif
	 */
	public PFs getPFsActif(){
		return getEquipe().getPFsActif();
	}
	
	
	
	
	
	
	
	
	public int deplacementDisponible(){
		
		return 0;
	}
	
	public Matrice listerDeplacement(){
		
		return null;
	}
	
	public void deplacerPFs(Position position){
		
	}
	
	public List<Attaque> listerAttaque(){
	
		return null;
	}

	
	public void placerPFs(PFs personnage, Position position){
		
	}

	public int attaqueDisponible(){
		
		return 0;
	}
	
	public List<PFs> listerPFsViviant(){
		
		return null;
	}
	
	//@param : dimension 1 -> axe x, dimension 2 -> axe y
	public List<PFs> listerPFsAttaquable(List<List<Position>> position){
		
		return null;
	}
	
	public void attaquerPFs(PFs personnage, Attaque attaque){
		
	}
	
	public void majDeplacement(){
		
	}
	
	public void majAttaque(){
		
	}
	
	public void majAdversaire(){
		
	}
	
	public void tourSuivant(){
		
	}
	
	
	
	
	
	
	/******************PRIVATE SETTERS******************/
	private void setNom(String nom) {
		this.nom = nom;
	}
	private void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	/******************PUBLIC GETTERS******************/
	public String getNom() {
		return nom;
	}
	public Equipe getEquipe() {
		return equipe;
	}
}
