package com.frogger;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.Random;


public class Handler {

	static LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.x > Game.WIDTH && tempObject.velx > 0){
				tempObject.setX(-64);
			}
			if(tempObject.x < -64 && tempObject.velx < 0){
				tempObject.setX(Game.WIDTH);
				
			}
			if(tempObject.getId() == ID.Car && ((Car) tempObject).getCrazy() == true){
				System.out.println("crazy car found");
				for(int j = 0; j < object.size(); j++){
					GameObject tempObj2 = object.get(j);
					
					if(tempObj2.getId() == ID.Car)
						if(tempObject.getY() < tempObj2.getY())
							if(tempObject.getX() < tempObj2.getX() - 50 && tempObject.getX() > tempObj2.getX() + 50) {
								tempObject.setY(tempObject.getY() + 32);
								tempObject.setVelx(tempObject.getVelx() * -1);
							}
				}
				((Car) tempObject).setCrazy(false);
			}
			tempObject.tick();
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public static void upspeed(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Car || tempObject.getId() == ID.Log){
				if(tempObject.getVelx() < 0) tempObject.setVelx(tempObject.getVelx() - 0.125);
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
