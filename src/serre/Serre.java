package serre;

import java.sql.SQLException;
import java.util.*;

import DAO.*;
import serre.capteur.*;
import serre.control.*;
import serre.interfaces.*;
import serre.regulateur.*;

/**
 * Class Metier Serre Qui Modelise la serre Réele 
 * @author kamal
 *
 */


public class Serre {	
	
	private Timer t1;
	private Timer t2;
	private Timer t3;
	private boolean pause=false;
	
	private SerreParam sp;

	private boolean isOn = false;


	private int serreID;

	private String label;


	private Configuration maconfig;

	private CaptTemperture ctemp;
	private CaptHumidite chumid;
	private CaptCo2 cco2;
	private CaptLuminosite clumin;
	private RegCo2 rco2;
	private RegLuminosite rlumin;
	private Ventilateur rventil;
	private RegHumidite rhumid;
	private Chaufage rchauf;
	
	
	private DbCapteur dbc;
	
	private double nowTemp;
	private double nowHumid;
	private double nowCo2;
	private double nowLumin;
	
	/**
	 * Constructeur Par defaut
	 * @param NewDbCapteur Un Instance DbCapteur pour connecter la capteur
	 * @param NewParam Instance SerreParam Pour les parametres de rafrechisement
	 * @param NewSerre L'ID de la serre a Istansier
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Serre(DbCapteur NewDbCapteur, SerreParam NewParam, int NewSerre) throws ClassNotFoundException, SQLException{
		// TODO: implement
		sp = NewParam;
		serreID = NewSerre;
		dbc = NewDbCapteur;
		label = DbSerre.getSerreLabel(NewSerre);
		maconfig = new Configuration( new DbConfiguration(NewSerre));
		rlumin = new RegLuminosite(sp.getPlumin());
		rventil = new Ventilateur(sp.getPventil());
		rhumid = new RegHumidite(sp.getPhumid());
		rchauf = new Chaufage(sp.getPchauf());
		rco2 = new RegCo2(sp.getPco2());
		t1 = new Timer();
		t2 = new Timer();
		t3 = new Timer();
	}
	
	/**
	 * Constructeur par copie
	 * @param NewS La Serre a copier
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Serre(Serre NewS) throws ClassNotFoundException, SQLException{
		// TODO: implement
		sp = NewS.sp;
		serreID = NewS.serreID;
		dbc = NewS.dbc;
		label = DbSerre.getSerreLabel(serreID);
		maconfig = new Configuration( new DbConfiguration(serreID));
		rlumin = new RegLuminosite(5);
		rventil = new Ventilateur(5);
		rhumid = new RegHumidite(5);
		rchauf = new Chaufage(5);
		rco2 = new RegCo2(100);
	}
	
	/**
	 * Metre La serre en marche
	 * @param soa Les Action a Execute apres la mise en marche de la serre
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void ON(final SerreOnAction soa) throws ClassNotFoundException, SQLException 
	{
		if(!isOn)
		{
			dbc.openConnection();
			isOn = true;
			ctemp = new CaptTemperture(dbc);
			chumid = new CaptHumidite(dbc);
			clumin = new CaptLuminosite(dbc);
			cco2 = new CaptCo2(dbc);
			ctemp.setIsOn(true);
			chumid.setIsOn(true);
			clumin.setIsOn(true);
			cco2.setIsOn(true);
			t1 = new Timer();
			t2 = new Timer();
			soa.Action();
		}
	}
	
	/**
	 * Arrete de la simulation 
	 * @param soa Action a execute apres l'arret
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void OFF(final SerreOffAction soa) throws ClassNotFoundException, SQLException 
	{
		if(isOn)
		{
			dbc.closeConnection();
			isOn = false;
			ctemp.setIsOn(false);
			chumid.setIsOn(false);
			clumin.setIsOn(false);
			cco2.setIsOn(false);
			rventil.setIsOn(false);
			rchauf.setIsOn(false);
			rhumid.setIsOn(false);
			rlumin.setIsOn(false);
			rco2.setIsOn(false);
			t1.cancel();
			t2.cancel();
			soa.Action();
		}
	}
	
	/**
	 * Chargement des capteur
	 * @throws SQLException
	 */
	private void charge() throws SQLException
	{
		dbc.charge();
		nowCo2 = cco2.capter();
		nowHumid = chumid.capter();
		nowLumin = clumin.capter();
		nowTemp = ctemp.capter();
	}
	
