package com.mocha2d;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;





class BufferedImageLoader 
{
	private BufferedImage image;
	
	
	
	
	public BufferedImage loadImage(String path) throws IOException
	{
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
}
