package com.frogger;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	
	//private int scorekeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
		double velx = 1.25;
		
		int height = 64;
		int offset = 16;
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Log(offset + j, height, ID.Log, velx));
		}
		
		velx *= -1;
		height += 32;
		offset = 16;
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Turtle(offset + j, height, ID.Turtle, velx));
		}
		
		velx *= -1;
		height += 32;
		offset += 16;
		
		for(int j = 0; j < Game.WIDTH; j += 190){
			handler.addObject(new Log(offset + j, height, ID.Log, velx));
		}
		
		
		offset += 16;
		height += 64;
		
		
		for(int j = 0; j < Game.WIDTH; j += 270){
			handler.addObject(new Car(offset + j, height, ID.Car, velx, false));
		}
		
		velx *= -1;
		height += 32;
		offset += 16;
		
		for(int j = 0; j < Game.WIDTH; j += 270){
			handler.addObject(new Truck(offset + j, height, ID.Truck, velx));
		}
		
		velx *= -1;
		height += 32;
		offset += 16;
		
		int z = 0;
		handler.addObject(new Car(offset + z, height, ID.Car, velx, false));
		z += 270;
		handler.addObject(new Car(offset + z, height, ID.Car, velx, true));
		z += 270;
		handler.addObject(new Car(offset + z, height, ID.Car, velx, false));
		
		velx *= -1;
		height += 32;
		offset += 16;
		
		for(int j = 0; j < Game.WIDTH; j += 270){
			handler.addObject(new Car(offset + j, height, ID.Car, velx, false));
		}
		
		handler.addObject(new Player(320, Game.HEIGHT - 96, ID.Player, handler, false, false));
	}
}