	/**
	 * Regularise les valeurs capter
	 */
	private void regule()
	{
		if(nowCo2 < maconfig.getCo2min())
		{
			rco2.setDiminue(false);
			rco2.setIsOn(true);
			nowCo2 = rco2.regulariser(nowCo2);
		}else
		if(nowCo2 > maconfig.getCo2max())			
		{
			rco2.setDiminue(true);
			rco2.setIsOn(true);
			nowCo2 = rco2.regulariser(nowCo2);
		}else rco2.setIsOn(false);
		
		if(nowLumin < maconfig.getLummin())
		{
			rlumin.setDiminue(false);
			rlumin.setIsOn(true);
			nowLumin = rlumin.regulariser(nowLumin);
		}else
		if(nowLumin > maconfig.getLummax())			
		{
			rlumin.setDiminue(true);
			rlumin.setIsOn(true);
			nowLumin = rlumin.regulariser(nowLumin);
		}else rlumin.setIsOn(false);
		
		if(nowHumid < maconfig.getRhmin())
		{
			rhumid.setDiminue(false);
			rhumid.setIsOn(true);
			nowHumid = rhumid.regulariser(nowHumid);
		}else
		if(nowHumid > maconfig.getRhmax())			
		{
			rhumid.setDiminue(true);
			rhumid.setIsOn(true);
			nowHumid = rhumid.regulariser(nowHumid);
		}else rhumid.setIsOn(false);
		
		if(nowTemp < maconfig.getTempmin())
		{
			rchauf.setIsOn(true);
			nowTemp = rchauf.regulariser(nowTemp);
		}else rchauf.setIsOn(false);
		
		if(nowTemp > maconfig.getTempmax())			
		{
			rventil.setIsOn(true);
			nowTemp = rventil.regulariser(nowTemp);
		}else rventil.setIsOn(false);
	}
	
	/**
	 * La simulation
	 * @param sa Action a execute apres chaque rafrechisement
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public void Simultation(final SimulationAction sa) throws SQLException, InterruptedException {
		// TODO: implement
		final SerreSimulationTask sst1 = new SerreSimulationTask(true);
		final SerreSimulationTask sst2 = new SerreSimulationTask(true);
		
		t1.schedule(new TimerTask(){
			@Override
			public void run(){
				// TODO Auto-generated method stub
				sst1.setBool(true);
			}
			
		}, 0, sp.getRefresh()*5000);
		/* Rafrechisement des regulateur*/
		t2.schedule(new TimerTask(){
			@Override
			public void run(){
				// TODO Auto-generated method stub
				sst2.setBool(true);
				sa.Action();
			}
			
		}, 0, sp.getRefresh()*500);
		/* Rafrechisement pour la simulation*/
		t3.schedule(new TimerTask(){
			@Override
			public void run(){
				// TODO Auto-generated method stub
				if(sst1.isBool() && !pause) {
					try {
						charge();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sst1.setBool(false);
				}
				if(sst2.isBool() && !pause)
				{
					regule();
					sst2.setBool(false);
				}
			}
			
		}, 0, 1);
	}
	
	
	/**
	 * mise en pause de la simulation
	 */
	public void Pause()
	{
		pause = !pause;
	}

	/**
	 * 
	 * @return La configuration de la serre
	 */
	public Configuration getMaconfig() {
		return maconfig;
	}

	/**
	 * 
	 * @param maconfig Affecter cette valeur a la variable maconfig(Instance de Configuration) 
	 */
	public void setMaconfig(Configuration maconfig) {
		this.maconfig = maconfig;
	}
	
	/**
	 * 
	 * @return true si la serre est dans l'etat simualtion, false si non
	 */
	public boolean isOn() {
		return isOn;
	}
	
	/**
	 * 
	 * @param isOn affacter cette valeur a la variable isOn(boolean)
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	/**
	 * 
	 * @return L'ID de la serre
	 */
	public int getSerreID() {
		return serreID;
	}
	
	/**
	 * 
	 * @return Le Nom de la serre
	 * 
	 */
	public String getSerreLabel() {
		return label;
	}
	
	/**
	 * 
	 * @return La Temperature actuele de la serre
	 */
	public double getNowTemp() {
		return nowTemp;
	}

	/**
	 * 
	 * @return L'Humidité actuele de la serre
	 */
	public double getNowHumid() {
		return nowHumid;
	}

	/**
	 * 
	 * @return CO2 actuele de la serre
	 */
	public double getNowCo2() {
		return nowCo2;
	}

	/**
	 * 
	 * @return La Luminosité actuele de la serre
	 */
	public double getNowLumin() {
		return nowLumin;
	}
	
	/**
	 * 
	 * @return true si le capteur est On, false si OFF
	 */
	public boolean getCtempIsON() {
		return ctemp.isOn();
	}
	/**
	 * 
	 * @return true si le capteur est On, false si OFF
	 */
	public boolean getChumidIsON() {
		return chumid.isOn();
	}
	/**
	 * 
	 * @return true si le capteur est On, false si OFF
	 */
	public boolean getCco2IsON() {
		return cco2.isOn();
	}
	/**
	 * 
	 * @return true si le capteur est On, false si OFF
	 */
	public boolean getCluminIsON() {
		return clumin.isOn();
	}
	/**
	 * 
	 * @return true si le regulateur est On, false si OFF
	 */
	public boolean getRco2IsON() {
		return rco2.isOn();
	}
	/**
	 * 
	 * @return true si le regulateur est On, false si OFF
	 */
	public boolean getRluminIsON() {
		return rlumin.isOn();
	}
	/**
	 * 
	 * @return true si le regulateur est On, false si OFF
	 */
	public boolean getRventilIsON() {
		return rventil.isOn();
	}
	/**
	 * 
	 * @return true si le regulateur est On, false si OFF
	 */
	public boolean getRhumidIsON() {
		return rhumid.isOn();
	}
	/**
	 * 
	 * @return true si le regulateur est On, false si OFF
	 */
	public boolean getRchaufIsON() {
		return rchauf.isOn();
	}

}
