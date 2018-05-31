package Presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.sun.jmx.snmp.Timestamp;

import Dominio.*;
import Persistencia.Agente;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro {
	
	public JFrame frmProjectwizardIpo;
	public JFrame loginFrame;
	private JPanel panel;
	private JLabel lblDNI;
	private JFormattedTextField txtDNI;
	private JPasswordField fldpass;
	private JLabel lblContrasea;
	private JLabel lblConfirmarContrasea;
	private JPasswordField fldpassConfirm;
	private JLabel lblRol;
	private JTextField textField;
	private JLabel lblEmail;
	private JTextField textField_1;
	private JLabel lblDescripcion;
	private JTextField textField_2;
	private JLabel lblNombre;
	private JTextField textField_3;
	private JLabel lblApellidos;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblCaracteresMinimo;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public VentanaRegistro() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectwizardIpo = new JFrame();
		frmProjectwizardIpo.setTitle("ProjectManager - IPO 2017");
		frmProjectwizardIpo.setBounds(100, 100, 517, 452);
		frmProjectwizardIpo.setVisible(true);
		frmProjectwizardIpo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{173, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{33, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmProjectwizardIpo.getContentPane().setLayout(gridBagLayout);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Formulario de registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridheight = 7;
			gbc_panel.gridwidth = 7;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			frmProjectwizardIpo.getContentPane().add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{76, 66, 72, 0, 67, 51, 105, 47, 0};
			gbl_panel.rowHeights = new int[]{32, 0, 29, 31, 24, 32, 28, 32, 86, 35, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblDNI = new JLabel("DNI*");
				GridBagConstraints gbc_lblDNI = new GridBagConstraints();
				gbc_lblDNI.anchor = GridBagConstraints.EAST;
				gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
				gbc_lblDNI.gridx = 0;
				gbc_lblDNI.gridy = 0;
				
				panel.add(lblDNI, gbc_lblDNI);
			}
			{
				MaskFormatter usuario;
			try{
				usuario=new MaskFormatter("########");
				usuario.setPlaceholderCharacter('-');
			txtDNI= new JFormattedTextField(usuario);
			txtDNI.addKeyListener(new FormattedTextFieldKeyListener());
			GridBagConstraints gbc_txtDNI = new GridBagConstraints();
			gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDNI.gridwidth = 2;
			gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
			gbc_txtDNI.gridx = 1;
			gbc_txtDNI.gridy = 0;
			panel.add(txtDNI, gbc_txtDNI);

			} catch (ParseException ex) {
				ex.printStackTrace();
			}
				
			}
			{
				lblContrasea = new JLabel("Contraseña*");
				GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
				gbc_lblContrasea.gridwidth = 2;
				gbc_lblContrasea.anchor = GridBagConstraints.EAST;
				gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblContrasea.gridx = 0;
				gbc_lblContrasea.gridy = 1;
				panel.add(lblContrasea, gbc_lblContrasea);
			}
			{
				fldpass = new JPasswordField();
				fldpass.addKeyListener(new FldpassKeyListener());
				GridBagConstraints gbc_fldpass = new GridBagConstraints();
				gbc_fldpass.fill = GridBagConstraints.HORIZONTAL;
				gbc_fldpass.insets = new Insets(0, 0, 5, 5);
				gbc_fldpass.gridwidth = 3;
				gbc_fldpass.gridx = 2;
				gbc_fldpass.gridy = 1;
				panel.add(fldpass, gbc_fldpass);
			}
			{
				lblCaracteresMinimo = new JLabel("4 caracteres minimo");
				lblCaracteresMinimo.setForeground(Color.RED);
				lblCaracteresMinimo.setFont(new Font("Tahoma", Font.ITALIC, 11));
				GridBagConstraints gbc_lblCaracteresMinimo = new GridBagConstraints();
				gbc_lblCaracteresMinimo.gridwidth = 2;
				gbc_lblCaracteresMinimo.insets = new Insets(0, 0, 5, 5);
				gbc_lblCaracteresMinimo.gridx = 5;
				gbc_lblCaracteresMinimo.gridy = 1;
				panel.add(lblCaracteresMinimo, gbc_lblCaracteresMinimo);
			}
			{
				lblConfirmarContrasea = new JLabel("Confirmar contraseña*");
				GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
				gbc_lblConfirmarContrasea.gridwidth = 2;
				gbc_lblConfirmarContrasea.anchor = GridBagConstraints.EAST;
				gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblConfirmarContrasea.gridx = 0;
				gbc_lblConfirmarContrasea.gridy = 2;
				panel.add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);
			}
			{
				fldpassConfirm = new JPasswordField();
				fldpassConfirm.addKeyListener(new FldpassConfirmKeyListener());
				GridBagConstraints gbc_fldpassConfirm = new GridBagConstraints();
				gbc_fldpassConfirm.insets = new Insets(0, 0, 5, 5);
				gbc_fldpassConfirm.gridwidth = 3;
				gbc_fldpassConfirm.fill = GridBagConstraints.HORIZONTAL;
				gbc_fldpassConfirm.gridx = 2;
				gbc_fldpassConfirm.gridy = 2;
				panel.add(fldpassConfirm, gbc_fldpassConfirm);
			}
			{
				lblRol = new JLabel("Rol");
				GridBagConstraints gbc_lblRol = new GridBagConstraints();
				gbc_lblRol.anchor = GridBagConstraints.EAST;
				gbc_lblRol.insets = new Insets(0, 0, 5, 5);
				gbc_lblRol.gridx = 0;
				gbc_lblRol.gridy = 3;
				panel.add(lblRol, gbc_lblRol);
			}
			{
				textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.gridwidth = 2;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 1;
				gbc_textField.gridy = 3;
				panel.add(textField, gbc_textField);
				textField.setColumns(10);
			}
			{
				lblEmail = new JLabel("E-mail");
				GridBagConstraints gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.anchor = GridBagConstraints.EAST;
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 0;
				gbc_lblEmail.gridy = 4;
				panel.add(lblEmail, gbc_lblEmail);
			}
			{
				textField_1 = new JTextField();
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 4;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 1;
				gbc_textField_1.gridy = 4;
				panel.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			{
				lblNombre = new JLabel("Nombre");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.anchor = GridBagConstraints.EAST;
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.gridx = 0;
				gbc_lblNombre.gridy = 5;
				panel.add(lblNombre, gbc_lblNombre);
			}
			{
				textField_3 = new JTextField();
				GridBagConstraints gbc_textField_3 = new GridBagConstraints();
				gbc_textField_3.gridwidth = 2;
				gbc_textField_3.insets = new Insets(0, 0, 5, 5);
				gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_3.gridx = 1;
				gbc_textField_3.gridy = 5;
				panel.add(textField_3, gbc_textField_3);
				textField_3.setColumns(10);
			}
			{
				lblApellidos = new JLabel("Apellido");
				GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
				gbc_lblApellidos.anchor = GridBagConstraints.EAST;
				gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
				gbc_lblApellidos.gridx = 0;
				gbc_lblApellidos.gridy = 6;
				panel.add(lblApellidos, gbc_lblApellidos);
			}
			{
				textField_4 = new JTextField();
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.gridwidth = 2;
				gbc_textField_4.insets = new Insets(0, 0, 5, 5);
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 1;
				gbc_textField_4.gridy = 6;
				panel.add(textField_4, gbc_textField_4);
				textField_4.setColumns(10);
			}
			{
				lblDescripcion = new JLabel("Descripcion");
				GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
				gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
				gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescripcion.gridx = 0;
				gbc_lblDescripcion.gridy = 7;
				panel.add(lblDescripcion, gbc_lblDescripcion);
			}
			{
				textField_2 = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.gridwidth = 6;
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.BOTH;
				gbc_textField_2.gridx = 1;
				gbc_textField_2.gridy = 8;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
			}
			{
				lblNewLabel_1 = new JLabel("*: Campos obligatorios para el registro");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.gridwidth = 5;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 9;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				btnSalir = new JButton("SALIR");
				btnSalir.addMouseListener(new BtnSalirMouseListener());
				GridBagConstraints gbc_btnSalir = new GridBagConstraints();
				gbc_btnSalir.gridwidth = 2;
				gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
				gbc_btnSalir.gridx = 0;
				gbc_btnSalir.gridy = 10;
				panel.add(btnSalir, gbc_btnSalir);
			}
			{
				btnNewButton = new JButton("Guardar");
				btnNewButton.addActionListener(new BtnNewButtonActionListener());
				btnNewButton.setEnabled(false);
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnNewButton.gridwidth = 2;
				gbc_btnNewButton.gridx = 5;
				gbc_btnNewButton.gridy = 10;
				panel.add(btnNewButton, gbc_btnNewButton);
			}
		}
	}

	private class FormattedTextFieldKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			checkFilledFields();
		
		}
	}
	private class FldpassKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			checkFilledFields();
		}
	}
	private class FldpassConfirmKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			checkFilledFields();
		}
	}
	private class BtnSalirMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	}
	private class BtnNewButtonActionListener implements ActionListener {
		
		
		
		public void actionPerformed(ActionEvent arg0) {
					SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date date = Calendar.getInstance().getTime();
					String fecha = formato.format(date);
					Agente ag = Agente.getInstance();
					ag.insertUsuario(new Usuario(txtDNI.getText(), textField.getText(), String.valueOf(fldpass.getPassword()), textField_1.getText(), textField_2.getText(),textField_3.getText(),textField_4.getText()));
				frmProjectwizardIpo.dispose();
				VentanaInicio vx=new VentanaInicio();
			}
			
			
		
	}
	private void checkFilledFields(){
		boolean iguales = false;
		iguales = (String.valueOf(fldpass.getPassword()).equals(String.valueOf(fldpassConfirm.getPassword())));
		if ((txtDNI.getText().length() == 8) && (fldpass.getPassword().length >= 4) && (fldpassConfirm.getPassword().length >=4)  && (iguales)){
			btnNewButton.setEnabled(true);
		} else btnNewButton.setEnabled(false);
	}
}
