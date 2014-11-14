package Personnages;

import java.util.*;

import Model.Attaque;
import Model.PFs;

public class Guerrier extends PFs {
	public Guerrier(){
		super(8, 2, "Guerrier", "/images/Warrior.png");
		
		ajouterAttaque(
				new Attaque()
		);
	}
}
