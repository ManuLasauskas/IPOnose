package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import Dominio.Usuario;
import Persistencia.Agente;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.util.*;

public class Chat {
	
	private Usuario user;
	private JFrame frame;
	private JTextField Mensaje;
	private JTextArea textArea;
	private Agente agente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
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
	public Chat() {
		initialize();
	}
	
	public Chat(Usuario user) {
		initialize();
		this.user=user;
		agente = Agente.getInstance();
		CargarMensajes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{436, 0};
		gbl_panel.rowHeights = new int[]{129, 89, 50, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		panel.add(textArea, gbc_textArea);
		
		Mensaje = new JTextField();
		GridBagConstraints gbc_Mensaje = new GridBagConstraints();
		gbc_Mensaje.insets = new Insets(0, 0, 5, 0);
		gbc_Mensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_Mensaje.gridx = 0;
		gbc_Mensaje.gridy = 1;
		panel.add(Mensaje, gbc_Mensaje);
		Mensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscribirTexto(Mensaje.getText());
			}
		});
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.gridx = 0;
		gbc_btnEnviar.gridy = 2;
		panel.add(btnEnviar, gbc_btnEnviar);
	}
	
	public void EscribirTexto(String Mensage) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Mensage=dateFormat.format(date)+user.getNombre()+" "+user.getApellido()+" :"+Mensage;
		agente.ActualizarHistorialMensajes(Mensage);
		textArea.append(Mensage);
	}
	
	public void CargarMensajes() {
		ArrayList<String> ChatLog=agente.GetHistorialMensajes();
		for(int i=0;i<ChatLog.size();i++) {
			textArea.append(ChatLog.get(i));
		}
	}

}
