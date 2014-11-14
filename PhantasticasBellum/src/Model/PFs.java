package Model;

import java.util.*;

import javax.swing.ImageIcon;

public abstract class PFs implements Cloneable{
	private int vie;
	private int PM;
	private String classe;
	private ImageIcon image;
	private List<Attaque> attaque;
	private List<Effet> effet;
	private boolean dejaJouer;
	private Position position;
	
	public PFs(int vie, int PM, String classe, String imagePath){
		this.vie = vie;
		this.PM = PM;
		this.classe = classe;
		this.image = new ImageIcon(this.getClass().getResource(imagePath));
		this.attaque = new ArrayList<Attaque>();
		this.effet = new ArrayList<Effet>();
		this.dejaJouer = false;
		this.position = new Position();
	}

	public PFs(int vie, int PM, String classe){
		this(vie, PM, classe, "/images/DefaultPFs.png");
	}
	
	public Object clone(){
		PFs personnage = null;
		try{
			personnage = (PFs) super.clone();
		} catch (CloneNotSupportedException cnse){
			cnse.printStackTrace(System.err);
		}
		//Clone les autres dépendances, objets non immuables (types primitifs non inclus)
		//TODO Cloner la liste Effet
		return personnage;
	}
	
	protected void ajouterAttaque(Attaque attaque){
		this.attaque.add(attaque);
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getPM() {
		return PM;
	}

	public void setPM(int pM) {
		PM = pM;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public List<Attaque> getAttaque() {
		return attaque;
	}

	public void setAttaque(List<Attaque> attaque) {
		this.attaque = attaque;
	}

	public List<Effet> getEffet() {
		return effet;
	}

	public void setEffet(List<Effet> effet) {
		this.effet = effet;
	}

	public boolean isDejaJouer() {
		return dejaJouer;
	}

	public void setDejaJouer(boolean dejaJouer) {
		this.dejaJouer = dejaJouer;
	}

	public Position getPosition() {
		return position;
	}
	/*
	 * Fixe la position, protected car pour ajouter un PFs il faut verifier que la place n'est pas deja prise, donc on restreint l'acces
	 *///TODO mettre les classes des PFs et PFs dans un package separe
	protected void setPosition(Position position) {
		this.position = position;
	}
	
	public void majPosition(Position position){
		
	}
	
	public void majVie(int dommage){
		
	}

	public void majEffet(){
		
	}

	public boolean estVivant(){
		
		return false;
	}
	
	public boolean estAttaquable(List<List<Position>> position){
		
		return false;
	}
}
