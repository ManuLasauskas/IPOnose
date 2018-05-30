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
import Persistencia.Agente;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class InfoProyecto extends JPanel {
	private GridBagLayout gridBagLayout;
	private JLabel lblNombre;
	private JLabel lblProyecto;
	private JLabel lblUsuariosAsignados;
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
	private Agente ag = Agente.getInstance();
	private JScrollPane scrollPane;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public InfoProyecto() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 105, 139, 105, 0, 110, 108, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 42, 29, 43, 37, 38, 34, 114, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		lblProyecto = new JLabel("");
		lblProyecto.setFont(new Font("Calibri", Font.BOLD, 12));
		lblProyecto.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblProyecto, gbc_lblNewLabel);
		
		lblUsuariosAsignados = new JLabel("Usuarios asignados");
		GridBagConstraints gbc_lblUsuariosAsignados = new GridBagConstraints();
		gbc_lblUsuariosAsignados.gridwidth = 3;
		gbc_lblUsuariosAsignados.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuariosAsignados.gridx = 4;
		gbc_lblUsuariosAsignados.gridy = 1;
		add(lblUsuariosAsignados, gbc_lblUsuariosAsignados);
		
		lblFechaCreacion = new JLabel("Fecha de creación");
		GridBagConstraints gbc_lblFechaCreacion = new GridBagConstraints();
		gbc_lblFechaCreacion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaCreacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaCreacion.gridx = 1;
		gbc_lblFechaCreacion.gridy = 2;
		add(lblFechaCreacion, gbc_lblFechaCreacion);
		
		lblFechacreado = new JLabel("");
		lblFechacreado.setFont(new Font("Calibri", Font.BOLD, 12));
		GridBagConstraints gbc_lblFechacreado = new GridBagConstraints();
		gbc_lblFechacreado.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechacreado.gridx = 2;
		gbc_lblFechacreado.gridy = 2;
		add(lblFechacreado, gbc_lblFechacreado);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Asignado/No"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		for (int i =0;i<ag.getUsuarios().size();i++) {
			Object[] fila = new Object[2];
			fila[0]=ag.getUsuarios().get(i).getUsuario();
			fila[1]=false;
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
		scrollPane.setViewportView(table);
		

		
		lblFechaDeFinalizacion = new JLabel("Fecha de finalización");
		GridBagConstraints gbc_lblFechaDeFinalizacin = new GridBagConstraints();
		gbc_lblFechaDeFinalizacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacin.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFinalizacin.gridx = 1;
		gbc_lblFechaDeFinalizacin.gridy = 3;
		add(lblFechaDeFinalizacion, gbc_lblFechaDeFinalizacin);
		
		lblFechafin = new JLabel("");
		lblFechafin.setFont(new Font("Calibri", Font.BOLD, 12));
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
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
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
		
		lblNombrecreador = new JLabel("");
		lblNombrecreador.setFont(new Font("Calibri", Font.BOLD, 12));
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
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 7;
		add(textArea, gbc_textArea);

	}
	public void fill(Proyecto p) {
		lblNombrecreador.setText(p.getUsuario().getNombre());
		textArea.setText(p.getDescripcion());
		comboBox.setSelectedItem(p.getEstado());
		lblFechafin.setText(p.getFechaFinFormateada());
		lblFechacreado.setText(p.getFechaCreacionFormateada());
		lblProyecto.setText(p.getNombre());
		for (int i =0;i<table.getRowCount();i++) {
			for (int j =0;j<p.getAsociados().size();j++)
				if (String.valueOf(table.getValueAt(i, 0)).equals(p.getAsociados().get(j).getUsuario())) table.setValueAt(true, i, 1);
		}
		
		// RELLENAR TABLA DE USUARIO
	}

}
