package com.frogger;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected double velx, vely;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int d){
		this.y = d;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setID(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelx(double d){
		this.velx = d;
	}
	public void setVely(double d){
		this.vely = d;
	}
	public double getVelx(){
		return velx;
	}
	public double getVely(){
		return vely;
	}
}
