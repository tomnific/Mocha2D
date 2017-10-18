package com.tommetzger.mocha2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;





public class Action 
{
	public int speed;
	
	
	
	
	private int numberOfFrames;
	private int delay = 0;
	private int frameIndex = 0;
	
//	private BufferedImage[] images;
//	private BufferedImage currentImage;
	
	
	
	
	public Action (int speed, BufferedImage... images)
	{
//		this.speed = speed;
		
//		this.images = images;
		
//		this.numberOfFrames = this.images.length;
	}
	
	
	
	
	public void runAction()
	{
		delay++;
		
		if(delay > speed)
		{
			delay = 0;
			nextFrame();
		}
	}
	
	
	
	
	public void drawAction(Graphics g)
	{
		//TODO Draw Action
//		g.drawImage(currentImage, (int)x - offset, (int)y, null);
	}
	
	
	
	
	private void nextFrame()
	{
//		currentImage = images[frameIndex];
		
		frameIndex++;
		
		if (frameIndex > numberOfFrames)
		{
			frameIndex = 0;
		}
	}
}
