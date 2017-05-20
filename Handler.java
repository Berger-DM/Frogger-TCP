package com.frogger;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.x > Game.WIDTH){
				removeObject(tempObject);
				System.out.println("Objeto removido");
			}
			tempObject.tick();
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
