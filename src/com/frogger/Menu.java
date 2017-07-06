package com.frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.frogger.Game.STATE;

public class Menu extends MouseAdapter{
	
	private static Game game;
	private Handler handler;
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 236, 127, 200, 32) && Game.gameState == STATE.Menu){
			game.gameState = STATE.Game;
		}
		
		if(mouseOver(mx, my, 236, 192, 200, 32) && Game.gameState == STATE.Menu){
			game.gameState = STATE.Highscore;
			showHighscore();
			game.gameState = STATE.Menu;
		}
		
		if(mouseOver(mx, my, 236, 256, 200, 32) && Game.gameState == STATE.Menu){
			System.exit(0);
		}
	}

	public static void showHighscore() {
		String msg = "";
		for (int i = 0; i < game.hs.length; i++){
			msg += Integer.toString(i + 1) + ". " + game.hs[i].name + " - " + game.hs[i].score + "\n";
		}
		JOptionPane.showMessageDialog(game, msg);
	}
	
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			} else return false;
		} else return false;
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		Font font = new Font("arial", 1, 50);
		Font font2 = new Font("arial", 1, 24);
		
		
		if(Game.gameState == STATE.Menu){
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Frogger", 240, 106);
			
			g.setFont(font2);
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(236, 127, 200, 32);
			g.setColor(Color.BLACK);
			g.drawRect(236, 127, 200, 32);
			g.drawString("Play", Game.WIDTH/2 - 24, 149);
				
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(236, 192, 200, 32);
			g.setColor(Color.BLACK);
			g.drawRect(236, 192, 200, 32);
			g.drawString("Highscores", Game.WIDTH/2 - 60, 214);
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(236, 256, 200, 32);
			g.setColor(Color.BLACK);
			g.drawRect(236, 256, 200, 32);
			g.drawString("Quit", Game.WIDTH/2 - 24, 278);
		} else if(Game.gameState == STATE.Over){
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 180, 106);
			g.drawString("Your Score: " + hud.getScore(), 150, 200);
		}
		
	}
}
