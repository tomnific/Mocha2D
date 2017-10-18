package com.mocha2d.testgame;

import java.awt.event.KeyEvent;
import java.io.IOException;

import com.tommetzger.mocha2d.*;





public class GameScene extends Scene 
{
	
	public SpriteNode player;

	@Override
	public void didMoveToView() 
	{
		try
		{
			player = new SpriteNode("/spaceship.png");
			player.position.x = this.getHeight() / 2;
			player.position.y = this.getWidth() / 2;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		this.addChild(player);

	}




	@Override
	public void update() 
	{
		// TODO Auto-generated method stub

	}

	
	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub

	}

	
	
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub

	}

}
