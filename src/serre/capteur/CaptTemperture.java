package serre.capteur;

import DAO.DbCapteur;

/**
 * Classe qui herite de la classe Capteur .
 * Un capteur de la Temperature
 * @author kamal
 *
 */


public class CaptTemperture extends Capteur {
	/**
	 * Constructeur par defaut (utilise le construtcteur de la classe merre -Capteur-)
	 * @param dbc
	 */
 	  public CaptTemperture(DbCapteur dbc) {
 			// TODO: implement
 			super(dbc);
 		}

	@Override
	public double capter() {
		// TODO Auto-generated method stub
		return super.dbc.getCtemp();
	}

}