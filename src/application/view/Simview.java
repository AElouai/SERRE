package application.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import DAO.DbCapteur;

import serre.Serre;
import serre.control.SerreParam;
import serre.control.SerreStruct;
import serre.interfaces.SerreOffAction;
import serre.interfaces.SerreOnAction;
import serre.interfaces.SimulationAction;
/**
 * 
 * @author kamal
 *	Classe Simview, Interface de la simulation de la serre choisie dans SimSerre (Fenetre De simulation)
 */
public class Simview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane = null;
	private JLabel titre = null;
	private JToggleButton bOn = null;
	private Serre s;  //  @jve:decl-index=0:
	private JLabel capteurs = null;
	private JLabel lctemp = null;
	private JLabel lchumid = null;
	private JLabel lclumin = null;
	private JLabel lcco2 = null;
	private JLabel ctemp = null;
	private JLabel chumid = null;
	private JLabel clumin = null;
	private JLabel cco2 = null;
	private JLabel regulateurs = null;
	private JLabel lrventil = null;
	private JLabel rventil = null;
	private JLabel lrchauf = null;
	private JLabel rchauf = null;
	private JLabel lrlumin = null;
	private JLabel lrhumid = null;
	private JLabel rhumid = null;
	private JLabel rlumin = null;
	private JLabel lrco2 = null;
	private JLabel rco2 = null;
	private JLabel parametres = null;
	private JLabel temp = null;
	private JLabel ltemp = null;
	private JLabel lhumid = null;
	private JLabel humid = null;
	private JLabel llumin = null;
	private JLabel lumin = null;
	private JLabel lco2 = null;
	private JLabel co2 = null;
	private JToggleButton bPause = null;
	/**
	 * This is the default constructor
	 * @param ss c'est un Objet de type SerreStruct qui contien les information de la serre Simuler
	 */

	public Simview() {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */

	private void initialize() {
		this.setSize(720, 383);
		this.setContentPane(getJDesktopPane());
		this.setTitle("JFrame");
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosing(java.awt.event.WindowEvent e) {    
				if(s != null)
					try {
						s.OFF(new SerreOffAction(){
							public void Action() {
								// TODO Auto-generated method stub
							}});
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // TODO Auto-generated Event stub windowClosing()
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
			co2 = new JLabel();
			co2.setBounds(new Rectangle(555, 275, 90, 20));
			co2.setHorizontalTextPosition(SwingConstants.CENTER);
			co2.setText("0 ppm");
			co2.setForeground(Color.BLUE);
			co2.setHorizontalAlignment(SwingConstants.CENTER);
			lco2 = new JLabel();
			lco2.setBounds(new Rectangle(455, 275, 90, 20));
			lco2.setText("CO2 : ");
			lumin = new JLabel();
			lumin.setBounds(new Rectangle(555, 235, 90, 20));
			lumin.setHorizontalTextPosition(SwingConstants.CENTER);
			lumin.setText("0 lx");
			lumin.setForeground(Color.BLUE);
			lumin.setHorizontalAlignment(SwingConstants.CENTER);
			llumin = new JLabel();
			llumin.setBounds(new Rectangle(455, 235, 90, 20));
			llumin.setText("luminosité : ");
			humid = new JLabel();
			humid.setBounds(new Rectangle(555, 195, 90, 20));
			humid.setHorizontalTextPosition(SwingConstants.CENTER);
			humid.setText("0 %");
			humid.setForeground(Color.BLUE);
			humid.setHorizontalAlignment(SwingConstants.CENTER);
			lhumid = new JLabel();
			lhumid.setBounds(new Rectangle(455, 195, 90, 20));
			lhumid.setText("Humidité : ");
			ltemp = new JLabel();
			ltemp.setBounds(new Rectangle(455, 135, 90, 20));
			ltemp.setText("Temperature : ");
			temp = new JLabel();
			temp.setBounds(new Rectangle(555, 135, 90, 20));
			temp.setHorizontalAlignment(SwingConstants.CENTER);
			temp.setHorizontalTextPosition(SwingConstants.CENTER);
			temp.setText("0 °C");
			temp.setForeground(Color.BLUE);
			parametres = new JLabel();
			parametres.setBounds(new Rectangle(415, 80, 157, 16));
			parametres.setText("Etat des Valeurs Actuelles :");
			rco2 = new JLabel();
			rco2.setBounds(new Rectangle(350, 260, 35, 35));
			rco2.setText("");
			rco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			lrco2 = new JLabel();
			lrco2.setBounds(new Rectangle(255, 275, 82, 17));
			lrco2.setText("CO2");
			rlumin = new JLabel();
			rlumin.setBounds(new Rectangle(350, 220, 35, 35));
			rlumin.setText("");
			rlumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			rhumid = new JLabel();
			rhumid.setBounds(new Rectangle(350, 180, 35, 35));
			rhumid.setText("");
			rhumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			lrhumid = new JLabel();
			lrhumid.setBounds(new Rectangle(255, 195, 82, 17));
			lrhumid.setText("Humidité");
			lrlumin = new JLabel();
			lrlumin.setBounds(new Rectangle(255, 235, 82, 17));
			lrlumin.setText("Luminosité");
			rchauf = new JLabel();
			rchauf.setText("");
			rchauf.setSize(new Dimension(35, 35));
			rchauf.setLocation(new Point(350, 140));
			rchauf.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			lrchauf = new JLabel();
			lrchauf.setText("Chaufage");
			lrchauf.setBounds(new Rectangle(255, 155, 82, 17));
			rventil = new JLabel();
			rventil.setText("");
			rventil.setSize(new Dimension(35, 35));
			rventil.setLocation(new Point(350, 100));
			rventil.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			lrventil = new JLabel();
			lrventil.setText("Ventilateur");
			lrventil.setLocation(new Point(255, 115));
			lrventil.setSize(new Dimension(82, 17));
			regulateurs = new JLabel();
			regulateurs.setText("Etat des Regulateurs :");
			regulateurs.setLocation(new Point(215, 80));
			regulateurs.setSize(new Dimension(133, 16));
			cco2 = new JLabel();
			cco2.setText("");
			cco2.setBounds(new Rectangle(150, 260, 35, 35));
			cco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			clumin = new JLabel();
			clumin.setText("");
			clumin.setBounds(new Rectangle(150, 220, 35, 35));
			clumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			chumid = new JLabel();
			chumid.setText("");
			chumid.setBounds(new Rectangle(150, 180, 35, 35));
			chumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			ctemp = new JLabel();
			ctemp.setText("");
			ctemp.setBounds(new Rectangle(150, 120, 35, 35));
			ctemp.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			lcco2 = new JLabel();
			lcco2.setText("CO2");
			lcco2.setBounds(new Rectangle(55, 275, 82, 17));
			lclumin = new JLabel();
			lclumin.setText("Luminosité");
			lclumin.setBounds(new Rectangle(55, 235, 82, 17));
			lchumid = new JLabel();
			lchumid.setText("Humidité");
			lchumid.setBounds(new Rectangle(55, 195, 82, 17));
			lctemp = new JLabel();
			lctemp.setText("Temperature");
			lctemp.setBounds(new Rectangle(55, 135, 82, 17));
			capteurs = new JLabel();
			capteurs.setText("Etat des Capteurs :");
			capteurs.setLocation(new Point(15, 80));
			capteurs.setSize(new Dimension(113, 20));
			titre = new JLabel();
			titre.setBounds(new Rectangle(-1, 15, 566, 31));
			titre.setFont(new Font("Verdana", Font.BOLD, 18));
			titre.setHorizontalAlignment(SwingConstants.CENTER);
			titre.setHorizontalTextPosition(SwingConstants.CENTER);
			titre.setText("Simulation de ");
			jDesktopPane = new JDesktopPane();
			jDesktopPane.add(titre, null);
			jDesktopPane.add(getBOn(), null);
			jDesktopPane.add(capteurs, null);
			jDesktopPane.add(lctemp, null);
			jDesktopPane.add(lchumid, null);
			jDesktopPane.add(lclumin, null);
			jDesktopPane.add(lcco2, null);
			jDesktopPane.add(ctemp, null);
			jDesktopPane.add(chumid, null);
			jDesktopPane.add(clumin, null);
			jDesktopPane.add(cco2, null);
			jDesktopPane.add(regulateurs, null);
			jDesktopPane.add(lrventil, null);
			jDesktopPane.add(rventil, null);
			jDesktopPane.add(lrchauf, null);
			jDesktopPane.add(rchauf, null);
			jDesktopPane.add(lrlumin, null);
			jDesktopPane.add(lrhumid, null);
			jDesktopPane.add(rhumid, null);
			jDesktopPane.add(rlumin, null);
			jDesktopPane.add(lrco2, null);
			jDesktopPane.add(rco2, null);
			jDesktopPane.add(parametres, null);
			jDesktopPane.add(temp, null);
			jDesktopPane.add(ltemp, null);
			jDesktopPane.add(lhumid, null);
			jDesktopPane.add(humid, null);
			jDesktopPane.add(llumin, null);
			jDesktopPane.add(lumin, null);
			jDesktopPane.add(lco2, null);
			jDesktopPane.add(co2, null);
			jDesktopPane.add(getBPause(), null);
		}
		return jDesktopPane;
	}

	/**
	 * This method initializes bOn	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getBOn() {
		if (bOn == null) {
			bOn = new JToggleButton();
			bOn.setBounds(new Rectangle(634, 15, 70, 31));
			bOn.setText("Off");
			bOn.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					try
					{
						if(bOn.isSelected())
						{
							bOn.setText("On");
							bOn.setForeground(Color.GREEN);
							On();
							Simulation();
							bPause.setVisible(true);
							bPause.setForeground(Color.RED);
						}else{
							bOn.setText("Off");
							bOn.setForeground(Color.RED);
							Off();
							bPause.setVisible(false);
						}
					}catch(ClassNotFoundException e1)
					{
						e1.printStackTrace();
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return bOn;
	}
	
	
	private void Simulation() throws SQLException, InterruptedException
	{
		s.Simultation(new SimulationAction(){

			//@Override              //************************************* why i commebt this one !!!!!!
			public void Action() {
				// TODO Auto-generated method stub
				DecimalFormat df = new DecimalFormat("####.00");
				temp.setText(df.format(s.getNowTemp()) + " °C");
				humid.setText(df.format(s.getNowHumid()) + " %");
				lumin.setText(df.format(s.getNowLumin()) + " lx");
				co2.setText(df.format(s.getNowCo2()) + " ppm");
				if(s.getRventilIsON()) 
					rventil.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
				else
					rventil.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				if(s.getRchaufIsON()) 
					rchauf.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
				else
					rchauf.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				if(s.getRhumidIsON()) 
					rhumid.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
				else
					rhumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				if(s.getRluminIsON()) 
					rlumin.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
				else
					rlumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				if(s.getRco2IsON()) 
					rco2.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
				else
					rco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			}
		});
	}
	
	private void On() throws ClassNotFoundException, SQLException
	{
		this.s.ON(new SerreOnAction(){

			//@Override              //************************************* why i commebt this one !!!!!!
			public void Action() {
				// TODO Auto-generated method stub
				capteurIcon();
			}
		
		});
	}

	private void Off() throws ClassNotFoundException, SQLException
	{
		this.s.OFF(new SerreOffAction(){

			//@Override              //************************************* why i commebt this one !!!!!!
			public void Action() {
				// TODO Auto-generated method stub
				capteurIcon();
				temp.setText("0 °C");
				humid.setText("0 %");
				lumin.setText("0 lx");
				co2.setText("0 ppm");
				rventil.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				rchauf.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				rhumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				rlumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
				rco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
			}
			
		});
	}
	
	private void capteurIcon()
	{
		if(s.getCtempIsON()) 
			ctemp.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
		else
			ctemp.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		if(s.getChumidIsON()) 
			chumid.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
		else
			chumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		if(s.getCluminIsON()) 
			clumin.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
		else
			clumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		if(s.getCco2IsON()) 
			cco2.setIcon(new ImageIcon(getClass().getResource("/ressources/green.png")));
		else
			cco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));

	}

	/**
	 * This method initializes bPause	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getBPause() {
		if (bPause == null) {
			bPause = new JToggleButton();
			bPause.setBounds(new Rectangle(564, 15, 70, 31));
			bPause.setText("Pause");
			bPause.setVisible(false);
			bPause.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					if(bPause.isSelected())
					{
						bPause.setText("Pause");
						bPause.setForeground(Color.GREEN);
					}else{
						bPause.setText("Pause");
						bPause.setForeground(Color.RED);
					}
					s.Pause();
				}
			});
		}
		return bPause;
	}
	
	public void charge(SerreStruct ss) throws ClassNotFoundException, SQLException
	{
		if(s != null) s.OFF(new SerreOffAction(){
			@Override
			public void Action() {
				// TODO Auto-generated method stub
				
			}
		});
		setTitle(ss.getLabel());
		titre.setText( ss.getLabel() );
		try {
			s = new Serre(new DbCapteur(), new SerreParam(1,1,1,5,10,15), ss.getId());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bPause.setVisible(false);
		bPause.setSelected(false);
		bPause.setForeground(Color.RED);
		bOn.setSelected(false);
		bOn.setForeground(Color.RED);
		temp.setText("0 °C");
		humid.setText("0 %");
		lumin.setText("0 lx");
		co2.setText("0 ppm");
		rventil.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		rchauf.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		rhumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		rlumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		rco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		ctemp.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		chumid.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		clumin.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
		cco2.setIcon(new ImageIcon(getClass().getResource("/ressources/red.png")));
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
