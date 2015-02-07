package application;

import DAO.StaticDb;
import application.view.Creation;
import application.view.SimSerre;
import application.view.Simview;

public class Main {
	
	/**
	 * @author kamal
	 * Classe d'execution des interfaces 
	 */
	private static SimSerre simSerre = new SimSerre();
	@SuppressWarnings("unchecked")
	private static Simview simview = new Simview();
	private static Creation simcrea = new Creation();
	/**
	 * @return L'instance simSerre de la classe SimSerre
	 */
	public static SimSerre SimSerre() {
		return simSerre;
	}
	/**
	 * @return L'instance simcrea de la classe Creation
	 */
	public static Creation SimCrea() {
		return simcrea;
	}
	/**
	 * @return L'instance simview de la classe Simview
	 */
	@SuppressWarnings("unchecked")
	public static Simview SimView() {
		return simview;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		StaticDb.init("localhost", "serredb", "root", "");
		SimSerre().setVisible(true);
	}
	
}
