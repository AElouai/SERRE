package serre.capteur;

import DAO.*;

/**
 * Classe qui herite de la classe Capteur .
 * Un capteur du CO2
 * @author kamal
 *
 */


public class CaptCo2 extends Capteur {
	/**
	 * Constructeur par defaut (utilise le construtcteur de la classe merre -Capteur-)
	 * @param dbc
	 */
	public CaptCo2(DbCapteur dbc) {
		// TODO: implement
		super(dbc);
	}
	
	@Override
	public double capter()
	{
		return super.dbc.getCco2();
	}

}