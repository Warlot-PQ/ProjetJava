package Exception;

/**
* La classe ExceptionParamJeu definie les erreurs des parametres du jeu, taille negative, plateau trop petit
* @author Scrat
*
*/

public class ExceptionParamJeu extends Exception{
	public enum error{
		NEGATIVE, PLATEAU
	}
	
	private error explication = null;
	
	public ExceptionParamJeu(error type){
		this.explication = type;
	}
	
	public error getExplication(){
		return explication;
	}
}

