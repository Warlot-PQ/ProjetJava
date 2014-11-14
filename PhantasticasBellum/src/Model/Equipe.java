package Model;

import java.util.*;

public class Equipe {
	private List<PFs> PFsEquipe = new ArrayList<PFs>();
	
	//Tour de jeu
	private int PA;
	private int PM;
	private Attaque attaque;
	private List<PFs> PFsAttaquer = new ArrayList<PFs>();
	private PFs PFsActif = null;
	//Fin tour de jeu
	
	public Equipe(){
		
	}
	
	public void ajouterPFs(PFs personnage){
		System.out.println("Ajout d'un " + personnage.getClasse() + " à l\'équipe");
		getPFsEquipe().add(personnage);
	}
	
	public void setPositionPFs(Position maPosition){
		getPFsActif().setPosition(maPosition);
	}
	
	public void placerPFs(PFs personnage, Position position){
		
	}
	
	public PFs getPFs(int numPFs){
		
		return null;
	}
	
	public void resetTour(){
		
	}
	
	public int deplacementDisponible(){
		
		return 0;
	}
	
	public Matrice listerDeplacement(){
		
		return null;
	}
	
	public void affecterDeplacement(Position position){
		
	}
	
	public int attaqueDisponible(){
		
		return 0;
	}
	
	public List<PFs> listerPFsVivant(){
		
		return null;
	}
	
	public List<PFs> listerPFsAttaquable(List<List<Position>> position){
		
		return null;
	}
	
	public void affecterAttaqueEtAdversaire(PFs personnage, Attaque attaque){
		
	}
	
	public void majDeplacement(){
		
	}

	public void majAttaque(){
		
	}

	public void majAdversaire(){
		
	}
	
	public void decrementerPA(){
		
	}
	
	public void decrementerPM(){
		
	}
	
	public void tourSuivant(){
			
	}
		
	public void resetPA(){
		
	}
	
	public void resetPM(){
		
	}

	public List<PFs> getPFsEquipe() {
		return PFsEquipe;
	}

	private void setPFsEquipe(List<PFs> pFsEquipe) {
		PFsEquipe = pFsEquipe;
	}

	private int getPA() {
		return PA;
	}

	private void setPA(int pA) {
		PA = pA;
	}

	private int getPM() {
		return PM;
	}

	private void setPM(int pM) {
		PM = pM;
	}

	private Attaque getAttaque() {
		return attaque;
	}

	private void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}

	private List<PFs> getPFsAttaquer() {
		return PFsAttaquer;
	}

	private void setPFsAttaquer(List<PFs> pFsAttaquer) {
		PFsAttaquer = pFsAttaquer;
	}

	public PFs getPFsActif() {
		return PFsActif;
	}

	public void setPFsActif(PFs pFsActif) {
		PFsActif = pFsActif;
	}
}
