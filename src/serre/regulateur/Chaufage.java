package serre.regulateur;
/**
 * Classe qui herite de Regulateur.
 * Un Chaufage qui augmente la chaleur 
 * @author kamal
 *
 */


public class Chaufage extends Regulateur {
	/**
	 * constructeur par defaut qui utilise celui du cconstructeur
	 * @param newParam
	 */
	public Chaufage(double newParam) {
		// TODO: implement
		super(newParam);
   	}

	@Override
	public double regulariser(double value) {
		// TODO Auto-generated method stub
		return value + super.getParametre();
	}

}