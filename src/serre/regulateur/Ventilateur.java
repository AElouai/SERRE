package serre.regulateur;
/**
 * Classe qui herite de Regulateur.
 * Un Ventilateur qui dimunie la chaleur 
 * @author kamal
 *
 */

public class Ventilateur extends Regulateur {
	/**
	 * constructeur par defaut qui utilise celui du cconstructeur
	 * @param newParam
	 */
	public Ventilateur(double newParam) {
	   // TODO: implement
	   super(newParam);
	}

	@Override
	public double regulariser(double value) {
		// TODO Auto-generated method stub
		return value - super.getParametre();
	}

}