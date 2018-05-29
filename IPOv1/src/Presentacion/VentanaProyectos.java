package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Dominio.Usuario;
import Persistencia.Agente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
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
import javax.swing.DefaultListModel;
import javax.swing.ScrollPaneConstants;

public class VentanaProyectos {

	private JFrame frmIproyect;
	private Usuario us;
	/**
	 * Create the application.
	 */
	public VentanaProyectos (Usuario us) {
		this.us=us;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIproyect = new JFrame();
		frmIproyect.setTitle("IPROyect");
		frmIproyect.setResizable(false);
		Dimension rectangulo = Toolkit.getDefaultToolkit().getScreenSize();
		frmIproyect.setBounds(0,0, rectangulo.width-50, rectangulo.height-50);
		frmIproyect.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmIproyect.setVisible(true);
		frmIproyect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, 52, 47, 62, 46, 52, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{8, 42, 71, 31, 35, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmIproyect.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		frmIproyect.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel user_image = new JPanel();
		GridBagConstraints gbc_user_image = new GridBagConstraints();
		gbc_user_image.gridheight = 2;
		gbc_user_image.insets = new Insets(0, 0, 5, 5);
		gbc_user_image.fill = GridBagConstraints.BOTH;
		gbc_user_image.gridx = 3;
		gbc_user_image.gridy = 1;
		frmIproyect.getContentPane().add(user_image, gbc_user_image);
		
		JLabel lblBienvenido = new JLabel("Bienvenido:");
		lblBienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.anchor = GridBagConstraints.EAST;
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenido.gridx = 4;
		gbc_lblBienvenido.gridy = 1;
		frmIproyect.getContentPane().add(lblBienvenido, gbc_lblBienvenido);
		
		JLabel lblX = new JLabel(us.getNombre());
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.anchor = GridBagConstraints.WEST;
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 5;
		gbc_lblX.gridy = 1;
		frmIproyect.getContentPane().add(lblX, gbc_lblX);
		
		JLabel lblUltimaConexion = new JLabel("Ultima conexion:");
		GridBagConstraints gbc_lblUltimaConexion = new GridBagConstraints();
		gbc_lblUltimaConexion.anchor = GridBagConstraints.WEST;
		gbc_lblUltimaConexion.insets = new Insets(0, 0, 5, 5);
		gbc_lblUltimaConexion.gridx = 4;
		gbc_lblUltimaConexion.gridy = 2;
		frmIproyect.getContentPane().add(lblUltimaConexion, gbc_lblUltimaConexion);
		
		JLabel lblXUltimaConexion = new JLabel(us.getFechaString());
		lblXUltimaConexion.setVerticalAlignment(SwingConstants.TOP);
		lblXUltimaConexion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblXUltimaConexion = new GridBagConstraints();
		gbc_lblXUltimaConexion.anchor = GridBagConstraints.WEST;
		gbc_lblXUltimaConexion.gridwidth = 3;
		gbc_lblXUltimaConexion.insets = new Insets(0, 0, 5, 5);
		gbc_lblXUltimaConexion.gridx = 5;
		gbc_lblXUltimaConexion.gridy = 2;
		frmIproyect.getContentPane().add(lblXUltimaConexion, gbc_lblXUltimaConexion);
		
		JLabel lblMisProyectos = new JLabel("Mis proyectos");
		GridBagConstraints gbc_lblMisProyectos = new GridBagConstraints();
		gbc_lblMisProyectos.anchor = GridBagConstraints.SOUTH;
		gbc_lblMisProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_lblMisProyectos.gridx = 1;
		gbc_lblMisProyectos.gridy = 3;
		frmIproyect.getContentPane().add(lblMisProyectos, gbc_lblMisProyectos);
		
		JTabbedPane display_tab = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_display_tab = new GridBagConstraints();
		gbc_display_tab.insets = new Insets(0, 0, 0, 5);
		gbc_display_tab.gridheight = 14;
		gbc_display_tab.gridwidth = 11;
		gbc_display_tab.fill = GridBagConstraints.BOTH;
		gbc_display_tab.gridx = 4;
		gbc_display_tab.gridy = 3;
		frmIproyect.getContentPane().add(display_tab, gbc_display_tab);
		
		JPanel info_panel = new JPanel();
		display_tab.addTab("Información", null, info_panel, null);
		display_tab.setEnabledAt(0, true);
		GridBagLayout gbl_info_panel = new GridBagLayout();
		gbl_info_panel.columnWidths = new int[]{4, 70, 46, 162, 88, 0, 0, 0};
		gbl_info_panel.rowHeights = new int[]{33, 35, 30, 35, 29, 29, 97, 98, 0, 0};
		gbl_info_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_info_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		info_panel.setLayout(gbl_info_panel);
		
		JLabel lblProyectoNombre = new JLabel("Nombre del proyecto:");
		GridBagConstraints gbc_lblProyectoNombre = new GridBagConstraints();
		gbc_lblProyectoNombre.anchor = GridBagConstraints.EAST;
		gbc_lblProyectoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblProyectoNombre.gridx = 1;
		gbc_lblProyectoNombre.gridy = 0;
		info_panel.add(lblProyectoNombre, gbc_lblProyectoNombre);
		
		JLabel lblFechaCreacion = new JLabel("Fecha creacion:");
		GridBagConstraints gbc_lblFechaCreacion = new GridBagConstraints();
		gbc_lblFechaCreacion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaCreacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaCreacion.gridx = 1;
		gbc_lblFechaCreacion.gridy = 1;
		info_panel.add(lblFechaCreacion, gbc_lblFechaCreacion);
		
		JLabel lblCreador = new JLabel("Creador:");
		GridBagConstraints gbc_lblCreador = new GridBagConstraints();
		gbc_lblCreador.anchor = GridBagConstraints.EAST;
		gbc_lblCreador.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreador.gridx = 1;
		gbc_lblCreador.gridy = 2;
		info_panel.add(lblCreador, gbc_lblCreador);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 3;
		info_panel.add(lblEstado, gbc_lblEstado);
		
		JLabel lblFechaEstimadaDe = new JLabel("Fecha estimada de fin:");
		GridBagConstraints gbc_lblFechaEstimadaDe = new GridBagConstraints();
		gbc_lblFechaEstimadaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEstimadaDe.gridx = 1;
		gbc_lblFechaEstimadaDe.gridy = 4;
		info_panel.add(lblFechaEstimadaDe, gbc_lblFechaEstimadaDe);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 5;
		info_panel.add(lblDescripcin, gbc_lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 6;
		info_panel.add(textArea, gbc_textArea);
		
		JPanel tareas_panel = new JPanel();
		display_tab.addTab("Tareas", null, tareas_panel, null);
		display_tab.setEnabledAt(1, true);
		
		JPanel chat_panel = new JPanel();
		display_tab.addTab("Chat", null, chat_panel, null);
		chat_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(549, 5, 46, 14);
		chat_panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 13;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		frmIproyect.getContentPane().add(scrollPane, gbc_scrollPane);

		DefaultListModel<String> proyects = new DefaultListModel<>();
		JList<String> list = new JList<>(proyects);
		Agente st = Agente.getInstance();
		for ( int i = 0; i < st.getProyectos().size(); i++ ){
			if (st.getProyectos().get(i).getUsuario()==us) proyects.addElement(st.getProyectos().get(i).getNombre() );
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(25);
		list.setMaximumSize(new Dimension(100, 100));
		scrollPane.setViewportView(list);
		
	}
}
