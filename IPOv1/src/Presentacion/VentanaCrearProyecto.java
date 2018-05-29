package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JList;

public class VentanaCrearProyecto {

	private JFrame frame;
	private JPanel panel;
	private JButton btnCrearProyecto;
	private JPanel panel_1;
	private JLabel lblNombreDelNuevo;
	private JTextField textField;
	private JLabel lblUsuariosAdjuntos;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearProyecto window = new VentanaCrearProyecto();
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
	public VentanaCrearProyecto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnCrearProyecto = new JButton("Crear Proyecto");
		panel.add(btnCrearProyecto);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 178, 217, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 24, 19, 159, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblNombreDelNuevo = new JLabel("Nombre del nuevo proyecto:");
		GridBagConstraints gbc_lblNombreDelNuevo = new GridBagConstraints();
		gbc_lblNombreDelNuevo.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelNuevo.gridx = 1;
		gbc_lblNombreDelNuevo.gridy = 1;
		panel_1.add(lblNombreDelNuevo, gbc_lblNombreDelNuevo);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblUsuariosAdjuntos = new JLabel("Usuarios Adjuntos:");
		GridBagConstraints gbc_lblUsuariosAdjuntos = new GridBagConstraints();
		gbc_lblUsuariosAdjuntos.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuariosAdjuntos.gridx = 1;
		gbc_lblUsuariosAdjuntos.gridy = 3;
		panel_1.add(lblUsuariosAdjuntos, gbc_lblUsuariosAdjuntos);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 2;
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 3;
		panel_1.add(list, gbc_list);
	}

}
