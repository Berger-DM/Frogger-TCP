package com.frogger;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	//private int scorekeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
		double velx = 1.5;
		
		int offset = 16;
		for(int i = 64; i < 129; i += 32){
			for(int j = 0; j < Game.WIDTH; j += 190){
				handler.addObject(new Log(offset + j + r.nextInt(10), i, ID.Log, velx));
			}
			velx *= -1;
			offset += 16;
		}
		
		offset = 16;
		for(int i = 192; i < 289; i += 32){
			for(int j = 0; j < Game.WIDTH; j += 190){
				handler.addObject(new Car(offset + j + r.nextInt(10), i, ID.Car, velx));
			}
			velx *= -1;
			offset += 16;
		}
		
		handler.addObject(new Player(320, Game.HEIGHT - 96, ID.Player, handler));
	}
}
