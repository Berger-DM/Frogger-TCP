package com.frogger;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;


public class Car extends GameObject{
	
	private int carsize = 50;
	private BufferedImage car_image, i_car_img;
	private boolean crazy;
	
	public Car(int x, int y, ID id, double velx, boolean crazy){
		super(x, y, id);
		
		this.velx = velx;
		this.crazy = crazy;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		car_image = ss.grabImage(0, 2, carsize, 32);
		i_car_img = ss.grabImage(50, 2, carsize, 32);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, carsize - 6, 24);
	}
	
	public boolean getCrazy(){
		return this.crazy;
	}
	
	public void setCrazy(boolean b){
		this.crazy = b;
	}
	
	public void tick(){
		x += velx;
		y += vely;
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){ 
		if(velx > 0)
			g.drawImage(i_car_img, x, y, null);
		else
			g.drawImage(car_image, x, y, null);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
