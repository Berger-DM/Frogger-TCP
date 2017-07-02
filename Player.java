package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.frogger.Game.STATE;

public class Player extends GameObject{
	
	Handler handler;
	private boolean midway = true;
	private boolean log_col = false;
	
	private BufferedImage player_image;

	public Player(int x, int y, ID id, Handler handler, boolean log_col) {
		super(x, y, id);
		
		this.handler = handler;
		this.log_col = log_col;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		player_image = ss.grabImage(0, 32, 32);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velx;
		
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
			if(this.getLogCol() == false) splat();
		}
		
		this.setLogCol(false);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void collision() {
            for (GameObject tempObject : handler.object) {
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
			HUD.gameOver();
			Game.gameState = STATE.Over;
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
	
	
	public void render(Graphics g) {
		//g.setColor(Color.ORANGE);
		//g.fillRect(x, y, 32, 32);
		
		g.drawImage(player_image, x, y, null);
		
		Toolkit.getDefaultToolkit().sync();
	}

}
