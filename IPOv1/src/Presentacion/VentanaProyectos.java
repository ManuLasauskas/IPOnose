package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.prism.Image;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Dominio.Proyecto;
import Dominio.Usuario;
import Persistencia.Agente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaProyectos {

	private JFrame frmIproyect;
	private Usuario us;
	private Agente ag = Agente.getInstance();
	private DefaultListModel<String> proyectos;
	private JButton btnedit;
	private JList list;
	private Proyecto seleccion;
	/**
	 * Create the application.
	 */
	public VentanaProyectos (Usuario us) {
		this.us=us;
		System.out.println(this.us);
		initialize();
		darLista();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIproyect = new JFrame();
		frmIproyect.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea usted cerrar la aplicación?", "Cerrando IPROject", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		frmIproyect.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaProyectos.class.getResource("/Resources/logg.png")));
		frmIproyect.setTitle("IPROyect");
		frmIproyect.setResizable(false);
		Dimension rectangulo = Toolkit.getDefaultToolkit().getScreenSize();
		frmIproyect.setBounds(0,0, rectangulo.width-50, rectangulo.height-50);
		frmIproyect.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmIproyect.setVisible(true);
		
		frmIproyect.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, 40, 46, 0, 0, 38, 0, 46, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{8, 42, 75, 10, 36, 35, 37, 0, 0, 0, 0, 0, 0, 0, 34, 56, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmIproyect.getContentPane().setLayout(gridBagLayout);
		
		
		JLabel lblImage = new JLabel("");
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		lblImage.setIcon(new ImageIcon(us.getImage()));
		gbc_lblImage.gridwidth = 2;
		gbc_lblImage.gridheight = 2;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 1;
		frmIproyect.getContentPane().add(lblImage, gbc_lblImage);
		
		JLabel lblBienvenido = new JLabel("Bienvenido: ");
		lblBienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.gridwidth = 2;
		gbc_lblBienvenido.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenido.gridx = 3;
		gbc_lblBienvenido.gridy = 2;
		frmIproyect.getContentPane().add(lblBienvenido, gbc_lblBienvenido);
		
		JLabel lblX = new JLabel(us.getNombre());
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.gridwidth = 3;
		gbc_lblX.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 5;
		gbc_lblX.gridy = 2;
		frmIproyect.getContentPane().add(lblX, gbc_lblX);
		
		JLabel lblUltimaConexion = new JLabel("Ultima conexion:");
		GridBagConstraints gbc_lblUltimaConexion = new GridBagConstraints();
		gbc_lblUltimaConexion.gridwidth = 2;
		gbc_lblUltimaConexion.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblUltimaConexion.insets = new Insets(0, 0, 5, 5);
		gbc_lblUltimaConexion.gridx = 3;
		gbc_lblUltimaConexion.gridy = 3;
		frmIproyect.getContentPane().add(lblUltimaConexion, gbc_lblUltimaConexion);
		
		JLabel lblXUltimaConexion = new JLabel(us.getFechaString());
		lblXUltimaConexion.setVerticalAlignment(SwingConstants.TOP);
		lblXUltimaConexion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblXUltimaConexion = new GridBagConstraints();
		gbc_lblXUltimaConexion.gridwidth = 3;
		gbc_lblXUltimaConexion.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblXUltimaConexion.insets = new Insets(0, 0, 5, 5);
		gbc_lblXUltimaConexion.gridx = 5;
		gbc_lblXUltimaConexion.gridy = 3;
		frmIproyect.getContentPane().add(lblXUltimaConexion, gbc_lblXUltimaConexion);
		
		JLabel lblMisProyectos = new JLabel("Mis proyectos");
		GridBagConstraints gbc_lblMisProyectos = new GridBagConstraints();
		gbc_lblMisProyectos.gridwidth = 2;
		gbc_lblMisProyectos.anchor = GridBagConstraints.SOUTH;
		gbc_lblMisProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_lblMisProyectos.gridx = 1;
		gbc_lblMisProyectos.gridy = 4;
		frmIproyect.getContentPane().add(lblMisProyectos, gbc_lblMisProyectos);
		
		JButton btnadd = new JButton("");
		btnadd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cargarDialogoProyecto(null);
				darLista();
			}
		});
		btnadd.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/Anadir.png")));
		btnadd.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnadd = new GridBagConstraints();
		gbc_btnadd.anchor = GridBagConstraints.EAST;
		gbc_btnadd.insets = new Insets(0, 0, 5, 5);
		gbc_btnadd.gridx = 4;
		gbc_btnadd.gridy = 4;
		frmIproyect.getContentPane().add(btnadd, gbc_btnadd);
		
		btnedit = new JButton("");
		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cargarDialogoProyecto(seleccion);	
				proyectos.removeElement(seleccion.getNombre());
			}
		});
		btnedit.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/lapiz.png")));
		btnedit.setBorder(BorderFactory.createEmptyBorder());
		btnedit.setEnabled(false);
		GridBagConstraints gbc_btnedit = new GridBagConstraints();
		gbc_btnedit.insets = new Insets(0, 0, 5, 5);
		gbc_btnedit.gridx = 5;
		gbc_btnedit.gridy = 4;
		frmIproyect.getContentPane().add(btnedit, gbc_btnedit);
		
		JButton btndelete = new JButton("");
		btndelete.setEnabled(false);
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				proyectos.removeElement(seleccion.getNombre());
				ag.getProyectos().remove(seleccion);
				}
		});
		btndelete.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/papelera.png")));
		btndelete.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btndelete = new GridBagConstraints();
		gbc_btndelete.anchor = GridBagConstraints.WEST;
		gbc_btndelete.insets = new Insets(0, 0, 5, 5);
		gbc_btndelete.gridx = 6;
		gbc_btndelete.gridy = 4;
		frmIproyect.getContentPane().add(btndelete, gbc_btndelete);
		
		JTabbedPane display_tab = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_display_tab = new GridBagConstraints();
		gbc_display_tab.insets = new Insets(0, 0, 0, 5);
		gbc_display_tab.gridheight = 13;
		gbc_display_tab.gridwidth = 11;
		gbc_display_tab.fill = GridBagConstraints.BOTH;
		gbc_display_tab.gridx = 7;
		gbc_display_tab.gridy = 4;
		frmIproyect.getContentPane().add(display_tab, gbc_display_tab);
		
		
		InfoProyecto panel = new InfoProyecto();
		display_tab.addTab("Información", null, panel, null);
		
		PanelTareas tareas_panel = new PanelTareas();
		tareas_panel.setEnabled(false);
		display_tab.addTab("Tareas", null, tareas_panel, null);
		
		JPanel chat_panel = new UserChat(us);
		chat_panel.setEnabled(false);
		display_tab.addTab("Chat", null, chat_panel, null);

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		frmIproyect.getContentPane().add(scrollPane, gbc_scrollPane);
		
		proyectos = new DefaultListModel<>();
		list = new JList(proyectos);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String p = list.getSelectedValue().toString();
				seleccion=null;
				if (list.getSelectedValue() != null) {
					btnedit.setEnabled(true);
					btndelete.setEnabled(true);
				}
				System.out.println(ag.getProyectos().size());
				for (int j=0;j<ag.getProyectos().size();j++) {
					if (String.valueOf(ag.getProyectos().get(j).getNombre()).equals(p)) seleccion=ag.getProyectos().get(j);
				}
				if (seleccion!=null) panel.fill(seleccion);
				tareas_panel.setEnabled(true);
				tareas_panel.eliminarTareas();
				tareas_panel.mostrarTareas(seleccion);
			}
		});
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnhelp = new JButton("");
		btnhelp.setMnemonic('H');
		btnhelp.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/help.png")));
		btnhelp.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnhelp = new GridBagConstraints();
		gbc_btnhelp.insets = new Insets(0, 0, 5, 5);
		gbc_btnhelp.gridx = 1;
		gbc_btnhelp.gridy = 15;
		frmIproyect.getContentPane().add(btnhelp, gbc_btnhelp);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAjustes vx = new VentanaAjustes(us);
				vx.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/ajustes.jpg")));
		button.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 15;
		frmIproyect.getContentPane().add(button, gbc_button);
	
		
		
		
	}
	public void darLista() {
		proyectos.clear();
		for ( int i = 0; i < ag.getProyectos().size(); i++ ){
			if (ag.getProyectos().get(i).getUsuario()==us) proyectos.addElement(ag.getProyectos().get(i).getNombre() );
		}
		
	}
	public void cargarDialogoProyecto(Proyecto p) {
		VentanaEdicionProyecto vx;
		if (p==null) vx = new VentanaEdicionProyecto(this, us);
		else {
			vx = new VentanaEdicionProyecto(this,p);
		}
		vx.setModal(true);
		vx.setVisible(true);
		
	}

}
