package com.frogger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				
				if(key == KeyEvent.VK_W) tempObject.setVely(-2);
				if(key == KeyEvent.VK_A) tempObject.setVelx(-2);
				if(key == KeyEvent.VK_S) tempObject.setVely(2);
				if(key == KeyEvent.VK_D) tempObject.setVelx(2);
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key  = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				
				if(key == KeyEvent.VK_W) tempObject.setVely(0);
				if(key == KeyEvent.VK_A) tempObject.setVelx(0);
				if(key == KeyEvent.VK_S) tempObject.setVely(0);
				if(key == KeyEvent.VK_D) tempObject.setVelx(0);
			}
		}
	}

}
