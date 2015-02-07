package serre.control;

/**
 * Classe qui manipule le rafrechisement de la simulation et de ses actions
 * @author kamal
 *
 */

public class SerreSimulationTask{

	private boolean bool;
	
	/**
	 * 
	 * @return la valeur de bool
	 */
	public boolean isBool() {
		return bool;
	}

	/**
	 * 
	 * @param bool affecte la valeur a la variable bool
	 */
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
	/**
	 * Constructeur par defaut
	 * @param bool valeur par defaut de bool
	 */
	public SerreSimulationTask(boolean bool) {
		this.bool = bool;
	}

}
