package com.frogger;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Turtle extends GameObject{
	
	private BufferedImage turtle_image;
	

public Turtle(int x, int y, ID id, double velx) {
		super(x, y, id);
		this.velx = velx;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		turtle_image = ss.grabImage(0, 4, 32, 32);
	}


	public void tick() {
		x += velx;
		y += vely;
		
		Toolkit.getDefaultToolkit().sync();
		
	}


	public void render(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillRect(x, y, 32, 30);
		//g.setColor(Color.BLACK);
		//g.drawRect(x, y, 32, 30);
		g.drawImage(turtle_image, x, y, null);
		
		Toolkit.getDefaultToolkit().sync();		
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 30);
	}
	
}
