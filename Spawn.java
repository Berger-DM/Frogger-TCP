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
		
		int height = 64;
		int offset = 16;
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Log(offset + j + r.nextInt(20), height, ID.Log, velx));
		}
		
		velx *= -1;
		height += 32;
		offset = 16;
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Turtle(offset + j + r.nextInt(20), height, ID.Turtle, velx));
		}
		
		velx *= -1;
		height += 32;
		offset += 16 * r.nextInt(4);
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Log(offset + j + r.nextInt(10), height, ID.Log, velx));
		}
		
		
		offset += 16 * r.nextInt(4);
		height += 64;
		
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Car(offset + j + r.nextInt(10), height, ID.Car, velx));
		}
		
		velx *= -1;
		height += 32;
		offset += 16 * r.nextInt(4);
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Truck(offset + j + r.nextInt(10), height, ID.Truck, velx));
		}
		
		velx *= -1;
		height += 32;
		offset += 16 * r.nextInt(4);
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Car(offset + j + r.nextInt(10), height, ID.Car, velx));
		}
		
		velx *= -1;
		height += 32;
		offset += 16 * r.nextInt(4);
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Car(offset + j + r.nextInt(10), height, ID.Car, velx));
		}
		
		handler.addObject(new Player(320, Game.HEIGHT - 96, ID.Player, handler, false));
	}
}
