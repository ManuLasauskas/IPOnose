package Presentacion;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends JPanel {
	int x, y;
	ImageIcon Img;

    public Imagen(String Route,JPanel jPanel1) {
    	Img = new ImageIcon(getClass().getResource(Route));
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }    


}
