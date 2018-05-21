package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class VentanaProyectos {

	private JFrame frame;
	private JLabel lblBienvenidoX;
	private JPanel panel;
	private JList<String> list;
	private JButton btnAadirProyecto;
	private JButton btnEliminarProyecto;
	private JButton btnEditarTareasDel;
	private JButton btnEditarProyecto;
	private JLabel lblNombreDelProyeccto;
	private JLabel lblNameproyect;
	private JLabel lblNewLabel;
	private JLabel lblDateproyect;
	private JLabel lblNewLabel_1;
	private JLabel lblOwner;
	private JLabel lblFinalizado;
	private JCheckBox chckbxNosi;
	private JLabel lblMiembrosDelEquipo;
	private JLabel lblDescripcion;
	private JTextPane textPane;
	private JButton btnSalir;
	private JList<String> list_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProyectos window = new VentanaProyectos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaProyectos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(33dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(26dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(121dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(8dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(203dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(368dlu;default)"),}));
		{
			lblBienvenidoX = new JLabel("Bienvenido : X. Ultima Conexión: XX");
			lblBienvenidoX.setFont(new Font("Times New Roman", Font.BOLD, 13));
			frame.getContentPane().add(lblBienvenidoX, "2, 4, 3, 1, left, default");
		}
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Mis proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			frame.getContentPane().add(panel, "2, 6, 11, 7, fill, fill");
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 170, 0};
			gbl_panel.rowHeights = new int[]{48, 414, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				btnAadirProyecto = new JButton("Añadir Proyecto");
				btnAadirProyecto.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/add.png")));
				GridBagConstraints gbc_btnAadirProyecto = new GridBagConstraints();
				gbc_btnAadirProyecto.fill = GridBagConstraints.VERTICAL;
				gbc_btnAadirProyecto.insets = new Insets(0, 0, 5, 5);
				gbc_btnAadirProyecto.gridx = 0;
				gbc_btnAadirProyecto.gridy = 0;
				panel.add(btnAadirProyecto, gbc_btnAadirProyecto);
			}
			{
				btnEliminarProyecto = new JButton("Eliminar Proyecto");
				btnEliminarProyecto.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/trash.png")));
				GridBagConstraints gbc_btnEliminarProyecto = new GridBagConstraints();
				gbc_btnEliminarProyecto.fill = GridBagConstraints.VERTICAL;
				gbc_btnEliminarProyecto.insets = new Insets(0, 0, 5, 5);
				gbc_btnEliminarProyecto.gridx = 1;
				gbc_btnEliminarProyecto.gridy = 0;
				panel.add(btnEliminarProyecto, gbc_btnEliminarProyecto);
			}
			{
				{
					btnEditarProyecto = new JButton("Editar Proyecto");
					btnEditarProyecto.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/edit.png")));
					GridBagConstraints gbc_btnEditarProyecto = new GridBagConstraints();
					gbc_btnEditarProyecto.fill = GridBagConstraints.VERTICAL;
					gbc_btnEditarProyecto.insets = new Insets(0, 0, 5, 5);
					gbc_btnEditarProyecto.gridx = 2;
					gbc_btnEditarProyecto.gridy = 0;
					panel.add(btnEditarProyecto, gbc_btnEditarProyecto);
				}
			}
			{
				list = new JList();
				GridBagConstraints gbc_list = new GridBagConstraints();
				gbc_list.gridwidth = 2;
				gbc_list.insets = new Insets(0, 0, 5, 5);
				gbc_list.fill = GridBagConstraints.BOTH;
				gbc_list.gridx = 0;
				gbc_list.gridy = 1;
				panel.add(list, gbc_list);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setForeground(Color.WHITE);
				panel_1.setLayout(null);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.gridwidth = 2;
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 2;
				gbc_panel_1.gridy = 1;
				panel.add(panel_1, gbc_panel_1);
				{
					lblNombreDelProyeccto = new JLabel("Nombre del Proyecto");
					lblNombreDelProyeccto.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblNombreDelProyeccto.setBounds(10, 45, 127, 19);
					panel_1.add(lblNombreDelProyeccto);
				}
				{
					lblNameproyect = new JLabel("NameProyect");
					lblNameproyect.setBounds(147, 47, 119, 14);
					panel_1.add(lblNameproyect);
				}
				{
					lblNewLabel = new JLabel("Fecha de creación");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblNewLabel.setBounds(10, 75, 127, 14);
					panel_1.add(lblNewLabel);
				}
				{
					lblDateproyect = new JLabel("DateProyect");
					lblDateproyect.setBounds(147, 75, 119, 14);
					panel_1.add(lblDateproyect);
				}
				{
					lblNewLabel_1 = new JLabel("Responsable");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblNewLabel_1.setBounds(10, 100, 100, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					lblOwner = new JLabel("Owner");
					lblOwner.setBounds(146, 100, 46, 14);
					panel_1.add(lblOwner);
				}
				{
					lblFinalizado = new JLabel("Finalizado");
					lblFinalizado.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblFinalizado.setBounds(10, 125, 56, 14);
					panel_1.add(lblFinalizado);
				}
				{
					chckbxNosi = new JCheckBox("No/si");
					chckbxNosi.setBounds(147, 121, 97, 23);
					panel_1.add(chckbxNosi);
				}
				{
					lblMiembrosDelEquipo = new JLabel("Miembros del equipo");
					lblMiembrosDelEquipo.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblMiembrosDelEquipo.setBounds(10, 150, 127, 14);
					panel_1.add(lblMiembrosDelEquipo);
				}
				{
					list_1 = new JList();
					list_1.setBackground(Color.BLACK);
					list_1.setBounds(10, 237, 265, -61);
					panel_1.add(list_1);
				}
				{
					lblDescripcion = new JLabel("Descripcion");
					lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblDescripcion.setBounds(10, 258, 65, 14);
					panel_1.add(lblDescripcion);
				}
				{
					textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBounds(10, 291, 295, 123);
					panel_1.add(textPane);
				}
			}
			btnEditarTareasDel = new JButton("Ver/editar tareas");
			btnEditarTareasDel.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/view.png")));
			btnEditarTareasDel.addActionListener(new BtnEditarTareasDelActionListener());
			{
				btnSalir = new JButton("SALIR");
				btnSalir.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/exit.png")));
				GridBagConstraints gbc_btnSalir = new GridBagConstraints();
				gbc_btnSalir.fill = GridBagConstraints.VERTICAL;
				gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
				gbc_btnSalir.gridx = 0;
				gbc_btnSalir.gridy = 2;
				panel.add(btnSalir, gbc_btnSalir);
			}
			GridBagConstraints gbc_btnEditarTareasDel = new GridBagConstraints();
			gbc_btnEditarTareasDel.fill = GridBagConstraints.VERTICAL;
			gbc_btnEditarTareasDel.gridwidth = 2;
			gbc_btnEditarTareasDel.gridx = 2;
			gbc_btnEditarTareasDel.gridy = 2;
			panel.add(btnEditarTareasDel, gbc_btnEditarTareasDel);
		}
	}

	private class BtnEditarTareasDelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}
