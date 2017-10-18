/**
 * @file SpriteNode.java
 * @brief A Node that contains an image
 * @author Tom Metzger
 * @date April 2017
 */

package com.tommetzger.mocha2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;





public class SpriteNode extends Node
{
	public BufferedImage image;
	
	
	
	
	private BufferedImageLoader loader = new BufferedImageLoader();
	
	
	
	
	/// Empty SpriteNode constructor.
	/** Empty SpriteNode constructor. Sets position to (0,0)*/
	public SpriteNode()
	{
		this.position.x = 0;
		this.position.y = 0;
	}
	
	
	
	
	/// Position SpriteNode constructor.
	/** Position SpriteNode constructor. Sets position to (x,y)*/
	public SpriteNode(double x, double y)
	{
		this.position.x = x;
		this.position.y = y;		
	}
	
	
	
	
	/// Image SpriteNode constructor.
	/** Image SpriteNode constructor. Sets image to imageNamed
	 * @throws IOException */
	public SpriteNode(String imageName) throws IOException
	{
		this.image = loader.loadImage(imageName);
		
		this.position.x = 0;
		this.position.y = 0;
	}
	
	
	
	
	/// Full SpriteNode constructor.
	/** Full SpriteNode constructor. Sets image to imageNamed and position to (x,y). 
	 * @throws IOException */
	public SpriteNode(double x, double y, String imageNamed) throws IOException
	{
		this.position.x = x;
		this.position.y = y;
		
		this.image = loader.loadImage(imageNamed);
	}
	
	
	
	
	/// Changes the position of the SpriteNode to (x,y).
	/** Changes the position of the SpriteNode to (x,y). For use after the SpriteNode is instantiated.*/
	public void setPosition(double x, double y)
	{
		this.position.x = x;
		this.position.y = y;
	}
	
	
	
	
	/// Changes the image of the SpriteNode to imageNamed.
	/** Changes the image of the SpriteNode to imageNamed. For use after the SpriteNode is instantiated.
	 * @throws IOException */
	public void setImage(String imageNamed) throws IOException
	{
		this.image = loader.loadImage(imageNamed);
	}
	
	
	
	
	void render(Graphics g)
	{
		g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
	}
}
