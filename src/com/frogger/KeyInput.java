package com.frogger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.frogger.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private int step = 32;
	private boolean paused = false;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < Handler.object.size(); i++){
			GameObject tempObject = Handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				
				if(key == KeyEvent.VK_W){
					((Player) tempObject).setCurFace(0);
					moveUp(tempObject);
				}
				if(key == KeyEvent.VK_A){
					((Player) tempObject).setCurFace(3);
					moveLeft(tempObject);
				}
				if(key == KeyEvent.VK_S){
					((Player) tempObject).setCurFace(2);
					moveDown(tempObject);
				}
				if(key == KeyEvent.VK_D){
					((Player) tempObject).setCurFace(1);
					moveRight(tempObject);
				}
			}
				
		}
		

		if(key == KeyEvent.VK_ESCAPE) {
			if(!paused){
				Game.gameState = STATE.Pause;
				paused = true;
			}
			else {
				Game.gameState = STATE.Game;
				paused = false;
			}
		}
	}
	
	private void moveUp(GameObject object){
		object.setY(object.getY() - step);
		object.setVelx(0);
	}
	private void moveLeft(GameObject object){
		object.setX(object.getX() - step);
		object.setVelx(0);
	}
	private void moveDown(GameObject object){
		object.setY(object.getY() + step);
		object.setVelx(0);
	}
	private void moveRight(GameObject object){
		object.setX(object.getX() + step);
		object.setVelx(0);
	}
	
	/*public void keyReleased(KeyEvent e){
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
	}*/

}
