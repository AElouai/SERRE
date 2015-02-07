
package serre;

import DAO.DbConfiguration;

/**
 * Classe metier Configuration pour modiliser la configuration
 * @author kamal
 *
 */
public class Configuration {
	private double configrationID;
	private double tempmin;
	private double tempmax;
 	private double rhmin;
 	private double rhmax;
 	private double lummin;
 	private double lummax;
 	private double co2min;
 	private double co2max;

 	
   /**
    * 
    * @param dbConfig Un Instance de DbConfiguration pour passe les parametre de la configuration a L'instance crée de la base de données
    */
 	public Configuration(DbConfiguration dbConfig) {
		super();
		this.configrationID = dbConfig.getConfigrationID();
		this.tempmin = dbConfig.getTempmin();
		this.tempmax = dbConfig.getTempmax();
		this.rhmin = dbConfig.getRhmin();
		this.rhmax = dbConfig.getRhmax();
		this.lummin = dbConfig.getLummin();
		this.lummax = dbConfig.getLummax();
		this.co2min = dbConfig.getCo2min();
		this.co2max = dbConfig.getCo2max();
	}

 	/**
 	 * 
 	 * @return Le Min de la temperature
 	 */
	public double getTempmin() {
 		return tempmin;
 	}
   
	/**
	 * 
	 * @param newTempmin Affecte cette valeur a la variable tempmin
	 */
 	public void setTempmin(double newTempmin) {
 		tempmin = newTempmin;
 	}
   
 	/**
 	 * 
 	 * @return Le max de la temperature
 	 */
 	public double getTempmax() {
 		return tempmax;
 	}	
   
 	/**
 	 * 
 	 * @param newTempmax affecte cette valeur a la variable tempmax
 	 */
 	public void setTempmax(double newTempmax) {
 		tempmax = newTempmax;
 	}	
   
 	/**
 	 * 
 	 * @return Min d'Humdité 
 	 */
 	public double getRhmin() {
 		return rhmin;
 	}
 	
 	/**
 	 * 
 	 * @param rhmin affecte cette valeur rhmin
 	 */
	public void setRhmin(double rhmin) {
		this.rhmin = rhmin;
	}
   
	/**
	 * 
	 * @return Le max de L'humidité
	 */
 	public double getRhmax() {
 		return rhmax;
 	}
   
 	/**
 	 * 
 	 * @param newRhmax Affecte la valeur 
 	 */
 	public void setRhmax(double newRhmax) {
 		rhmax = newRhmax;
 	}	
   
 	/**
 	 * 
 	 * @return le min de la luminosité
 	 */
 	public double getLummin() {
 		return lummin;
 	}
   
 	/**
 	 * 
 	 * @param newLummin affecte cette valeur a la variable lumin
 	 */
 	public void setLummin(double newLummin) {
      lummin = newLummin;
 	}	
   
 	/**
 	 * 
 	 * @return le Max la Luminosité
 	 */
 	public double getLummax() {
 		return lummax;
 	}
   
 	/**
 	 * 
 	 * @param newLummax affecte cette valeur a la variable lummax
 	 */
 	public void setLummax(double newLummax) {
 		lummax = newLummax;
 	}	
   
 	/**
 	 * 
 	 * @return le min du CO2
 	 */
 	public double getCo2min() {
	   return co2min;
 	}

 	/**
 	 * 
 	 * @param newCo2min affecte cette valeur a la variable co2min
 	 */
 	public void setCo2min(double newCo2min) {
 		co2min = newCo2min;
 	}

 	/**
 	 * 
 	 * @return le Max Du CO2
 	 */
 	public double getCo2max() {
 		return co2max;
 	}
 	
 	/**
 	 * 
 	 * @param newCo2max affecte cette valeur a la variable co2max
 	 */
 	public void setCo2max(double newCo2max) {
 		co2max = newCo2max;
 	}

 	/**
 	 * 
 	 * @return L'ID de la configuration
 	 */
	public double getConfigrationID() {
		return configrationID;
	}
	
 	@Override
	public String toString()
 	{
		return "CO2[" + this.co2min + " ," + this.co2max + "] " +
				"Humiditer[" + this.rhmin + " ," + this.rhmax + "]" +
				"Luminosite[" + this.lummin + " ," + this.lummax + "]" +
				"Temperature[" + this.tempmin + " ," + this.tempmax + "]";
 		
 	}

}