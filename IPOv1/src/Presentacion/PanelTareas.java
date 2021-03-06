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

import com.toedter.calendar.JDateChooser;

import Dominio.EndDateComparator;
import Dominio.Estado;
import Dominio.InitDateComparator;
import Dominio.Prioridad;
import Dominio.Proyecto;
import Dominio.Tarea;
import Dominio.Usuario;
import Persistencia.Agente;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
	private JTextField txtName;
	private JDateChooser txtInitDate;
	private JDateChooser txtEndDate;
	private JComboBox cmbResponsable;
	private DefaultListModel<String> tareas;
	private Agente ag = Agente.getInstance();
	private Proyecto pr;
	private ArrayList<Tarea> tareas_proyecto;
	private JButton button;
	private JButton btnEditar;
	private JButton btnBorrar;
	

	/**
	 * Create the panel.
	 */
	public PanelTareas(Proyecto pr) {
		this.pr=pr;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 85, 62, 103, 35, 487, 0, 110, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 22, 22, 24, 26, 39, 90, 179, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), MessagesIPROject.getString("PanelTareas.panel.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));  //$NON-NLS-1$//$NON-NLS-2$
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
		
		lblOrdenarPor = new JLabel(MessagesIPROject.getString("PanelTareas.lblOrdenarPor.text")); //$NON-NLS-1$
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
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {MessagesIPROject.getString("PanelTareas.1"), MessagesIPROject.getString("PanelTareas.2"), MessagesIPROject.getString("PanelTareas.3"), MessagesIPROject.getString("PanelTareas.4")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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
	
		tasklist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tarea t = null;
				if (tasklist.getSelectedValue() == null){
					txtName.setText(""); //$NON-NLS-1$
					txtInitDate.setDate(Calendar.getInstance().getTime());
					txtEndDate.setDate(Calendar.getInstance().getTime());
					txtDescripcion.setText(""); //$NON-NLS-1$
				}else {
				for (int i=0;i<tareas_proyecto.size();i++) {
					if (String.valueOf(tasklist.getSelectedValue()).equals(tareas_proyecto.get(i).getNombre())) {
						t=tareas_proyecto.get(i);
						break;
					}
				}
				txtName.setText(t.getNombre());
				txtInitDate.setDate(t.getFecha_ini());
				txtEndDate.setDate(t.getFecha_fin());
				comprobarPrioridad(t);
				comprobarEstado(t);
				cmbResponsable.setSelectedItem(t.getResponsable().getNombre());
				txtDescripcion.setText(t.getDescripcion());
				btnEditar.setEnabled(true);
				btnBorrar.setEnabled(true);
				}
			}
		});
		scrollPane.setViewportView(tasklist);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.gridheight = 8;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{19, 120, 119, 70, 67, 56, 93, 0};
		gbl_panel_1.rowHeights = new int[]{0, 27, 33, 32, 36, 32, 69, 65, 37, 153, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblImagen = new JLabel(MessagesIPROject.getString("PanelTareas.lblImagen.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.gridwidth = 2;
		gbc_lblImagen.insets = new Insets(0, 0, 5, 0);
		gbc_lblImagen.gridx = 5;
		gbc_lblImagen.gridy = 0;
		panel_1.add(lblImagen, gbc_lblImagen);
		
		lblNombreDeTarea = new JLabel(MessagesIPROject.getString("PanelTareas.lblNombreDeTarea.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombreDeTarea = new GridBagConstraints();
		gbc_lblNombreDeTarea.anchor = GridBagConstraints.WEST;
		gbc_lblNombreDeTarea.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeTarea.gridx = 1;
		gbc_lblNombreDeTarea.gridy = 1;
		panel_1.add(lblNombreDeTarea, gbc_lblNombreDeTarea);
		
		txtName = new JTextField(""); //$NON-NLS-1$
		txtName.setEditable(false);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridwidth = 3;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 1;
		panel_1.add(txtName, gbc_txtName);
		
		label = new JLabel(""); //$NON-NLS-1$
		label.setBorder(null);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.gridheight = 5;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 5;
		gbc_label.gridy = 1;
		panel_1.add(label, gbc_label);
		
		lblFechaDeComienzo = new JLabel(MessagesIPROject.getString("PanelTareas.lblFechaDeComienzo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeComienzo = new GridBagConstraints();
		gbc_lblFechaDeComienzo.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeComienzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeComienzo.gridx = 1;
		gbc_lblFechaDeComienzo.gridy = 2;
		panel_1.add(lblFechaDeComienzo, gbc_lblFechaDeComienzo);
		
		txtInitDate = new JDateChooser();
		GridBagConstraints gbc_txtInitDate = new GridBagConstraints();
		gbc_txtInitDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInitDate.gridwidth = 2;
		gbc_txtInitDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtInitDate.gridx = 2;
		gbc_txtInitDate.gridy = 2;
		panel_1.add(txtInitDate, gbc_txtInitDate);
		
		lblFechaEstimadaDe = new JLabel(MessagesIPROject.getString("PanelTareas.lblFechaEstimadaDe.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaEstimadaDe = new GridBagConstraints();
		gbc_lblFechaEstimadaDe.anchor = GridBagConstraints.WEST;
		gbc_lblFechaEstimadaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEstimadaDe.gridx = 1;
		gbc_lblFechaEstimadaDe.gridy = 3;
		panel_1.add(lblFechaEstimadaDe, gbc_lblFechaEstimadaDe);
		
		txtEndDate = new JDateChooser();
		GridBagConstraints gbc_txtEndDate = new GridBagConstraints();
		gbc_txtEndDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndDate.gridwidth = 2;
		gbc_txtEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndDate.gridx = 2;
		gbc_txtEndDate.gridy = 3;
		panel_1.add(txtEndDate, gbc_txtEndDate);
		
		lblResponsable = new JLabel(MessagesIPROject.getString("PanelTareas.lblResponsable.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.anchor = GridBagConstraints.WEST;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 1;
		gbc_lblResponsable.gridy = 4;
		panel_1.add(lblResponsable, gbc_lblResponsable);
		
		cmbResponsable = new JComboBox();
		cmbResponsable.setEnabled(false);
		GridBagConstraints gbc_cmbResponsable = new GridBagConstraints();
		gbc_cmbResponsable.gridwidth = 2;
		gbc_cmbResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_cmbResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbResponsable.gridx = 2;
		gbc_cmbResponsable.gridy = 4;
		for (int i=0;i<ag.getUsuarios().size();i++) {
			cmbResponsable.addItem(ag.getUsuarios().get(i).getNombre());
		}
		panel_1.add(cmbResponsable, gbc_cmbResponsable);
		
		lblEstado = new JLabel(MessagesIPROject.getString("PanelTareas.lblEstado.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 5;
		panel_1.add(lblEstado, gbc_lblEstado);
		
		rdbtnCompletada = new JRadioButton(MessagesIPROject.getString("PanelTareas.rdbtnCompletada.text")); //$NON-NLS-1$
		rdbtnCompletada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		GridBagConstraints gbc_rdbtnCompletada = new GridBagConstraints();
		gbc_rdbtnCompletada.anchor = GridBagConstraints.EAST;
		gbc_rdbtnCompletada.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCompletada.gridx = 2;
		gbc_rdbtnCompletada.gridy = 5;
		panel_1.add(rdbtnCompletada, gbc_rdbtnCompletada);
		
		rdbtnActiva = new JRadioButton(MessagesIPROject.getString("PanelTareas.rdbtnActiva.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnActiva = new GridBagConstraints();
		gbc_rdbtnActiva.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnActiva.gridx = 3;
		gbc_rdbtnActiva.gridy = 5;
		panel_1.add(rdbtnActiva, gbc_rdbtnActiva);
		
		rdbtnTardia = new JRadioButton(MessagesIPROject.getString("PanelTareas.rdbtnTardia.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnTardia = new GridBagConstraints();
		gbc_rdbtnTardia.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTardia.gridx = 4;
		gbc_rdbtnTardia.gridy = 5;
		panel_1.add(rdbtnTardia, gbc_rdbtnTardia);
		
		ButtonGroup group = new ButtonGroup ();
		group.add(rdbtnCompletada);
		group.add(rdbtnActiva);
		group.add(rdbtnTardia);
		rdbtnCompletada.setSelected(true);
		
		
		lblPrioridad = new JLabel(MessagesIPROject.getString("PanelTareas.lblPrioridad.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.anchor = GridBagConstraints.WEST;
		gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrioridad.gridx = 1;
		gbc_lblPrioridad.gridy = 6;
		panel_1.add(lblPrioridad, gbc_lblPrioridad);
	    Dictionary labels = new Hashtable();
        labels.put(0, new JLabel(MessagesIPROject.getString("PanelTareas.9"))); //$NON-NLS-1$
        labels.put(1, new JLabel(MessagesIPROject.getString("PanelTareas.10"))); //$NON-NLS-1$
        labels.put(2, new JLabel(MessagesIPROject.getString("PanelTareas.11"))); //$NON-NLS-1$
		
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
		gbc_slider.gridx = 2;
		gbc_slider.gridy = 6;
		

		panel_1.add(slider, gbc_slider);
		
		lblBreveDescripcin = new JLabel(MessagesIPROject.getString("PanelTareas.lblBreveDescripcin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblBreveDescripcin = new GridBagConstraints();
		gbc_lblBreveDescripcin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBreveDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblBreveDescripcin.gridx = 1;
		gbc_lblBreveDescripcin.gridy = 7;
		panel_1.add(lblBreveDescripcin, gbc_lblBreveDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.gridwidth = 3;
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 2;
		gbc_txtDescripcion.gridy = 7;
		panel_1.add(txtDescripcion, gbc_txtDescripcion);
		
		lblListaDeSubtareas = new JLabel(MessagesIPROject.getString("PanelTareas.lblListaDeSubtareas.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblListaDeSubtareas = new GridBagConstraints();
		gbc_lblListaDeSubtareas.anchor = GridBagConstraints.NORTH;
		gbc_lblListaDeSubtareas.insets = new Insets(0, 0, 0, 5);
		gbc_lblListaDeSubtareas.gridx = 1;
		gbc_lblListaDeSubtareas.gridy = 9;
		panel_1.add(lblListaDeSubtareas, gbc_lblListaDeSubtareas);
		
		subtasklist = new JList();
		GridBagConstraints gbc_subtasklist = new GridBagConstraints();
		gbc_subtasklist.insets = new Insets(0, 0, 0, 5);
		gbc_subtasklist.gridwidth = 3;
		gbc_subtasklist.fill = GridBagConstraints.BOTH;
		gbc_subtasklist.gridx = 2;
		gbc_subtasklist.gridy = 9;
		panel_1.add(subtasklist, gbc_subtasklist);
		
		button = new JButton(""); //$NON-NLS-1$
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tarea as = new Tarea(MessagesIPROject.getString("PanelTareas.13"),Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), Prioridad.ALTA,Estado.ACTIVA,null,MessagesIPROject.getString("PanelTareas.14")); //$NON-NLS-1$ //$NON-NLS-2$
				tareas_proyecto.add(as);
				tareas.addElement(as.getNombre());
			}
		});
		button.setIcon(new ImageIcon(PanelTareas.class.getResource("/Resources/anadir.png"))); //$NON-NLS-1$
		button.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 3;
		add(button, gbc_button);
		
		btnEditar = new JButton(""); //$NON-NLS-1$
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tasklist.getSelectedValue()!=null) {
					Tarea t;
					t=pr.BuscarTarea(tasklist.getSelectedValue());
					//t.Update();
				}
			}
		});
		btnEditar.setIcon(new ImageIcon(PanelTareas.class.getResource("/Resources/lapiz.png"))); //$NON-NLS-1$
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtName.setEditable(true);
				
			}
		});
		btnEditar.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.WEST;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 4;
		gbc_btnEditar.gridy = 4;
		add(btnEditar, gbc_btnEditar);
		
		btnBorrar = new JButton(""); //$NON-NLS-1$
		btnBorrar.setEnabled(false);
		btnBorrar.setIcon(new ImageIcon(PanelTareas.class.getResource("/Resources/papelera.png"))); //$NON-NLS-1$
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tareas.removeElement(tasklist.getSelectedValue());
			}
		});
		btnBorrar.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.WEST;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 4;
		gbc_btnBorrar.gridy = 5;
		add(btnBorrar, gbc_btnBorrar);

	}
	public void mostrarTareas(Proyecto p) {
		pr=p;
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
