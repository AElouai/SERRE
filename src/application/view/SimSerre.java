package application.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import serre.control.SerreStructArray;
import DAO.DbConfiguration;
import DAO.StaticDb;
import application.Main;

/**
 * 
 * @author kamal
 *	Classe SimSerre, Interface du choix des serres (Fenetre Principale)
 */
public class SimSerre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane = null;
	private JMenuBar Menu = null;
	private JMenu Fichier = null;
	private JMenuItem Quitter = null;
	private JMenu mSerre = null;
	private JMenuItem Crea = null;
	private JLabel LabelTitre = null;
	private JComboBox cSerre = null;
	private JLabel l1 = null;
	private JButton Simulation = null;
	private SerreStructArray ssa;
	private JMenuItem Remove = null;
	/**
	 * This is the default constructor
	 */
	
	public SimSerre() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(520, 267);
		this.setJMenuBar(getMenu());
		this.setContentPane(getJDesktopPane());
		this.setTitle("SimSerre");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowOpened(java.awt.event.WindowEvent e) {
				try {
					StaticDb.openConnection();
					ssa = StaticDb.getSerres();
					StaticDb.closeConnection();
					for(int i=0;i < ssa.size();i++) 
					{
						cSerre.addItem(ssa.get(i).getLabel());
						cSerre.getSelectedIndex();
					}
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * This method initializes jDesktopPane	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			l1 = new JLabel();
			l1.setBounds(new Rectangle(104, 95, 98, 16));
			l1.setText("Choisissez Une :");
			LabelTitre = new JLabel();
			LabelTitre.setBounds(new Rectangle(0, 0, 504, 76));
			LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
			LabelTitre.setHorizontalTextPosition(SwingConstants.CENTER);
			LabelTitre.setFont(new Font("Verdana", Font.BOLD, 36));
			LabelTitre.setText("SimSerre");
			jDesktopPane = new JDesktopPane();
			jDesktopPane.setBackground(Color.white);
			jDesktopPane.add(LabelTitre, null);
			jDesktopPane.add(getCSerre(), null);
			jDesktopPane.add(l1, null);
			jDesktopPane.add(getSimulation(), null);
		}
		return jDesktopPane;
	}

	/**
	 * This method initializes Menu	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenu() {
		if (Menu == null) {
			Menu = new JMenuBar();
			Menu.add(getFichier());
			Menu.add(getMSerre());
		}
		return Menu;
	}

	/**
	 * This method initializes Fichier	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFichier() {
		if (Fichier == null) {
			Fichier = new JMenu();
			Fichier.setText("Fichier");
			Fichier.add(getQuitter());
		}
		return Fichier;
	}

	/**
	 * This method initializes Quitter	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getQuitter() {
		if (Quitter == null) {
			Quitter = new JMenuItem();
			Quitter.setText("Quitter");
			Quitter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return Quitter;
	}

	/**
	 * This method initializes mSerre	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMSerre() {
		if (mSerre == null) {
			mSerre = new JMenu();
			mSerre.setText("Serre");
			mSerre.add(getCrea());
			mSerre.add(getRemove());
		}
		return mSerre;
	}

	/**
	 * This method initializes Crea	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCrea() {
		if (Crea == null) {
			Crea = new JMenuItem();
			Crea.setText("Creation");
			Crea.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Main.SimCrea().setVisible(true); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return Crea;
	}

	/**
	 * This method initializes cSerre	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCSerre() {
		if (cSerre == null) {
			cSerre = new JComboBox();
			cSerre.setBounds(new Rectangle(270, 88, 136, 25));
			cSerre.setMaximumRowCount(100);
		}
		return cSerre;
	}

	/**
	 * This method initializes Simulation	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSimulation() {
		if (Simulation == null) {
			Simulation = new JButton();
			Simulation.setBounds(new Rectangle(166, 134, 179, 36));
			Simulation.setText("Simulation");
			Simulation.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Main.SimView().charge(ssa.get(cSerre.getSelectedIndex()));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Main.SimView().setVisible(true);
				}
			});
		}
		return Simulation;
	}

	/**
	 * This method initializes Remove	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getRemove() {
		if (Remove == null) {
			Remove = new JMenuItem();
			Remove.setText("Supprimer");
			Remove.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					try{
						StaticDb.openConnection();
						int id = cSerre.getSelectedIndex();
						StaticDb.DeleteSerre(ssa.get(id).getId()); // TODO Auto-generated Event stub actionPerformed()
						StaticDb.closeConnection();
						StaticDb.openConnection();
						ssa = StaticDb.getSerres();
						StaticDb.closeConnection();
						cSerre.removeAll();
						for(int i=0;i < ssa.size();i++) 
						{
							cSerre.addItem(ssa.get(i).getLabel());
							cSerre.getSelectedIndex();
						}
					}catch(Exception e1){e1.printStackTrace();}
				}
			
			});
		}
		return Remove;
	}

}  //  @jve:decl-index=0:visual-constraint="43,23"
