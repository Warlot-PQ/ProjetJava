package Personnages;

import Model.Attaque;
import Model.PFs;

public class Cavalier extends PFs {
	public Cavalier(){
		super(8, 2, "Cavalier", "/images/Warrior.png");
		
		ajouterAttaque(
				new Attaque()
		);
	}
}
