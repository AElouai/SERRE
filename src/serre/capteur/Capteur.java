package serre.capteur;

import java.sql.SQLException;

import DAO.*;

/**
 * Classe abstraite qui modelise un capteur
 * @author kamal
 *
 */


public abstract class Capteur {
   private boolean ison;
   protected DbCapteur dbc;
   
   /**
    * 
    * @param DBC Une instance DbCapteur pour la connection a la base de données
    */
   public Capteur(DbCapteur DBC)  {
      // TODO: implement
	   dbc = DBC;
   }

   /**
    * Methode abstraite pour returner la valeur capter par le capteur
    * @return la valeur capter
    * @throws ClassNotFoundException
    * @throws SQLException
    */
   public abstract double capter() throws ClassNotFoundException, SQLException;
   /**
    * 
    * @return true si le capteur est On, false si non
    */
   public boolean isOn() {
      return ison;
   }

   /**
    * 
    * @param newIson affecte cette valeur a la variable ison
    */ 
   public void setIsOn(boolean newIson) {
      ison = newIson;
   }

}