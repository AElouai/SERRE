package serre.control;

/**
 * Classe qui contient les parametres de rafrechisement de la simulattion de serre
 * @author kamal
 *
 */

public class SerreParam {

	private long refresh;
	private long pventil;
	private long pchauf;
	private long phumid;
	private long plumin;
	private long pco2;
	/**
	 * @param Refresh : Parametre de raffrichisement de la simulation
	 * @param VentilParam : Parametre de fonctionnement du Ventilateur
	 * @param ChaufParam : Parametre de fonctionnement du Chaufage
	 * @param HumidParam : Parametre de fonctionnement du regulateur de l'Humidite
	 * @param LuminParam : Parametre de fonctionnement du regulateur de la luminosite
	 * @param Co2Param : Parametre de fonctionnement du regulateur du gaz CO2
	 */
	public SerreParam(long Refresh, long VentilParam, long ChaufParam, long HumidParam,
			long LuminParam, long Co2Param) {
		super();
		refresh = Refresh;
		pventil = VentilParam;
		pchauf = ChaufParam;
		phumid = HumidParam;
		plumin = LuminParam;
		pco2 = Co2Param;
	}
	/**
	 * 
	 * @return le parametre de rafrechisement
	 */
	public long getRefresh() {
		return refresh;
	}
	/**
	 * 
	 * @return le parametre du ventilateur
	 */
	public long getPventil() {
		return pventil;
	}
	/**
	 * 
	 * @return le parametre du chaufage
	 */
	public long getPchauf() {
		return pchauf;
	}
	/**
	 * 
	 * @return le parametre du humidité
	 */
	public long getPhumid() {
		return phumid;
	}
	/**
	 * 
	 * @return le parametre de la luminosité
	 */
	public long getPlumin() {
		return plumin;
	}
	/**
	 * 
	 * @return le parametre du CO2
	 */
	public long getPco2() {
		return pco2;
	}
	
	
	
}
