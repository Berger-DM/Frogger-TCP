package com.frogger;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.Random;

import com.frogger.Game.STATE;

public class Handler {

	static LinkedList<GameObject> object = new LinkedList<GameObject>();
	Random r = new Random();
	
	public void tick(){
            for (GameObject tempObject : object) {
                if(tempObject.x > Game.WIDTH && tempObject.velx > 0){
                    Boolean mult = r.nextBoolean();
                    if (mult) tempObject.setX(-64 - r.nextInt(5));
                    else tempObject.setX(-64 + r.nextInt(5));
                }
                if(tempObject.x < -64 && tempObject.velx < 0){
                    Boolean mult = r.nextBoolean();
                    if(mult) tempObject.setX(Game.WIDTH + r.nextInt(10));
                    else tempObject.setX(Game.WIDTH - r.nextInt(12));
                    
                }
                tempObject.tick();
            }
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public static void upspeed(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			

			if(tempObject.getId() == ID.Car || tempObject.getId() == ID.Log){
				if(tempObject.getVelx() < 0) tempObject.setVelx(tempObject.getVelx() - 0.25);
				else tempObject.setVelx(tempObject.getVelx() + 0.125);

			if(tempObject.x > Game.WIDTH){
				Boolean mult = r.nextBoolean();
				if (mult) tempObject.setX(-64 - r.nextInt(10));
				else tempObject.setX(-64 + r.nextInt(12));
			}
			if(tempObject.x < -64 && tempObject.getVelx() < 0){
				Boolean mult = r.nextBoolean();
				if(mult) tempObject.setX(Game.WIDTH + r.nextInt(10));
				else tempObject.setX(Game.WIDTH - r.nextInt(12));

			}

		}
	}
	
	public static void upspeed(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Car || tempObject.getId() == ID.Log){
				if(tempObject.getVelx() < 0) tempObject.setVelx(tempObject.getVelx() - 0.25);
				else tempObject.setVelx(tempObject.getVelx() + 0.125);
			}

		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void addObject(GameObject object){
		Handler.object.add(object);
	}
	
	public void removeObject(GameObject object){
		Handler.object.remove(object);
	}
}
