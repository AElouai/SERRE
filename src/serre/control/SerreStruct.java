package serre.control;

/**
 * Classe pour crée une structure de serre qui contien son ID et son Nom
 * @author kamal
 *
 */

public class SerreStruct {

	private int id;
	private String label;
	/**
	 * Constructeur par defaut
	 * @param id ID de la serre
	 * @param label Nom de la serre
	 */
	public SerreStruct(int id, String label) {
		this.id = id;
		this.label = label;
	}
	/**
	 * 
	 * @return L'ID de la serre
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id affecte cette valeur a la variable id
	 */ 
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return le nom de la serre
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * 
	 * @param label affecte cette valeur a la variable label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
