package com.frogger;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Log extends GameObject{
	
	private Random r = new Random();
	private int logsize = 85;
	private BufferedImage log_image;

	public Log(int x, int y, ID id, double velx){
		super(x, y, id);
		
		this.velx = velx;
		//this.logsize = 60 + r.nextInt(40);
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		log_image = ss.grabImage(3, 85, 32);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, logsize, 32);
	}
	
	public void tick(){
		x += velx;
		y += vely;
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){ 
		//g.setColor(Color.MAGENTA);
		//g.fillRect(x, y, logsize, 30);
		//g.setColor(Color.BLACK);
		//g.drawRect(x, y, logsize, 30);
		g.drawImage(log_image, x, y, null);
		
		Toolkit.getDefaultToolkit().sync();
	}
}
