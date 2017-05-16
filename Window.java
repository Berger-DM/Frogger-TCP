package com.frogger;
import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;
import javax.swing.*;

public class Window extends Canvas{

	private static final long serialVersionUID = 1L;
	
	//private BufferedImage myImage;

	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		/*
		try {
			myImage = ImageIO.read(new File("src/com/frogger/frogger.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setContentPane(new ImagePanel(myImage));
		
		int w = myImage.getWidth(this);
		int h = myImage.getHeight(this);
		*/
		
		//frame.setPreferredSize(new Dimension(w,h));
		//frame.setMaximumSize(new Dimension(w,h));
		//frame.setMinimumSize(new Dimension(w,h));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
	@SuppressWarnings("serial")
	class ImagePanel extends JComponent{
		private Image img;
		public ImagePanel(Image img){
			this.img = img;
		}
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
	}
}
