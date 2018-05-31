package Presentacion;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagen extends JPanel {
	int x, y;
	String Route;

    public Imagen(String Route) {
    	this.Route=Route;
    	x=100;
    	y=100;
        this.setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
 
    	try {
    		
    		ImageIcon Img = new ImageIcon(Route);
    		Img = new ImageIcon(Img.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
    		g.drawImage(Img.getImage(), 0, 0, x, y, null);
    		
    	}catch(Exception e) {
    		
    	}
    	
    }    

}
