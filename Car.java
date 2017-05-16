package com.frogger;

import java.awt.Color;
import java.awt.Graphics;

public class Car extends GameObject{
	
	public Car(int x, int y, ID id){
		super(x, y, id);
	}
	
	
	public void tick(){
		x += velx;
		y += vely;
	}
	
	public void render(Graphics g){ 
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 16, 16);
	}

}
