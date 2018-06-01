package Presentacion;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Dominio.Estado;
import Dominio.Proyecto;
import Dominio.Usuario;
import Persistencia.Agente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaEdicionProyecto extends JDialog {

	private JPanel contentPane;
	private JLabel lblNombreDelProyecto;
	private JLabel lblNewLabel;
	private JDateChooser dtInicio;
	private JLabel lblFechaDeFinalizacin;
	private JDateChooser dtFin;
	private JComboBox<Estado> comboBox;
	private JLabel lblEstado;
	private JLabel lblDescripcin;
	private JTextField textField;
	private JTextField txtNombre;
	private JButton btnNewButton;
	private JButton btnAtras;
	private Proyecto p = null;
	private Agente ag=Agente.getInstance();
	private Usuario creador=null;
	private VentanaProyectos parent;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaEdicionProyecto(VentanaProyectos parent,Proyecto p) {
		this.parent=parent;
		iniciar();
		this.p=p;
		rellenarCampos();
		
	}
	
	public VentanaEdicionProyecto(VentanaProyectos parent, Usuario creador) {
		this.parent=parent;
		this.creador=creador;

		iniciar();
		
	}
	public VentanaEdicionProyecto() {
		setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		iniciar();
	}
	public void iniciar() {
		setTitle(MessagesIPROject.getString("VentanaEdicionProyecto.this.title")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEdicionProyecto.class.getResource("/Resources/logg.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 100, 126, 99, 0};
		gbl_contentPane.rowHeights = new int[]{34, 20, 20, 20, 39, 39, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNombreDelProyecto = new JLabel(MessagesIPROject.getString("VentanaEdicionProyecto.lblNombreDelProyecto.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombreDelProyecto = new GridBagConstraints();
		gbc_lblNombreDelProyecto.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNombreDelProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelProyecto.gridx = 1;
		gbc_lblNombreDelProyecto.gridy = 0;
		contentPane.add(lblNombreDelProyecto, gbc_lblNombreDelProyecto);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 0;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblNewLabel = new JLabel(MessagesIPROject.getString("VentanaEdicionProyecto.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		dtInicio = new JDateChooser();
		dtInicio.setDateFormatString("dd-MM-yy HH:mm:ss");
		GridBagConstraints gbc_dtInicio = new GridBagConstraints();
		gbc_dtInicio.fill = GridBagConstraints.BOTH;
		gbc_dtInicio.insets = new Insets(0, 0, 5, 5);
		gbc_dtInicio.gridx = 2;
		gbc_dtInicio.gridy = 1;
		contentPane.add(dtInicio, gbc_dtInicio);
		
		lblFechaDeFinalizacin = new JLabel(MessagesIPROject.getString("VentanaEdicionProyecto.lblFechaDeFinalizacin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeFinalizacin = new GridBagConstraints();
		gbc_lblFechaDeFinalizacin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaDeFinalizacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacin.gridx = 1;
		gbc_lblFechaDeFinalizacin.gridy = 2;
		contentPane.add(lblFechaDeFinalizacin, gbc_lblFechaDeFinalizacin);
		
		dtFin = new JDateChooser();
		dtFin.setDateFormatString("dd-MM-yy HH:mm:ss");
		GridBagConstraints gbc_dtFin = new GridBagConstraints();
		gbc_dtFin.fill = GridBagConstraints.BOTH;
		gbc_dtFin.insets = new Insets(0, 0, 5, 5);
		gbc_dtFin.gridx = 2;
		gbc_dtFin.gridy = 2;
		contentPane.add(dtFin, gbc_dtFin);
		
		lblEstado = new JLabel(MessagesIPROject.getString("VentanaEdicionProyecto.lblEstado.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 3;
		contentPane.add(lblEstado, gbc_lblEstado);
		
		comboBox = new JComboBox(Estado.values());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		lblDescripcin = new JLabel(MessagesIPROject.getString("VentanaEdicionProyecto.lblDescripcin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 4;
		contentPane.add(lblDescripcin, gbc_lblDescripcin);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnAtras = new JButton(MessagesIPROject.getString("VentanaEdicionProyecto.btnAtras.text")); //$NON-NLS-1$
		btnAtras.setIcon(new ImageIcon(VentanaEdicionProyecto.class.getResource("/Resources/salir.png")));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 1;
		gbc_btnAtras.gridy = 5;
		contentPane.add(btnAtras, gbc_btnAtras);
		
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (p!=null) actualizarProyecto();
				else {
					ag.getProyectos().add(new Proyecto (txtNombre.getText(), creador, dtInicio.getDate(),dtFin.getDate(),(Estado) comboBox.getSelectedItem(),textField.getText()));
					dispose();
				}
			}
			});
		
			btnNewButton.setIcon(new ImageIcon(VentanaEdicionProyecto.class.getResource("/Resources/guardar.png")));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.gridx = 3;
			gbc_btnNewButton.gridy = 5;
			contentPane.add(btnNewButton, gbc_btnNewButton);		
			
			contentPane.setVisible(true);
		    }
	
	public void rellenarCampos() {
		txtNombre.setText(p.getNombre());
		dtInicio.setDate(p.getFechaCreacion());
		dtFin.setDate(p.getFechaFin());
		comboBox.setSelectedItem(p.getEstado());
		textField.setText(p.getDescripcion());
		}
	public void actualizarProyecto() {
		p.setNombre(txtNombre.getText());
		p.setEstado((Estado)comboBox.getSelectedItem());
		p.setFechaCreacion(dtInicio.getDate());
		p.setFechaFin(dtFin.getDate());
		p.setDescripcion(textField.getText());
		ag.getProyectos().add(p);
		this.dispose();
	}
}
		
	