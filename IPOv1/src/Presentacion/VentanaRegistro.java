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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

import com.sun.jmx.snmp.Timestamp;

import Dominio.*;
import Persistencia.Agente;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageFilter;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
	private JTextField txtRol;
	private JLabel lblEmail;
	private JTextField txtemail;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JTextField txtApellido;
	private JButton btnNewButton;
	private JLabel lblCaracteresMinimo;
	private JButton btnSalir;
	private JButton btnSeleccionarImagen;
	private String ImageSelected;

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
		ImageSelected="";
		frmProjectwizardIpo = new JFrame();
		frmProjectwizardIpo.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/Resources/logg.png")));
		frmProjectwizardIpo.setTitle("IPROject");
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
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			frmProjectwizardIpo.getContentPane().add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{76, 66, 72, 0, 67, 51, 105, 47, 0};
			gbl_panel.rowHeights = new int[]{32, 0, 29, 31, 24, 32, 35, 42, 43, 86, 35, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblDNI = new JLabel("DNI");
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
				lblContrasea = new JLabel("Contraseña");
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
				lblConfirmarContrasea = new JLabel("Confirmar contraseña");
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
				txtRol = new JTextField();
				txtRol.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						checkFilledFields();
					}
				});
				GridBagConstraints gbc_txtRol = new GridBagConstraints();
				gbc_txtRol.gridwidth = 2;
				gbc_txtRol.insets = new Insets(0, 0, 5, 5);
				gbc_txtRol.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRol.gridx = 1;
				gbc_txtRol.gridy = 3;
				panel.add(txtRol, gbc_txtRol);
				txtRol.setColumns(10);
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
				txtemail = new JTextField();
				txtemail.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						checkFilledFields();
					}
				});
				GridBagConstraints gbc_txtemail = new GridBagConstraints();
				gbc_txtemail.gridwidth = 4;
				gbc_txtemail.insets = new Insets(0, 0, 5, 5);
				gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtemail.gridx = 1;
				gbc_txtemail.gridy = 4;
				panel.add(txtemail, gbc_txtemail);
				txtemail.setColumns(10);
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
				txtNombre = new JTextField();
				txtNombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						checkFilledFields();
					}
				});
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.gridwidth = 2;
				gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.gridx = 1;
				gbc_txtNombre.gridy = 5;
				panel.add(txtNombre, gbc_txtNombre);
				txtNombre.setColumns(10);
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
				txtApellido = new JTextField();
				txtApellido.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						checkFilledFields();
					}
				});
				GridBagConstraints gbc_txtApellido = new GridBagConstraints();
				gbc_txtApellido.gridwidth = 2;
				gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
				gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtApellido.gridx = 1;
				gbc_txtApellido.gridy = 6;
				panel.add(txtApellido, gbc_txtApellido);
				txtApellido.setColumns(10);
			}
			{
				btnSeleccionarImagen = new JButton("Seleccionar Imagen");
				btnSeleccionarImagen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ShowImageFinder();
					}
				});
				GridBagConstraints gbc_btnSeleccionarImagen = new GridBagConstraints();
				gbc_btnSeleccionarImagen.gridwidth = 2;
				gbc_btnSeleccionarImagen.insets = new Insets(0, 0, 5, 5);
				gbc_btnSeleccionarImagen.gridx = 1;
				gbc_btnSeleccionarImagen.gridy = 7;
				panel.add(btnSeleccionarImagen, gbc_btnSeleccionarImagen);
			}
			{
				lblDescripcion = new JLabel("Descripcion");
				GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
				gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
				gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescripcion.gridx = 0;
				gbc_lblDescripcion.gridy = 8;
				panel.add(lblDescripcion, gbc_lblDescripcion);
			}
			{
				txtDescripcion = new JTextField();
				txtDescripcion.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						checkFilledFields();
					}
				});
				GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
				gbc_txtDescripcion.gridwidth = 6;
				gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
				gbc_txtDescripcion.gridx = 1;
				gbc_txtDescripcion.gridy = 8;
				panel.add(txtDescripcion, gbc_txtDescripcion);
				txtDescripcion.setColumns(10);
			}
			{
				btnSalir = new JButton("SALIR");
				btnSalir.addMouseListener(new BtnSalirMouseListener());
				GridBagConstraints gbc_btnSalir = new GridBagConstraints();
				gbc_btnSalir.gridwidth = 2;
				gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
				gbc_btnSalir.gridx = 0;
				gbc_btnSalir.gridy = 11;
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
				gbc_btnNewButton.gridy = 11;
				panel.add(btnNewButton, gbc_btnNewButton);
			}
		}
	}
	
	public void ShowImageFinder() {
		// muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.setFileFilter(new FileNameExtensionFilter("Image files", "png"));
		int option = selectorArchivos.showSaveDialog(null);
        if(option == JFileChooser.APPROVE_OPTION) {
           ImageSelected= selectorArchivos.getSelectedFile().getAbsolutePath();
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

					ag.insertUsuario(new Usuario(txtDNI.getText(), txtRol.getText(), String.valueOf(fldpass.getPassword()), txtemail.getText(), txtDescripcion.getText(),txtNombre.getText(),txtApellido.getText(),ImageSelected));

				frmProjectwizardIpo.dispose();
				VentanaInicio vx=new VentanaInicio();
			}
			
			
		
	}
	private void checkFilledFields(){
		boolean iguales = false;
		iguales = (String.valueOf(fldpass.getPassword()).equals(String.valueOf(fldpassConfirm.getPassword())));
		if ((txtDNI.getText().length() == 8) && (fldpass.getPassword().length >= 4) && (fldpassConfirm.getPassword().length >=4)  && (iguales) && (txtRol.getText().length() > 1) && (txtNombre.getText().length() > 1) && (txtemail.getText().length() > 3) && (txtApellido.getText().length() > 4) && (txtDescripcion.getText().length() > 1)){
			btnNewButton.setEnabled(true);
		} else btnNewButton.setEnabled(false);
	}
}
