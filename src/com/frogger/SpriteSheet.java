package com.frogger;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sprite;
	
	public SpriteSheet(BufferedImage ss){
		this.sprite = ss;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height){
		BufferedImage img = sprite.getSubimage(col, row * 32, width, height);
		return img;
	}

}
