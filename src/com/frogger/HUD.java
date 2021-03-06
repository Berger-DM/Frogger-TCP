package com.frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import com.frogger.Game.STATE;

public class HUD {

	public static int lives = 3;
	
	private static int score = 0;
	private static int level = 1;
	private static int cur_lives = 3;
	private static String hs_name;
	
	public void tick(){
		if(lives < 1) {
			Game.gameState = STATE.Over;
			
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){
		Font font = new Font("arial", 1, 24);
		
		g.setFont(font);
		g.setColor(Color.ORANGE);
		g.drawString("LIVES: " + lives, 8, 24);
		g.drawString("SCORE: " + score, 512, 24);
		g.drawString("LEVEL: " + level, 8, 380);
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	public static void levelup(){
		if(cur_lives != lives) score += 100;
		else score += 200;
		level ++;
		Handler.upspeed();
		cur_lives = lives;
	}
	
	public static void midway(){
		if(cur_lives != lives) score += 10;
		else score += 20;
	}
	
	public static void gameOver(){
		if(score > Game.low.score) {
			hs_name = JOptionPane.showInputDialog("New Highscore! Input your name for the records!");
			Highscore.updateHSArray(Game.hs, hs_name, score);
			DBManager.updateHighscores(Game.hs);
			DBManager.getHighscores(Game.hs);
		}
		Menu.showHighscore();
	}
	
	
	public void score(int score){
		this.score = score;	
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
}
