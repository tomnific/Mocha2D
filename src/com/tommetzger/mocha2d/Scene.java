package com.tommetzger.mocha2d;

import java.awt.event.KeyEvent;





public abstract class Scene extends Node
{
	public View view;
	
	
	
	
	public abstract void didMoveToView();  //didStart
	
	
	
	
	public abstract void update(); //tick()
	
	
	
	
	public abstract void keyPressed(KeyEvent e);
	
	
	
	
	public abstract void keyReleased(KeyEvent e);
	
	
	
	
	public int getHeight()
	{
		return view.getHeight();
	}
	
	
	
	
	public int getWidth()
	{
		return view.getWidth();
	}
}
