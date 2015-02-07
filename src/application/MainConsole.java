package application;

import java.sql.SQLException;

import serre.Serre;
import serre.control.SerreParam;
import serre.interfaces.*;
import DAO.DbCapteur;
import DAO.StaticDb;

public class MainConsole {
	
	/**
	 * @author kamal
	 * Classe d'execution de l'application console
	 * un test de l'utilisation des class metier 
	 */

	
	static private int i=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			StaticDb.init("localhost","serredb","root","");
			final Serre s = new Serre(new DbCapteur(), new SerreParam(1,2,2,5,25,100),1);
			System.out.println(s.getMaconfig());
			s.ON(new SerreOnAction(){

				@Override
				public void Action() {
					// TODO Auto-generated method stub	
				}
				
			});
			s.Simultation(new SimulationAction(){
				public void Action() {
					// TODO Auto-generated method stub
					System.out.println("I : " + i);
					System.out.println("CO2 : " + s.getNowCo2());
					System.out.println("Humidite : " + s.getNowHumid());
					System.out.println("Luminosite : " + s.getNowLumin());
					System.out.println("Temperature : " + s.getNowTemp());
					System.out.println("CO2 : " + s.getCco2IsON() + " - " + s.getRco2IsON());
					System.out.println("Humidite : " + s.getChumidIsON() + " - " + s.getRhumidIsON());
					System.out.println("Luminosite : " + s.getCluminIsON() + " - " + s.getRluminIsON());
					System.out.println("Temperature : " + s.getCtempIsON() + " - " + s.getRventilIsON() + " - " + s.getRchaufIsON());
					System.out.println("*******************************************************");
					if(i == 15)
					{
						try {
							s.OFF(new SerreOffAction(){

								@Override
								public void Action() {
									// TODO Auto-generated method stub	
								}
								
							});
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					i++;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
