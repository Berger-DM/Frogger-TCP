package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Car extends GameObject{
	
	public Car(int x, int y, ID id){
		super(x, y, id);
		
		velx = 2;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 40, 24);
	}
	
	public void tick(){
		x += velx;
		y += vely;
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){ 
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 40, 24);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
