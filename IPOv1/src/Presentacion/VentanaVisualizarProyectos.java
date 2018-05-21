package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTable;

public class VentanaVisualizarProyectos {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVisualizarProyectos window = new VentanaVisualizarProyectos();
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
	public VentanaVisualizarProyectos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 684, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{31, 91, 99, 86, 138, 44, 138, 38, 0};
		gridBagLayout.rowHeights = new int[]{48, 20, 40, 23, 26, 30, 0, 54, 51, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 0;
		frame.getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		JLabel lblUltimaConexion = new JLabel("Ultima Conexion:");
		GridBagConstraints gbc_lblUltimaConexion = new GridBagConstraints();
		gbc_lblUltimaConexion.insets = new Insets(0, 0, 5, 5);
		gbc_lblUltimaConexion.gridx = 2;
		gbc_lblUltimaConexion.gridy = 0;
		frame.getContentPane().add(lblUltimaConexion, gbc_lblUltimaConexion);
		
		JLabel lblTimeconex = new JLabel("timeconex");
		GridBagConstraints gbc_lblTimeconex = new GridBagConstraints();
		gbc_lblTimeconex.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeconex.gridx = 3;
		gbc_lblTimeconex.gridy = 0;
		frame.getContentPane().add(lblTimeconex, gbc_lblTimeconex);
		
		JLabel lblNombreDelProyecto = new JLabel("Nombre del proyecto");
		GridBagConstraints gbc_lblNombreDelProyecto = new GridBagConstraints();
		gbc_lblNombreDelProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelProyecto.gridx = 4;
		gbc_lblNombreDelProyecto.gridy = 0;
		frame.getContentPane().add(lblNombreDelProyecto, gbc_lblNombreDelProyecto);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 7;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		
		table = new JTable();
		panel.add(table);
		
		table_1 = new JTable();
		panel.add(table_1);
		
		JButton btnCambiarVista = new JButton("Cambiar Vista");
		GridBagConstraints gbc_btnCambiarVista = new GridBagConstraints();
		gbc_btnCambiarVista.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarVista.gridx = 6;
		gbc_btnCambiarVista.gridy = 2;
		frame.getContentPane().add(btnCambiarVista, gbc_btnCambiarVista);
		
		JButton btnAadirTarea = new JButton("A\u00F1adir Tarea");
		GridBagConstraints gbc_btnAadirTarea = new GridBagConstraints();
		gbc_btnAadirTarea.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadirTarea.gridx = 6;
		gbc_btnAadirTarea.gridy = 4;
		frame.getContentPane().add(btnAadirTarea, gbc_btnAadirTarea);
		
		JButton btnEditarTarea = new JButton("Editar Tarea");
		GridBagConstraints gbc_btnEditarTarea = new GridBagConstraints();
		gbc_btnEditarTarea.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditarTarea.gridx = 6;
		gbc_btnEditarTarea.gridy = 5;
		frame.getContentPane().add(btnEditarTarea, gbc_btnEditarTarea);
		
		JButton btnEliminarTarea = new JButton("Eliminar Tarea");
		GridBagConstraints gbc_btnEliminarTarea = new GridBagConstraints();
		gbc_btnEliminarTarea.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarTarea.gridx = 6;
		gbc_btnEliminarTarea.gridy = 6;
		frame.getContentPane().add(btnEliminarTarea, gbc_btnEliminarTarea);
		
		JButton btnSalirDelProyecto = new JButton("Salir del Proyecto");
		GridBagConstraints gbc_btnSalirDelProyecto = new GridBagConstraints();
		gbc_btnSalirDelProyecto.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalirDelProyecto.gridx = 6;
		gbc_btnSalirDelProyecto.gridy = 8;
		frame.getContentPane().add(btnSalirDelProyecto, gbc_btnSalirDelProyecto);
	}

}
