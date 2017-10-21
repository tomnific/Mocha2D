package com.tommetzger.mocha2d;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;





public abstract class Scene extends Node
{
	public View view;
	
	
	
	
	public abstract void didMoveToView();  //didStart
	
	
	
	
	public abstract void mouseDown(MouseEvent e);
	
	
	
	
	public abstract void mouseDragged(MouseEvent e);
	
	
	
	public abstract void mouseUp(MouseEvent e);
	
	
	
	
	public abstract void keyDown(KeyEvent e);
	
	
	
	
	public abstract void keyUp(KeyEvent e);
	
	
	
	
	public abstract void update();
	
	
	
	
	public abstract void didBeginContact(PhysicsContact contact); 
	
	
	
	
	public int getHeight()
	{
		return view.getHeight();
	}
	
	
	
	
	public int getWidth()
	{
		return view.getWidth();
	}
}
