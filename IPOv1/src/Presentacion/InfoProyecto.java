package Presentacion;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;

import Dominio.Estado;
import Dominio.Proyecto;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;

public class InfoProyecto extends JPanel {
	private JTable table;
	private GridBagLayout gridBagLayout;
	private JLabel lblNombre;
	private JLabel lblNewLabel;
	private JLabel lblListaDeUsuarios;
	private JLabel lblFechaCreacion;
	private JLabel lblFechacreado;
	private JLabel lblFechaDeFinalizacion;
	private JLabel lblFechafin;
	private JLabel lblEstado;
	private JComboBox comboBox;
	private JLabel lblCreador;
	private JLabel lblNombrecreador;
	private JLabel lblDescripcion;
	private JTextArea textArea;
	
	
	/**
	 * Create the panel.
	 */
	public InfoProyecto() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 105, 139, 211, 0, 0, 157, 0};
		gridBagLayout.rowHeights = new int[]{0, 28, 29, 31, 25, 25, 22, 175, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		lblNewLabel = new JLabel("Nombre_proyecto");
		lblNewLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblListaDeUsuarios = new JLabel("Lista de usuarios");
		GridBagConstraints gbc_lblListaDeUsuarios = new GridBagConstraints();
		gbc_lblListaDeUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblListaDeUsuarios.gridx = 6;
		gbc_lblListaDeUsuarios.gridy = 1;
		add(lblListaDeUsuarios, gbc_lblListaDeUsuarios);
		
		lblFechaCreacion = new JLabel("Fecha de creación");
		GridBagConstraints gbc_lblFechaCreacion = new GridBagConstraints();
		gbc_lblFechaCreacion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaCreacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaCreacion.gridx = 1;
		gbc_lblFechaCreacion.gridy = 2;
		add(lblFechaCreacion, gbc_lblFechaCreacion);
		
		lblFechacreado = new JLabel("Fecha_creado");
		GridBagConstraints gbc_lblFechacreado = new GridBagConstraints();
		gbc_lblFechacreado.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechacreado.gridx = 2;
		gbc_lblFechacreado.gridy = 2;
		add(lblFechacreado, gbc_lblFechacreado);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 5;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 6;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		
		lblFechaDeFinalizacion = new JLabel("Fecha de finalización");
		GridBagConstraints gbc_lblFechaDeFinalizacin = new GridBagConstraints();
		gbc_lblFechaDeFinalizacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacin.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFinalizacin.gridx = 1;
		gbc_lblFechaDeFinalizacin.gridy = 3;
		add(lblFechaDeFinalizacion, gbc_lblFechaDeFinalizacin);
		
		lblFechafin = new JLabel("Fecha_fin");
		GridBagConstraints gbc_lblFechafin = new GridBagConstraints();
		gbc_lblFechafin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechafin.gridx = 2;
		gbc_lblFechafin.gridy = 3;
		add(lblFechafin, gbc_lblFechafin);
		
		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 4;
		add(lblEstado, gbc_lblEstado);
		
		comboBox = new JComboBox(Estado.values());
		comboBox.setEditable(true);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		lblCreador = new JLabel("Creador");
		GridBagConstraints gbc_lblCreador = new GridBagConstraints();
		gbc_lblCreador.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreador.anchor = GridBagConstraints.EAST;
		gbc_lblCreador.gridx = 1;
		gbc_lblCreador.gridy = 5;
		add(lblCreador, gbc_lblCreador);
		
		lblNombrecreador = new JLabel("Nombre_creador");
		GridBagConstraints gbc_lblNombrecreador = new GridBagConstraints();
		gbc_lblNombrecreador.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombrecreador.gridx = 2;
		gbc_lblNombrecreador.gridy = 5;
		add(lblNombrecreador, gbc_lblNombrecreador);
		
		lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 6;
		add(lblDescripcion, gbc_lblDescripcion);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 7;
		add(textArea, gbc_textArea);

	}
	public void fill(Proyecto p) {
		lblNombrecreador.setText(p.getUsuario().getNombre());
		textArea.setText(p.getDescripcion());
		comboBox.setSelectedItem(p.getEstado());
		lblFechafin.setText(p.getFechaFin().toString());
		lblFechacreado.setText(p.getFechaCreacion().toString());
		lblNombre.setText(p.getNombre());
		
		// RELLENAR TABLA DE USUARIO
	}

}
