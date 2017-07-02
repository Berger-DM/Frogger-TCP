package com.frogger;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Game extends Canvas implements Runnable{
	
     
    
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 672, HEIGHT = 416;
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	
	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	private Menu menu;
        public static HighScores highscore /*highscore*/ = new HighScores();
        public static Files file;
	
	public enum STATE{
		Menu,
		Game,
		Highscore,
		Over
	};       
              
	public static STATE gameState = STATE.Menu;
	
	public static BufferedImage sprite_sheet;
	
	public Game() throws FileNotFoundException{
		
		BufferedImageLoader loader = new BufferedImageLoader();
		sprite_sheet = loader.loadImage("/spritesheet.png");
		
		handler = new Handler();
		hud = new HUD();
                
		menu = new Menu(this, handler, hud, highscore);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
                
                //MUDAR DEPOIS
                
                file = new Files();
                if(!(file.exists())){
                    file.createsFile();
                    file.initializesScoresFile();
                }
                
                highscore.initializesHighScores();
                
		new Window(WIDTH, HEIGHT, "Frogger", this);	                
                
		spawn = new Spawn(handler,hud);
		
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		
		if(gameState == STATE.Game){
			handler.tick();
			hud.tick();
		}
		
		if(gameState == STATE.Menu || gameState == STATE.Over){
			menu.tick();
		}
		
		
		
		Toolkit.getDefaultToolkit().sync();
	}

	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		drawBG(g);
		
		handler.render(g);
		
		if(gameState == STATE.Game){
			hud.render(g);
		} else if(gameState == STATE.Menu || gameState == STATE.Over){
			menu.render(g);
		}
		
		
		
		g.dispose();
		bs.show();
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void drawBG(Graphics g){
		BufferedImage bg_image;
		SpriteSheet ss = new SpriteSheet(sprite_sheet);
		bg_image = ss.grabImage(6, 224, 416);
		for(int i = 0; i < 4; i++){
			g.drawImage(bg_image, i * 224, 0, null);
		}
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String args[]) throws FileNotFoundException{
         
		new Game();

	}
	
}
