package Presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dominio.Usuario;
import Persistencia.Agente;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;

public class UserChat extends JPanel {
	private JTextField textField;
	private Usuario user;
	private JTextArea RegistroChat;
	private JComboBox<Usuario> SelectorChat;
	
	public UserChat(Usuario user) {
		this.user=user;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 251, 138, 0, 0};
		gridBagLayout.rowHeights = new int[]{66, 146, 51, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		SelectorChat = new JComboBox<Usuario>();
		ArrayList<Usuario> Contactos=user.getUsuariosParaChatear();
		for(int i=0;i<Contactos.size();i++) {
			SelectorChat.addItem(Contactos.get(i));
		}
		GridBagConstraints gbc_SelectorChat = new GridBagConstraints();
		gbc_SelectorChat.insets = new Insets(0, 0, 5, 5);
		gbc_SelectorChat.fill = GridBagConstraints.HORIZONTAL;
		gbc_SelectorChat.gridx = 2;
		gbc_SelectorChat.gridy = 0;
		add(SelectorChat, gbc_SelectorChat);
		
		RegistroChat = new JTextArea();
		GridBagConstraints gbc_RegistroChat = new GridBagConstraints();
		gbc_RegistroChat.gridwidth = 2;
		gbc_RegistroChat.insets = new Insets(0, 0, 5, 5);
		gbc_RegistroChat.fill = GridBagConstraints.BOTH;
		gbc_RegistroChat.gridx = 1;
		gbc_RegistroChat.gridy = 1;
		add(RegistroChat, gbc_RegistroChat);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		SelectorChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clean();
				CargarMensajes((Usuario) SelectorChat.getSelectedItem());
			}
		});
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.gridwidth = 2;
		gbc_btnEnviar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnviar.gridx = 1;
		gbc_btnEnviar.gridy = 3;
		add(btnEnviar, gbc_btnEnviar);
		
	}
	
	public void Clean() {
		RegistroChat.setText("");
		textField.setText("");
	}
	
	public void EscribirTexto(String Mensaje) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Mensaje=dateFormat.format(date)+user.getNombre()+" "+user.getApellido()+" :"+Mensaje;
		user.ActualizarChat((Usuario) SelectorChat.getSelectedItem(), Mensaje);
		((Usuario) SelectorChat.getSelectedItem()).ActualizarChat(user, Mensaje);
		RegistroChat.append(Mensaje);
	}
	
	public void CargarMensajes(Usuario u) {
		ArrayList<String> ChatLog=user.getUserChat(u);
		for(int i=0;i<ChatLog.size();i++) {
			RegistroChat.append(ChatLog.get(i));
		}
	}

}
