package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class DialogAyuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public DialogAyuda() {
		setTitle(MessagesIPROject.getString("DialogAyuda.this.title")); //$NON-NLS-1$
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogAyuda.class.getResource("/Resources/help.png")));
		setBounds(100, 100, 453, 157);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{146, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{15, 148, 79, 159, 0};
		gbl_contentPanel.rowHeights = new int[]{37, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel(MessagesIPROject.getString("DialogAyuda.lblNewLabel.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridwidth = 4;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JButton btnYT = new JButton("");
			btnYT.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							try {
								if (Desktop.isDesktopSupported()) {
									Desktop desktop = Desktop.getDesktop();
									if (desktop.isSupported(Desktop.Action.BROWSE)) {
										desktop.browse(new URI("https://www.youtube.com/watch?v=eEKfWVvADiQ"));
									}
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
			}
					);
			
			btnYT.setIcon(new ImageIcon(DialogAyuda.class.getResource("/Resources/Youtube.png")));
			btnYT.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_btnYT = new GridBagConstraints();
			gbc_btnYT.insets = new Insets(0, 0, 5, 5);
			gbc_btnYT.gridx = 2;
			gbc_btnYT.gridy = 1;
			contentPanel.add(btnYT, gbc_btnYT);
			
			
		}
		{
			JButton btnOk = new JButton("OK");
			btnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			GridBagConstraints gbc_btnOk = new GridBagConstraints();
			gbc_btnOk.insets = new Insets(0, 0, 0, 5);
			gbc_btnOk.gridx = 2;
			gbc_btnOk.gridy = 2;
			contentPanel.add(btnOk, gbc_btnOk);
		}
	}

}
