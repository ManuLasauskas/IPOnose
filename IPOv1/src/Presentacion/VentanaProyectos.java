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

import Dominio.Proyecto;
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

public class VentanaProyectos {

	private JFrame frmIproyect;
	private Usuario us;
	private Agente ag = Agente.getInstance();

	/**
	 * Create the application.
	 */
	public VentanaProyectos (Usuario us) {
		this.us=us;
		System.out.println(this.us);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIproyect = new JFrame();
		frmIproyect.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaProyectos.class.getResource("/Resources/iproject.png")));
		frmIproyect.setTitle("IPROyect");
		frmIproyect.setResizable(false);
		Dimension rectangulo = Toolkit.getDefaultToolkit().getScreenSize();
		frmIproyect.setBounds(0,0, rectangulo.width-50, rectangulo.height-50);
		frmIproyect.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmIproyect.setVisible(true);
		frmIproyect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, 76, 21, 0, 0, 38, 0, 46, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{8, 42, 75, 10, 36, 35, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmIproyect.getContentPane().setLayout(gridBagLayout);
		
		JPanel user_image = new JPanel();
		GridBagConstraints gbc_user_image = new GridBagConstraints();
		gbc_user_image.gridwidth = 2;
		gbc_user_image.gridheight = 3;
		gbc_user_image.insets = new Insets(0, 0, 5, 5);
		gbc_user_image.fill = GridBagConstraints.BOTH;
		gbc_user_image.gridx = 1;
		gbc_user_image.gridy = 1;
		frmIproyect.getContentPane().add(user_image, gbc_user_image);
		
		if(!us.getImage().equals("")) {
			Imagen im = new Imagen(us.getImage(),user_image);
        user_image.add(im).repaint();
		}
		
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
		gbc_lblMisProyectos.anchor = GridBagConstraints.SOUTH;
		gbc_lblMisProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_lblMisProyectos.gridx = 1;
		gbc_lblMisProyectos.gridy = 4;
		frmIproyect.getContentPane().add(lblMisProyectos, gbc_lblMisProyectos);
		
		JButton btnadd = new JButton("");
		btnadd.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/Anadir.png")));
		btnadd.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnadd = new GridBagConstraints();
		gbc_btnadd.anchor = GridBagConstraints.EAST;
		gbc_btnadd.insets = new Insets(0, 0, 5, 5);
		gbc_btnadd.gridx = 4;
		gbc_btnadd.gridy = 4;
		frmIproyect.getContentPane().add(btnadd, gbc_btnadd);
		
		JButton btnedit = new JButton("");
		btnedit.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/lapiz.png")));
		btnedit.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnedit = new GridBagConstraints();
		gbc_btnedit.insets = new Insets(0, 0, 5, 5);
		gbc_btnedit.gridx = 5;
		gbc_btnedit.gridy = 4;
		frmIproyect.getContentPane().add(btnedit, gbc_btnedit);
		
		JButton btndelete = new JButton("");
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
		gbc_display_tab.gridheight = 14;
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
		display_tab.addTab("Chat", null, chat_panel, null);
		chat_panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 12;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		frmIproyect.getContentPane().add(scrollPane, gbc_scrollPane);
		
		DefaultListModel<String> proyects = new DefaultListModel<>();
		JList list = new JList(proyects);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
					String p = proyects.get(list.getSelectedIndex());
					Proyecto pr=null;
					for (int j=0;j<ag.getProyectos().size();j++) {
						if (String.valueOf(ag.getProyectos().get(j).getNombre()).equals(p)) pr=ag.getProyectos().get(j);
					}
					panel.fill(pr);
					System.out.println(list.getSelectedValue());
					tareas_panel.setEnabled(true);
					tareas_panel.eliminarTareas();
					tareas_panel.mostrarTareas(pr);
					
					
				
			}
		});
		for ( int i = 0; i < ag.getProyectos().size(); i++ ){
			if (ag.getProyectos().get(i).getUsuario()==us) proyects.addElement(ag.getProyectos().get(i).getNombre() );
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);

		
		
	}

}
