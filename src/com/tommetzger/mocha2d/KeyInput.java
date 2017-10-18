package com.tommetzger.mocha2d;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;





class KeyInput extends KeyAdapter
{
	Scene scene;
	
	
	
	public KeyInput(Scene scene)
	{
		this.scene = scene;
	}
	
	
	
	public void keyPressed(KeyEvent e)
	{
		scene.keyPressed(e);
	}
	
	
	
	public void keyReleased(KeyEvent e)
	{
		scene.keyReleased(e);
	}
}
