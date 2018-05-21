package Presentacion;

import Resources.*;
import Dominio.*;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentanaInicio {
	private Conexion con;
	private JFrame frmProjectwizardIpo;
	private JPanel panel;
	private JComboBox comboBox;
	private JLabel lblIdioma;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JPasswordField passwordField;
	private JFormattedTextField userField;
	private JButton btnIniciarSesion;
	private JButton button;
	private JLabel lblnoEstRegistrado;
	private JLabel lblLogo;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VentanaInicio window = new VentanaInicio();
					window.frmProjectwizardIpo.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {
		initialize();
		 try {
			 //LA RUTA DE LA BASE DE DATOS AQUI
			String ruta="D:/Dropbox/IPO/Las ventanitas/src/Persistencia/bd.accdb";
			// String ruta = "C:/Users/USUARIO/Dropbox/IPO/Las ventanitas/src/Persistencia/bd.accdb";
			con = new Conexion(ruta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmProjectwizardIpo = new JFrame();
		frmProjectwizardIpo.setTitle("ProjectWizard  - IPO 2017");
		frmProjectwizardIpo.setBounds(100, 100, 511, 310);
		frmProjectwizardIpo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectwizardIpo.getContentPane().setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(10, 11, 475, 249);
			frmProjectwizardIpo.getContentPane().add(panel);
			panel.setLayout(null);
			{
				comboBox = new JComboBox();
				comboBox.setBounds(316, 34, 100, 20);
				panel.add(comboBox);
			}
			{
				lblIdioma = new JLabel("Idioma");
				lblIdioma.setBounds(190, 37, 46, 14);
				panel.add(lblIdioma);
			}
			{
				lblUsuario = new JLabel("Usuario");
				lblUsuario.setBounds(190, 81, 46, 14);
				panel.add(lblUsuario);
			}
			{
				lblContrasea = new JLabel("Contraseña");
				lblContrasea.setBounds(185, 140, 105, 14);
				panel.add(lblContrasea);
			}
			{
				passwordField = new JPasswordField();
				passwordField.addKeyListener(new PasswordFieldKeyListener());
				passwordField.setBounds(316, 137, 154, 20);
				panel.add(passwordField);
			}
			{
				MaskFormatter usuario;
				try{
					usuario=new MaskFormatter("########");
					usuario.setPlaceholderCharacter('O');
				userField = new JFormattedTextField(usuario);
				userField.setBounds(316, 78, 154, 20);
				} catch (ParseException ex) {
					ex.printStackTrace();
					// ESTA NO
				}
				panel.add(userField);
			}
			{
				btnIniciarSesion = new JButton("INICIAR SESION");
				btnIniciarSesion.addActionListener(new BtnIniciarSesionActionListener());
				btnIniciarSesion.addMouseListener(new BtnIniciarSesionMouseListener());
				btnIniciarSesion.addKeyListener(new BtnIniciarSesionKeyListener());
				btnIniciarSesion.setBounds(146, 221, 144, 23);
				btnIniciarSesion.setEnabled(false);
				panel.add(btnIniciarSesion);
			
			}
			{
				button = new JButton("REGISTRARSE");
				button.setBounds(326, 221, 144, 23);
				button.addMouseListener(new ButtonMouseListener());
				panel.add(button);
			}
			{
				lblnoEstRegistrado = new JLabel("¿No está registrado?");
				lblnoEstRegistrado.setBounds(316, 196, 154, 14);
				lblnoEstRegistrado.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblnoEstRegistrado);
			}
			{
				lblLogo = new JLabel("");
				lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
				lblLogo.setIcon(new ImageIcon(VentanaInicio.class.getResource("/resources/login.png")));
				lblLogo.setBounds(10, 28, 144, 141);
				panel.add(lblLogo);
			}
			{
				lblStatus = new JLabel("");
				lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblStatus.setBounds(185, 165, 285, 20);
				panel.add(lblStatus);
			}
		}
	}
	
	
	private class ButtonMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			frmProjectwizardIpo.setVisible(false);
			try{
				frmProjectwizardIpo.dispose();
				VentanaRegistro registro=new VentanaRegistro(con, frmProjectwizardIpo);
				registro.frmProjectwizardIpo.setVisible(true);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	
	}
	private class BtnIniciarSesionKeyListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {

		
		}
	}
	private class BtnIniciarSesionMouseListener extends MouseAdapter {
		private Border fallo = BorderFactory.createLineBorder(Color.RED);
		private Border acierto = BorderFactory.createLineBorder(Color.GREEN);
		@Override
		public void mouseClicked(MouseEvent e) {
			
			String user=userField.getText();
			if (con.loggin(user, passwordField.getPassword())==null) {
				userField.setBorder(fallo);
				passwordField.setBorder(fallo);
				lblStatus.setText("ERROR DE AUTENTICACION");
			} else{
				userField.setBorder(acierto);
				lblStatus.setText("IDENTIFICACION CORRECTA");
				passwordField.setBorder(acierto);
				usuario us = con.BuscarUsuario(userField.getText());
				us.marcarlog();
				try {
					con.marcarLog(us);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frmProjectwizardIpo.dispose();
				new VentanaProyectos();
				System.exit(0);
				
			}
		}
	}
	private class PasswordFieldKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (passwordField.getPassword().length < 4) btnIniciarSesion.setEnabled(false);
			else btnIniciarSesion.setEnabled(true);
		}
		
	}
	private class BtnIniciarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}
}
