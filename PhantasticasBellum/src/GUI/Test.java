package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import java.awt.BorderLayout;

public class Test extends JPanel{
	private Image background;
	
	public Test(){
		setPreferredSize(new Dimension(600, 600));
		background = (new ImageIcon(this.getClass().getResource("/images/back.jpg"))).getImage();
	}
	
	public void paintComponent(Graphics g) {
		 //super.paintComponent(g);
		 g.drawImage(
			 background, 
			 0, 
			 0, 
			 null
		);
	 }
}
