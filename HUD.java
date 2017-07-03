package com.frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Scanner;

public class HUD {

	public static int lives = 3;
	
	private static int score = 0;
	private static int level = 1;
	private static int cur_lives = 3;
        private static HighScores highscore = new HighScores();
        private static Files file = new Files();
        private Scanner userInput = new Scanner(System.in);
        private String playerName;
	
	
	public void tick(){
		if(lives < 1){
                   gameOver();                   
                   
                   if(score > Game.highscore.scores[HighScores.MAX_SCORES - 1]){
                       
                        //playerName = userInput.nextLine();
                        Game.highscore.updateHighScores("playerName", score);
                        Game.file.updatesScoresFile(Game.highscore.names, Game.highscore.scores);
                   }
                   Toolkit.getDefaultToolkit().sync();
                }

	public void tick(){
		if(lives < 1) gameOver();
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
		for(int i = 0; i < Handler.object.size(); i++){

                    Handler.object.remove();
		}
                
               // Game.gameState = STATE.Over;
			Handler.object.remove();	
		}
		//Game.gameState = STATE.Over;
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
