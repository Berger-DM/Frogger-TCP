package com.frogger;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.frogger.Game.STATE;

public class Player extends GameObject{
	
	Handler handler;
	private boolean midway = true;
	private boolean log_col = false;
	private boolean moving = false;
	private int current_face = 0;
	
	private BufferedImage[] player_image;

	public Player(int x, int y, ID id, Handler handler, boolean log_col, boolean moving) {
		super(x, y, id);
		
		this.handler = handler;
		this.log_col = log_col;
		this.moving = moving;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		player_image = new BufferedImage[4];
		player_image[0] = ss.grabImage(0, 0, 32, 32);
		player_image[1] = ss.grabImage(32, 0, 32, 32);
		player_image[2] = ss.grabImage(64, 0, 32, 32);
		player_image[3] = ss.grabImage(96, 0, 32, 32);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		this.x += velx;
		this.y += vely;
		
		
		int cur_Y = this.getY();
		
		if(cur_Y == 32){
			HUD.levelup();
			this.setX(320);
			this.setY(Game.HEIGHT - 96);
			midway = true;
		}
		
		if(cur_Y == 160 && midway){
			HUD.midway();
			midway = false;
		}
		
		

		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 32, Game.HEIGHT - 96);
		
		collision();
		
		if(cur_Y < 160 && cur_Y > 32){
			//if(this.getLogCol() == false) splat();
		}
		
		this.setLogCol(false);
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	private void collision() {
		for(int i = 0; i < Handler.object.size(); i++) {
			
			GameObject tempObject = Handler.object.get(i);
			ID tempId = tempObject.getId();
			
			if(tempId == ID.Car || tempId == ID.Truck){
				if(this.getBounds().intersects(tempObject.getBounds())) {
					splat();
				}
			}
			else if(tempId == ID.Log || tempId == ID.Turtle){
				if(this.getBounds().intersects(tempObject.getBounds())) {
					log_col = true;
					this.setVelx(tempObject.getVelx());
				}
			}
		}

	}
	
	private void splat(){
		System.out.println("splat");
		HUD.lives --;
		if(HUD.lives < 1) {
			Game.gameState = STATE.Over;
			HUD.gameOver();
		}
		this.setX(320);
		this.setY(Game.HEIGHT - 96);
	}
	
	public boolean getLogCol(){
		return log_col;
	}
	
	public void setLogCol(boolean b){
		this.log_col = b;
	}
	
	public void setMoving(boolean b){
		this.moving = b;
	}
	
	public boolean getMoving(){
		return this.moving;
	}
	
	public void setCurFace(int i){
		this.current_face = i;
	}
	
	
	public void render(Graphics g) {
		g.drawImage(player_image[current_face], x, y, null);
		
	}
	


}
