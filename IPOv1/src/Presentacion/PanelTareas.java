package Presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import Dominio.EndDateComparator;
import Dominio.Estado;
import Dominio.InitDateComparator;
import Dominio.Prioridad;
import Dominio.Proyecto;
import Dominio.Tarea;
import Persistencia.Agente;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelTareas extends JPanel {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lblOrdenarPor;
	private JComboBox<String> sortComboBox;
	private JList<String> tasklist;
	private JPanel panel_1;
	private JLabel lblNombreDeTarea;
	private JLabel lblFechaDeComienzo;
	private JLabel lblFechaEstimadaDe;
	private JLabel lblEstado;
	private JRadioButton rdbtnCompletada;
	private JLabel lblResponsable;
	private JLabel lblBreveDescripcin;
	private JRadioButton rdbtnActiva;
	private JRadioButton rdbtnTardia;
	private JLabel lblPrioridad;
	private JSlider slider;
	private JTextArea txtDescripcion;
	private JLabel lblListaDeSubtareas;
	private JList subtasklist;
	private JLabel lblImagen;
	private JLabel label;
	private JLabel lblName;
	private JLabel lblInitDate;
	private JLabel lblEndDate;
	private JComboBox comboBox_1;
	private DefaultListModel<String> tareas;
	private Agente ag = Agente.getInstance();
	private ArrayList<Tarea> tareas_proyecto;
	private JButton button;
	private JButton btnNewButton;
	private JButton btnborrar;
	

	/**
	 * Create the panel.
	 */
	public PanelTareas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 85, 62, 103, 35, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 22, 22, 24, 26, 39, 90, 179, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mis tareas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 8;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{86, 51, 0};
		gbl_panel.rowHeights = new int[]{0, 40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblOrdenarPor = new JLabel("Ordenar por:");
		GridBagConstraints gbc_lblOrdenarPor = new GridBagConstraints();
		gbc_lblOrdenarPor.anchor = GridBagConstraints.EAST;
		gbc_lblOrdenarPor.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrdenarPor.gridx = 0;
		gbc_lblOrdenarPor.gridy = 0;
		panel.add(lblOrdenarPor, gbc_lblOrdenarPor);
		
		sortComboBox = new JComboBox<String>();
		sortComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ordenarLista(sortComboBox.getSelectedIndex());
			}
		});
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Fecha de creacion", "Fecha de fin", "Nombre (A-Z)", "Responsable (A-Z)"}));
		GridBagConstraints gbc_sortComboBox = new GridBagConstraints();
		gbc_sortComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_sortComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_sortComboBox.gridx = 1;
		gbc_sortComboBox.gridy = 0;
		panel.add(sortComboBox, gbc_sortComboBox);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		tareas = new DefaultListModel<>();
		tasklist = new JList<String>(tareas);
		tasklist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Tarea t = null;
				if (tasklist.getSelectedValue() == null){
					lblName.setText("");
					lblInitDate.setText("");
					lblEndDate.setText("");
					txtDescripcion.setText("");
				}else {
				for (int i=0;i<tareas_proyecto.size();i++) {
					if (String.valueOf(tasklist.getSelectedValue()).equals(tareas_proyecto.get(i).getNombre())) {
						t=tareas_proyecto.get(i);
						break;
					}
				}
				lblName.setText(t.getNombre());
				lblInitDate.setText(t.getFechaInicioString());
				lblEndDate.setText(t.getFechaFinString());
				comprobarPrioridad(t);
				comprobarEstado(t);
				comboBox_1.setSelectedItem(t.getResponsable().getNombre());
				txtDescripcion.setText(t.getDescripcion());
				
				}
			}
		});
		scrollPane.setViewportView(tasklist);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 8;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{121, 119, 70, 67, 0, 142, 0};
		gbl_panel_1.rowHeights = new int[]{0, 27, 33, 32, 36, 32, 69, 65, 37, 118, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblImagen = new JLabel("Imagen");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.insets = new Insets(0, 0, 5, 0);
		gbc_lblImagen.gridx = 5;
		gbc_lblImagen.gridy = 0;
		panel_1.add(lblImagen, gbc_lblImagen);
		
		lblNombreDeTarea = new JLabel("Nombre de tarea");
		GridBagConstraints gbc_lblNombreDeTarea = new GridBagConstraints();
		gbc_lblNombreDeTarea.anchor = GridBagConstraints.WEST;
		gbc_lblNombreDeTarea.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeTarea.gridx = 0;
		gbc_lblNombreDeTarea.gridy = 1;
		panel_1.add(lblNombreDeTarea, gbc_lblNombreDeTarea);
		
		lblName = new JLabel("");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.gridwidth = 3;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		panel_1.add(lblName, gbc_lblName);
		
		label = new JLabel("");
		label.setBorder(null);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridheight = 5;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 5;
		gbc_label.gridy = 1;
		panel_1.add(label, gbc_label);
		
		lblFechaDeComienzo = new JLabel("Fecha de comienzo");
		GridBagConstraints gbc_lblFechaDeComienzo = new GridBagConstraints();
		gbc_lblFechaDeComienzo.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeComienzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeComienzo.gridx = 0;
		gbc_lblFechaDeComienzo.gridy = 2;
		panel_1.add(lblFechaDeComienzo, gbc_lblFechaDeComienzo);
		
		lblInitDate = new JLabel("");
		GridBagConstraints gbc_lblInitDate = new GridBagConstraints();
		gbc_lblInitDate.anchor = GridBagConstraints.WEST;
		gbc_lblInitDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitDate.gridx = 1;
		gbc_lblInitDate.gridy = 2;
		panel_1.add(lblInitDate, gbc_lblInitDate);
		
		lblFechaEstimadaDe = new JLabel("Fecha de fin");
		GridBagConstraints gbc_lblFechaEstimadaDe = new GridBagConstraints();
		gbc_lblFechaEstimadaDe.anchor = GridBagConstraints.WEST;
		gbc_lblFechaEstimadaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEstimadaDe.gridx = 0;
		gbc_lblFechaEstimadaDe.gridy = 3;
		panel_1.add(lblFechaEstimadaDe, gbc_lblFechaEstimadaDe);
		
		lblEndDate = new JLabel("");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate.gridx = 1;
		gbc_lblEndDate.gridy = 3;
		panel_1.add(lblEndDate, gbc_lblEndDate);
		
		lblResponsable = new JLabel("Responsable");
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.anchor = GridBagConstraints.WEST;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 0;
		gbc_lblResponsable.gridy = 4;
		panel_1.add(lblResponsable, gbc_lblResponsable);
		
		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 4;
		for (int i=0;i<ag.getUsuarios().size();i++) {
			comboBox_1.addItem(ag.getUsuarios().get(i).getNombre());
		}
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		panel_1.add(lblEstado, gbc_lblEstado);
		
		rdbtnCompletada = new JRadioButton("COMPLETADA");
		rdbtnCompletada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		GridBagConstraints gbc_rdbtnCompletada = new GridBagConstraints();
		gbc_rdbtnCompletada.anchor = GridBagConstraints.EAST;
		gbc_rdbtnCompletada.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCompletada.gridx = 1;
		gbc_rdbtnCompletada.gridy = 5;
		panel_1.add(rdbtnCompletada, gbc_rdbtnCompletada);
		
		rdbtnActiva = new JRadioButton("ACTIVA");
		GridBagConstraints gbc_rdbtnActiva = new GridBagConstraints();
		gbc_rdbtnActiva.anchor = GridBagConstraints.WEST;
		gbc_rdbtnActiva.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnActiva.gridx = 2;
		gbc_rdbtnActiva.gridy = 5;
		panel_1.add(rdbtnActiva, gbc_rdbtnActiva);
		
		rdbtnTardia = new JRadioButton("TARDIA");
		GridBagConstraints gbc_rdbtnTardia = new GridBagConstraints();
		gbc_rdbtnTardia.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTardia.gridx = 3;
		gbc_rdbtnTardia.gridy = 5;
		panel_1.add(rdbtnTardia, gbc_rdbtnTardia);
		
		ButtonGroup group = new ButtonGroup ();
		group.add(rdbtnCompletada);
		group.add(rdbtnActiva);
		group.add(rdbtnTardia);
		rdbtnCompletada.setSelected(true);
		
		
		lblPrioridad = new JLabel("Prioridad");
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.anchor = GridBagConstraints.WEST;
		gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrioridad.gridx = 0;
		gbc_lblPrioridad.gridy = 6;
		panel_1.add(lblPrioridad, gbc_lblPrioridad);
	    Dictionary labels = new Hashtable();
        labels.put(0, new JLabel("Baja"));
        labels.put(1, new JLabel("Moderada"));
        labels.put(2, new JLabel("Urgente"));
		
		slider = new JSlider();
		slider.setLabelTable(labels);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setValue(0);
		slider.setMaximum(2);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.gridwidth = 3;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 6;
		

		panel_1.add(slider, gbc_slider);
		
		lblBreveDescripcin = new JLabel("Breve descripción");
		GridBagConstraints gbc_lblBreveDescripcin = new GridBagConstraints();
		gbc_lblBreveDescripcin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBreveDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblBreveDescripcin.gridx = 0;
		gbc_lblBreveDescripcin.gridy = 7;
		panel_1.add(lblBreveDescripcin, gbc_lblBreveDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.gridwidth = 3;
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 7;
		panel_1.add(txtDescripcion, gbc_txtDescripcion);
		
		lblListaDeSubtareas = new JLabel("Lista de subtareas");
		GridBagConstraints gbc_lblListaDeSubtareas = new GridBagConstraints();
		gbc_lblListaDeSubtareas.anchor = GridBagConstraints.NORTH;
		gbc_lblListaDeSubtareas.insets = new Insets(0, 0, 0, 5);
		gbc_lblListaDeSubtareas.gridx = 0;
		gbc_lblListaDeSubtareas.gridy = 9;
		panel_1.add(lblListaDeSubtareas, gbc_lblListaDeSubtareas);
		
		subtasklist = new JList();
		GridBagConstraints gbc_subtasklist = new GridBagConstraints();
		gbc_subtasklist.insets = new Insets(0, 0, 0, 5);
		gbc_subtasklist.gridwidth = 3;
		gbc_subtasklist.fill = GridBagConstraints.BOTH;
		gbc_subtasklist.gridx = 1;
		gbc_subtasklist.gridy = 9;
		panel_1.add(subtasklist, gbc_subtasklist);
		
		button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setIcon(new ImageIcon(PanelTareas.class.getResource("/Resources/anadir.png")));
		button.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 3;
		add(button, gbc_button);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PanelTareas.class.getResource("/Resources/lapiz.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
		
		btnborrar = new JButton("");
		btnborrar.setIcon(new ImageIcon(PanelTareas.class.getResource("/Resources/papelera.png")));
		btnborrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnborrar.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnborrar = new GridBagConstraints();
		gbc_btnborrar.anchor = GridBagConstraints.WEST;
		gbc_btnborrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnborrar.gridx = 4;
		gbc_btnborrar.gridy = 5;
		add(btnborrar, gbc_btnborrar);

	}
	public void mostrarTareas(Proyecto p) {
		tareas_proyecto=p.getTareas();
		for (int i =0;i<tareas_proyecto.size();i++) {
			tareas.addElement(tareas_proyecto.get(i).getNombre());
		}
	}
	public void eliminarTareas() {
		tasklist.clearSelection();
		tareas.removeAllElements();
	}
	public void comprobarPrioridad(Tarea t) {
		Prioridad estado = t.getPrioridad();
		switch (estado){
			case BAJA:
				slider.setValue(0);
				break;
			case MODERADA:
				slider.setValue(1);
				break;
			case ALTA:
				slider.setValue(2);
				break;
		}
	}
	public void comprobarEstado(Tarea t) {
		Estado estado = t.getEstado();
		switch (estado) {
		case COMPLETADA:
			rdbtnCompletada.setSelected(true);
			break;
		case ACTIVA:
			rdbtnActiva.setSelected(true);
			break;
		case TARDÍA:
			rdbtnTardia.setSelected(true);
			break;
			}
		}
	public void ordenarLista(int tipo_orden) {
		switch (tipo_orden){
		case 0:
		Collections.sort(tareas_proyecto, new InitDateComparator());
		break;
		case 1:
		Collections.sort(tareas_proyecto,new EndDateComparator());
		break;
		case 2:
		Collections.sort(tareas_proyecto, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea c1, Tarea c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }
        });
		break;
		case 3:
			Collections.sort(tareas_proyecto, new Comparator<Tarea>() {
	            @Override
	            public int compare(Tarea c1, Tarea c2) {
	                return c1.getResponsable().getNombre().compareTo(c2.getResponsable().getNombre());
	            }
	        });
			break;
		}
		recargarLista();
		
	}
	public void recargarLista() {
		eliminarTareas();
		for (int i=0;i<tareas_proyecto.size();i++) {
			tareas.addElement(tareas_proyecto.get(i).getNombre());
		}
	}
}
