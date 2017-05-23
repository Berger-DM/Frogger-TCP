package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameObject{
	
	Handler handler;
	private boolean midway = true;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velx;
		
		if(this.getY() == 32){
			HUD.levelup();
			this.setX(320);
			this.setY(Game.HEIGHT - 96);
			midway = true;
		}
		
		if(this.getY() == 160 && midway){
			HUD.midway();
			midway = false;
		}
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 32, Game.HEIGHT - 96);
		
		collision();
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			ID tempId = tempObject.getId();
			
			if(tempId == ID.Car){
				if(this.getBounds().intersects(tempObject.getBounds())) {
					splat();
				}
			}
			else if(tempId == ID.Log){
				if(this.getBounds().intersects(tempObject.getBounds())) {
					this.setVelx(tempObject.getVelx());
				}
			}
		}

	}
	
	private void splat(){
		HUD.lives --;
		this.setX(320);
		this.setY(Game.HEIGHT - 96);
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 32, 32);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
