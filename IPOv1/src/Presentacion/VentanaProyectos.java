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
				if (JOptionPane.showConfirmDialog(new JFrame(), MessagesIPROject.getString("VentanaProyectos.MsgCerrarApp"), MessagesIPROject.getString("VentanaProyectos.TituloCerrando"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) { //$NON-NLS-1$ //$NON-NLS-2$
					System.exit(0);
				}
				
			}
		});
		frmIproyect.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaProyectos.class.getResource("/Resources/logg.png"))); //$NON-NLS-1$
		frmIproyect.setTitle(MessagesIPROject.getString("VentanaProyectos.titulo")); //$NON-NLS-1$
		frmIproyect.setResizable(false);
		Dimension rectangulo = Toolkit.getDefaultToolkit().getScreenSize();
		frmIproyect.setBounds(0,0, rectangulo.width-50, rectangulo.height-50);
		frmIproyect.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmIproyect.setVisible(true);
		
		frmIproyect.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, 40, 46, 0, 0, 38, 0, 46, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{8, 42, 75, 10, 36, 35, 37, 0, 0, 0, 0, 0, 0, 0, 34, 0, 56, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmIproyect.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblImage = new JLabel(""); //$NON-NLS-1$
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		lblImage.setIcon(new ImageIcon(us.getImage()));
		gbc_lblImage.gridwidth = 2;
		gbc_lblImage.gridheight = 2;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 1;
		frmIproyect.getContentPane().add(lblImage, gbc_lblImage);
		
		JLabel lblBienvenido = new JLabel(MessagesIPROject.getString("VentanaProyectos.lblBienvenido.text_1")); //$NON-NLS-1$
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
		
		JLabel lblUltimaConexion = new JLabel(MessagesIPROject.getString("VentanaProyectos.lblUltimaConexion.text_1")); //$NON-NLS-1$
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
		
		JLabel lblMisProyectos = new JLabel(MessagesIPROject.getString("VentanaProyectos.lblMisProyectos.text_1")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMisProyectos = new GridBagConstraints();
		gbc_lblMisProyectos.gridwidth = 2;
		gbc_lblMisProyectos.anchor = GridBagConstraints.SOUTH;
		gbc_lblMisProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_lblMisProyectos.gridx = 1;
		gbc_lblMisProyectos.gridy = 4;
		frmIproyect.getContentPane().add(lblMisProyectos, gbc_lblMisProyectos);
		
		JButton btnadd = new JButton(""); //$NON-NLS-1$
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnadd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cargarDialogoProyecto(null);
				darLista();
			}
		});
		btnadd.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/Anadir.png"))); //$NON-NLS-1$
		btnadd.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnadd = new GridBagConstraints();
		gbc_btnadd.anchor = GridBagConstraints.EAST;
		gbc_btnadd.insets = new Insets(0, 0, 5, 5);
		gbc_btnadd.gridx = 4;
		gbc_btnadd.gridy = 4;
		frmIproyect.getContentPane().add(btnadd, gbc_btnadd);
		
		btnedit = new JButton(""); //$NON-NLS-1$
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!list.isSelectionEmpty()) {
					seleccion=ag.BuscarProyecto(list.getSelectedValue().toString());
					cargarDialogoProyecto(seleccion);
					darLista();
				}
			}
		});
		btnedit.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/lapiz.png"))); //$NON-NLS-1$
		btnedit.setBorder(BorderFactory.createEmptyBorder());
		btnedit.setEnabled(false);
		GridBagConstraints gbc_btnedit = new GridBagConstraints();
		gbc_btnedit.insets = new Insets(0, 0, 5, 5);
		gbc_btnedit.gridx = 5;
		gbc_btnedit.gridy = 4;
		frmIproyect.getContentPane().add(btnedit, gbc_btnedit);
		
		JButton btndelete = new JButton(""); //$NON-NLS-1$
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndelete.setEnabled(false);
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!list.isSelectionEmpty()) {
					list.remove(list.getSelectedIndex());
					proyectos.removeElement(seleccion.getNombre());
					us.EliminarProyecto(seleccion.getNombre());
				}

				
				}
		});
		btndelete.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/papelera.png"))); //$NON-NLS-1$
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
		gbc_display_tab.gridheight = 14;
		gbc_display_tab.gridwidth = 11;
		gbc_display_tab.fill = GridBagConstraints.BOTH;
		gbc_display_tab.gridx = 7;
		gbc_display_tab.gridy = 4;
		frmIproyect.getContentPane().add(display_tab, gbc_display_tab);
		
		
		InfoProyecto panel = new InfoProyecto();
		display_tab.addTab(MessagesIPROject.getString("VentanaProyectos.Informacion"), null, panel, null); //$NON-NLS-1$
		PanelTareas tareas_panel = new PanelTareas(seleccion);
		tareas_panel.setEnabled(false);
		display_tab.addTab(MessagesIPROject.getString("VentanaProyectos.Tareas"), null, tareas_panel, null); //$NON-NLS-1$
		
		JPanel chat_panel = new UserChat(us);
		chat_panel.setEnabled(false);
		display_tab.addTab(MessagesIPROject.getString("VentanaProyectos.Chat"), null, chat_panel, null); //$NON-NLS-1$

		
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
					seleccion=ag.BuscarProyecto(p);

				}
				
				if (seleccion!=null) panel.fill(seleccion);
					tareas_panel.setEnabled(true);
					tareas_panel.eliminarTareas();
					tareas_panel.mostrarTareas(seleccion);

			}
		});
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnhelp = new JButton(""); //$NON-NLS-1$
		btnhelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DialogAyuda vh = new DialogAyuda();
				vh.setVisible(true);
				
			}
		});
		btnhelp.setMnemonic('H');
		btnhelp.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/help.png"))); //$NON-NLS-1$
		btnhelp.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnhelp = new GridBagConstraints();
		gbc_btnhelp.insets = new Insets(0, 0, 5, 5);
		gbc_btnhelp.gridx = 1;
		gbc_btnhelp.gridy = 15;
		frmIproyect.getContentPane().add(btnhelp, gbc_btnhelp);
		
		JButton button = new JButton(""); //$NON-NLS-1$
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAjustes vx = new VentanaAjustes(us);
				vx.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/ajustes.jpg"))); //$NON-NLS-1$
		button.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 15;
		frmIproyect.getContentPane().add(button, gbc_button);
		
		JButton button_1 = new JButton(""); //$NON-NLS-1$
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessagesIPROject.setIdioma("");
				VentanaProyectos nueva = new VentanaProyectos(us);
				nueva.frmIproyect.setVisible(true);
				frmIproyect.dispose();
			}
		});
		button_1.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/spain.jpg"))); //$NON-NLS-1$
		button_1.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.NORTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 16;
		frmIproyect.getContentPane().add(button_1, gbc_button_1);
		
		JButton btnNewButton = new JButton(""); //$NON-NLS-1$
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessagesIPROject.setIdioma("inglés");
				VentanaProyectos nueva = new VentanaProyectos(us);
				nueva.frmIproyect.setVisible(true);
				frmIproyect.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/ingles.png"))); //$NON-NLS-1$
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 16;
		frmIproyect.getContentPane().add(btnNewButton, gbc_btnNewButton);
	
		
		
		
	}
	public void darLista() {
		proyectos.clear();
		for ( int i = 0; i < us.getproyectos().size(); i++ ){
			proyectos.addElement(us.getproyectos().get(i).getNombre());
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
