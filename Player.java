package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameObject{
	
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velx;
		y += vely;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 32, Game.HEIGHT - 96);
		
		collision();
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Car){
				if(this.getBounds().intersects(tempObject.getBounds())) {
					System.out.println("YAY");
				}
			}
		}

	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 32, 32);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
