package Personnages;

import Model.Attaque;
import Model.PFs;

public class Magicien extends PFs {
	public Magicien(){
		super(8, 2, "Magicien", "/images/Wizard.png");
		
		ajouterAttaque(
				new Attaque()
		);
	}
}
