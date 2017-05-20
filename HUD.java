package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class HUD {

	public static int lives = 3;
	
	public void tick(){
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("LIVES: ", 0, 0);
		g.setColor(Color.ORANGE);
		for(int i = 0; i < 96; i += 32){
			g.fillArc(i, 0, 31, 31, 0, 360);
		}
		
		Toolkit.getDefaultToolkit().sync();
		
	}
}
