package serre.regulateur;

/**
 * Classe abstraite qui modelise un regulateur dans la serre
 * @author kamal
 *
 */


public abstract class Regulateur {
   private double parametre;
   private boolean ison;
   
   /**
    * Constructeur par defaut
    * @param newParam parametre de la serre qui instancie ce regulateur
    */
   public Regulateur(double newParam) {
      // TODO: implement
	   this.parametre = newParam;
   }
   
   /**
    * 
    * @param value valeur a regulier
    * @return La valeur apres regulisation
    */
   public abstract double regulariser(double value);
   public double getParametre() {
      return parametre;
   }

   /**
    * 
    * @param newParametre parametre de la regularisation
    */
   public void setParametre(double newParametre) {
      parametre = newParametre;
   }
   
   /**
    * 
    * @return true si le regulateur est On, si Non
    */
   public boolean isOn() {
      return ison;
   }
   
   /**
    * 
    * @param isOn affecte cette valeur a la variable ison
    */
   public void setIsOn(boolean isOn) {
      ison = isOn;
   }

}