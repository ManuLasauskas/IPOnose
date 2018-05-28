package Presentacion;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class VentanaProyectos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProyectos window = new VentanaProyectos();
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
	public VentanaProyectos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();
	;
		frame.setBounds(0, 0, 	(int)tk.getScreenSize().getWidth()-30, (int)	tk.getScreenSize().getHeight()-30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(241, 98, 1069, 590);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Información", new ImageIcon(VentanaProyectos.class.getResource("/Resources/signs.png")), panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Tareas", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Chat", null, panel_2, null);
		
		JLabel lblNewLabel = new JLabel("Ayuda");
		lblNewLabel.setIcon(new ImageIcon(VentanaProyectos.class.getResource("/Resources/help.png")));
		lblNewLabel.setBounds(1240, 21, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Mis proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 98, 224, 590);
		frame.getContentPane().add(panel_3);
	}
}
