package com.frogger;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Truck extends GameObject{
	
	private BufferedImage truck_image;

	public Truck(int x, int y, ID id, double velx) {
		super(x, y, id);
		
		this.velx = velx;
		this.setVely(0);
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		truck_image = ss.grabImage(100, 2, 80, 32);
	}

	public void tick() {
		x += velx;
		
	}

	public void render(Graphics g) {
		g.drawImage(truck_image, x, y, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 80, 32);
	}

}
