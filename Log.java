package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Log extends GameObject{

	public Log(int x, int y, ID id, double velx){
		super(x, y, id);
		
		this.velx = velx;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 64, 30);
	}
	
	public void tick(){
		x += velx;
		y += vely;
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){ 
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, 64, 30);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 64, 30);
		
		Toolkit.getDefaultToolkit().sync();
	}
}
