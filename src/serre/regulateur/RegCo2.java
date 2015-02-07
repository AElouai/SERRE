package serre.regulateur;
/**
 * Classe qui herite de Regulateur.
 * regulateur du CO2 
 * @author kamal
 *
 */


public class RegCo2 extends Regulateur {
	private boolean diminue = false;

	/**
	 * constructeur par defaut qui utilise celui du cconstructeur
	 * @param newParam
	 */
	public RegCo2(double newParam) {
		// TODO: implement
		super(newParam);
	}
   
	/**
   	 * 
   	 * @return true si le regulateur dimunie, false si non
   	 */
   	public boolean getDiminue() {
   		return diminue;
   	}

   	/**
   	 * 
   	 * @param newDiminue affecte cette valeur a la variable diminue
   	 */
   	public void setDiminue(boolean newDiminue) {
   		diminue = newDiminue;
   	}

	@Override
	public double regulariser(double value) {
		// TODO Auto-generated method stub
		if(diminue)
		{
			return value - super.getParametre();
		}else{
			return value + super.getParametre();
		}
	}
}