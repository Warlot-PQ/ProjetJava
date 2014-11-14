package Personnages;

import Model.Attaque;
import Model.PFs;

public class Voleur extends PFs {
	public Voleur(){
		super(8, 2, "Voleur", "/images/Warrior.png");
		
		ajouterAttaque(
				new Attaque()
		);
	}
}
