package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class Car extends GameObject{
	
	private Random r = new Random();
	private int carsize;
	
	public Car(int x, int y, ID id, double velx){
		super(x, y, id);
		
		this.velx = velx;
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
		g.setColor(Color.RED);
		g.fillRect(x, y, carsize, 30);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, carsize, 30);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
