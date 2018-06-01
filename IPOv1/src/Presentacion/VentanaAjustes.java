package Presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;

import Dominio.Usuario;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VentanaAjustes extends JFrame {

	private JPanel contentPane;
	private JLabel lblContrasea;
	private JLabel lblRol;
	private JLabel lblEmail;
	private JLabel lblNombre_1;
	private JLabel lblApellidos;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNombre;
	private JButton btnGuardar;
	private JButton btnBorrarDatos;
	private Usuario us;
	
	
	public VentanaAjustes(Usuario us) {
		this.us=us;
		setResizable(false);
		setTitle(MessagesIPROject.getString("VentanaAjustes.this.title")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAjustes.class.getResource("/Resources/logg.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{36, 88, 140, 8, 73, 95, 0, 0};
		gbl_contentPane.rowHeights = new int[]{29, 14, 30, 28, 27, 32, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNombre = new JLabel(MessagesIPROject.getString("VentanaAjustes.lblNombre.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.SOUTH;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblContrasea = new JLabel(MessagesIPROject.getString("VentanaAjustes.lblContrasea.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 2;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		btnGuardar = new JButton(MessagesIPROject.getString("VentanaAjustes.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane optionPane = new JOptionPane(
		                "La aplicación se cerrará para guardar la información." ,JOptionPane.INFORMATION_MESSAGE);

		JDialog dialog = new JDialog(new JFrame(), "Aviso",
		                             true);
		dialog.setContentPane(optionPane);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		optionPane.addPropertyChangeListener(
		    new PropertyChangeListener() {
		        public void propertyChange(PropertyChangeEvent e) {
		            String prop = e.getPropertyName();

		            if (dialog.isVisible() 
		             && (e.getSource() == optionPane)
		             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
		                //If you were going to check something
		                //before closing the window, you'd do
		                //it here.
		                dialog.setVisible(false);
		            }
		        }
		    });
		dialog.pack();
		dialog.setVisible(true);
		int value = ((Integer)optionPane.getValue()).intValue();
		if (value == JOptionPane.OK_OPTION) {
		    System.exit(0);
		}
			
			}
			});
		btnGuardar.setIcon(new ImageIcon(VentanaAjustes.class.getResource("/Resources/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridheight = 2;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 1;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		lblRol = new JLabel(MessagesIPROject.getString("VentanaAjustes.lblRol.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.EAST;
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 1;
		gbc_lblRol.gridy = 3;
		contentPane.add(lblRol, gbc_lblRol);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblEmail = new JLabel(MessagesIPROject.getString("VentanaAjustes.lblEmail.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblNombre_1 = new JLabel(MessagesIPROject.getString("VentanaAjustes.lblNombre_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
		gbc_lblNombre_1.anchor = GridBagConstraints.EAST;
		gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre_1.gridx = 1;
		gbc_lblNombre_1.gridy = 5;
		contentPane.add(lblNombre_1, gbc_lblNombre_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 5;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		btnBorrarDatos = new JButton(MessagesIPROject.getString("VentanaAjustes.btnBorrarDatos.text")); //$NON-NLS-1$
		btnBorrarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane optionPane = new JOptionPane(
		                "¿Está seguro de que usted quiere eliminar\n"+ "sus datos? Si escoge si, la\n"+"aplicacón se cerrará." ,JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);

		JDialog dialog = new JDialog(new JFrame(), "Confirmar acción",
		                             true);
		dialog.setContentPane(optionPane);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		optionPane.addPropertyChangeListener(
		    new PropertyChangeListener() {
		        public void propertyChange(PropertyChangeEvent e) {
		            String prop = e.getPropertyName();

		            if (dialog.isVisible() 
		             && (e.getSource() == optionPane)
		             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
		                //If you were going to check something
		                //before closing the window, you'd do
		                //it here.
		                dialog.setVisible(false);
		            }
		        }
		    });
		dialog.pack();
		dialog.setVisible(true);
		int value = ((Integer)optionPane.getValue()).intValue();
		if (value == JOptionPane.YES_OPTION) {
		    System.exit(0);
		} else if (value == JOptionPane.NO_OPTION) {
		    dispose();			}
		}
			});
		btnBorrarDatos.setIcon(new ImageIcon(VentanaAjustes.class.getResource("/Resources/papelera.png")));
		GridBagConstraints gbc_btnBorrarDatos = new GridBagConstraints();
		gbc_btnBorrarDatos.gridheight = 2;
		gbc_btnBorrarDatos.gridwidth = 2;
		gbc_btnBorrarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrarDatos.gridx = 5;
		gbc_btnBorrarDatos.gridy = 4;
		contentPane.add(btnBorrarDatos, gbc_btnBorrarDatos);
		
		lblApellidos = new JLabel(MessagesIPROject.getString("VentanaAjustes.lblApellidos.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 6;
		contentPane.add(lblApellidos, gbc_lblApellidos);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 6;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		rellenarTodo();
	}
	public void rellenarTodo() {
		textField.setText(us.getNombre());
		textField_1.setText(us.getRol());
		textField_2.setText(us.getEmail());
		textField_3.setText(us.getNombre());
		textField_4.setText(us.getApellido());
	}
}
