package com.frogger;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.awt.image.BufferedImage;

import java.util.Random;

public class Car extends GameObject{

        private Random r = new Random();
	private int carsize = 50;
	private BufferedImage car_image;
	

	private Random r = new Random();
	private int carsize;

	public Car(int x, int y, ID id, double velx){
		super(x, y, id);
		
		this.velx = velx;
 
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		car_image = ss.grabImage(1, carsize, 32);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, carsize, 24);

		this.carsize = 60 + r.nextInt(20);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, carsize - 4, 24);
	}
	
	public void tick(){
		x += velx;
		y += vely;
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){ 

		g.drawImage(car_image, x, y, null);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
