package com.frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class HUD {

	public static int lives = 3;
	
	private static int score = 0;
	private static int level = 1;
	private static int cur_lives;
	
	public void tick(){
		if(lives < 1) System.exit(0);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.setColor(Color.ORANGE);
		/*for(int i = 0; i < 96; i += 32){
			g.fillArc(i, 0, 31, 31, 0, 360);
		}*/
		g.drawString("LIVES: " + lives, 10, 16);
		g.drawString("SCORE: " + score, 606, 16);
		g.drawString("LEVEL: " + level, 10, 376);
		cur_lives = lives;
		
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
