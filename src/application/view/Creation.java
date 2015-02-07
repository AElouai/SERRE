package application.view;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Point;
import javax.swing.JButton;

import DAO.DbConfiguration;
import DAO.StaticDb;
/**
 * @author kamal
 * La classe Creation herite de JFrameet elle serre pour la creation des serres et leurs configurations
 */

public class Creation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane = null;
	private JLabel lTitre = null;
	private JTextField Titre = null;
	private JLabel lt1 = null;
	private JLabel lt2 = null;
	private JLabel lt3 = null;
	private JLabel lt4 = null;
	private JLabel lt5 = null;
	private JLabel lt6 = null;
	private JLabel lt51 = null;
	private JLabel lt511 = null;
	private JTextField tmin = null;
	private JTextField tmax = null;
	private JTextField hmin = null;
	private JTextField hmax = null;
	private JTextField lmin = null;
	private JTextField lmax = null;
	private JTextField cmin = null;
	private JTextField cmax = null;
	private JButton reset = null;
	private JButton save = null;
	/**
	 * This is the default constructor
	 */
	public Creation() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(674, 255);
		this.setContentPane(getJDesktopPane());
		this.setTitle("SimSerre - Creation");
	}

	/**
	 * This method initializes jDesktopPane	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			lt511 = new JLabel();
			lt511.setBounds(new Rectangle(359, 135, 122, 16));
			lt511.setText("CO2 Min");
			lt51 = new JLabel();
			lt51.setBounds(new Rectangle(359, 105, 121, 16));
			lt51.setText("CO2 Min");
			lt6 = new JLabel();
			lt6.setBounds(new Rectangle(360, 75, 121, 16));
			lt6.setText("Luminosité Max");
			lt5 = new JLabel();
			lt5.setBounds(new Rectangle(361, 45, 121, 16));
			lt5.setText("Luminosité Min");
			lt4 = new JLabel();
			lt4.setBounds(new Rectangle(75, 135, 121, 16));
			lt4.setText("Humidité Max");
			lt3 = new JLabel();
			lt3.setBounds(new Rectangle(75, 105, 121, 16));
			lt3.setText("Humidité Min");
			lt2 = new JLabel();
			lt2.setBounds(new Rectangle(75, 75, 121, 16));
			lt2.setText("Temperature Max");
			lt1 = new JLabel();
			lt1.setBounds(new Rectangle(76, 45, 121, 16));
			lt1.setText("Temperature Min");
			lTitre = new JLabel();
			lTitre.setBounds(new Rectangle(75, 15, 38, 16));
			lTitre.setText("Titre");
			jDesktopPane = new JDesktopPane();
			jDesktopPane.add(lTitre, null);
			jDesktopPane.add(getTitre(), null);
			jDesktopPane.add(lt1, null);
			jDesktopPane.add(lt2, null);
			jDesktopPane.add(lt3, null);
			jDesktopPane.add(lt4, null);
			jDesktopPane.add(lt5, null);
			jDesktopPane.add(lt6, null);
			jDesktopPane.add(lt51, null);
			jDesktopPane.add(lt511, null);
			jDesktopPane.add(getTmin(), null);
			jDesktopPane.add(getTmax(), null);
			jDesktopPane.add(getHmin(), null);
			jDesktopPane.add(getHmax(), null);
			jDesktopPane.add(getLmin(), null);
			jDesktopPane.add(getLmax(), null);
			jDesktopPane.add(getCmin(), null);
			jDesktopPane.add(getCmax(), null);
			jDesktopPane.add(getReset(), null);
			jDesktopPane.add(getSave(), null);
		}
		return jDesktopPane;
	}

	/**
	 * This method initializes Titre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTitre() {
		if (Titre == null) {
			Titre = new JTextField();
			Titre.setBounds(new Rectangle(120, 11, 121, 20));
		}
		return Titre;
	}

	/**
	 * This method initializes tmin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTmin() {
		if (tmin == null) {
			tmin = new JTextField();
			tmin.setBounds(new Rectangle(210, 42, 107, 19));
		}
		return tmin;
	}

	/**
	 * This method initializes tmax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTmax() {
		if (tmax == null) {
			tmax = new JTextField();
			tmax.setLocation(new Point(209, 72));
			tmax.setSize(new Dimension(107, 19));
		}
		return tmax;
	}

	/**
	 * This method initializes hmin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getHmin() {
		if (hmin == null) {
			hmin = new JTextField();
			hmin.setLocation(new Point(210, 101));
			hmin.setSize(new Dimension(107, 20));
		}
		return hmin;
	}

	/**
	 * This method initializes hmax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getHmax() {
		if (hmax == null) {
			hmax = new JTextField();
			hmax.setLocation(new Point(210, 131));
			hmax.setSize(new Dimension(107, 20));
		}
		return hmax;
	}

	/**
	 * This method initializes lmin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLmin() {
		if (lmin == null) {
			lmin = new JTextField();
			lmin.setLocation(new Point(495, 41));
			lmin.setSize(new Dimension(107, 20));
		}
		return lmin;
	}

	/**
	 * This method initializes lmax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLmax() {
		if (lmax == null) {
			lmax = new JTextField();
			lmax.setLocation(new Point(494, 71));
			lmax.setSize(new Dimension(107, 20));
		}
		return lmax;
	}

	/**
	 * This method initializes cmin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCmin() {
		if (cmin == null) {
			cmin = new JTextField();
			cmin.setLocation(new Point(495, 101));
			cmin.setSize(new Dimension(107, 20));
		}
		return cmin;
	}

	/**
	 * This method initializes cmax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCmax() {
		if (cmax == null) {
			cmax = new JTextField();
			cmax.setLocation(new Point(494, 132));
			cmax.setSize(new Dimension(107, 20));
		}
		return cmax;
	}

	/**
	 * This method initializes reset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getReset() {
		if (reset == null) {
			reset = new JButton();
			reset.setBounds(new Rectangle(143, 167, 142, 26));
			reset.setText("Rénitialiser");
			reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Titre.setText(""); // TODO Auto-generated Event stub actionPerformed()
					tmin.setText("");
					tmax.setText("");
					hmin.setText("");
					hmax.setText("");
					lmin.setText("");
					lmax.setText("");
					cmin.setText("");
					cmax.setText("");
				}
			});
		}
		return reset;
	}

	/**
	 * This method initializes save	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSave() {
		if (save == null) {
			save = new JButton();
			save.setBounds(new Rectangle(361, 167, 142, 26));
			save.setText("Enregistrer");
			save.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						StaticDb.openConnection();
						StaticDb.CreatSerre(Titre.getText(),
							new DbConfiguration(
									Double.parseDouble(tmin.getText()),
									Double.parseDouble(tmax.getText()),
									Double.parseDouble(hmin.getText()),
									Double.parseDouble(hmax.getText()),
									Double.parseDouble(lmin.getText()),
									Double.parseDouble(lmax.getText()),
									Double.parseDouble(cmin.getText()),
									Double.parseDouble(cmax.getText())
									)
							); // TODO Auto-generated Event stub actionPerformed()
						StaticDb.closeConnection();
					}catch(Exception e1){e1.printStackTrace();}
				}
			});
		}
		return save;
	}

}  //  @jve:decl-index=0:visual-constraint="2,10"
