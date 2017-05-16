package com.frogger;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 672, HEIGHT = 416;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Frogger", this);
		
		handler.addObject(new Player(320, HEIGHT - 96, ID.Player));
		//handler.addObject(new Car(WIDTH / 2 - 64, HEIGHT / 2 - 64, ID.Car));
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
		handler.tick();
	}

	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT / 13);

		g.setColor(Color.BLUE);
		g.fillRect(0, 32, WIDTH, HEIGHT / 13 * 4);
		
		g.setColor(Color.GREEN);
		for(int i = 0; i < WIDTH; i += 64){
			g.fillRect(i, 32, 32, 32);
		}
		for(int i = 32; i <= WIDTH; i+= 64){
			g.fillArc(i, 32, 31, 31, 0, 360);
		}
		
		g.fillRect(0, 160, WIDTH, HEIGHT / 13);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 192, WIDTH, HEIGHT / 13 * 4);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 320, WIDTH, HEIGHT / 13);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 352, WIDTH, HEIGHT / 13 + 10);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		new Game();
	}
	
}
