package com.tommetzger.mocha2d;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




class MouseInput extends MouseAdapter
{
	Scene scene;
	
	
	
	
	public MouseInput(Scene scene)
	{
		this.scene = scene;
	}
	
	
	
	
	public void mousePressed(MouseEvent e)
	{
		this.scene.mouseDown(e);
	}
	
	
	
	
	public void mouseDragged(MouseEvent e)
	{
		this.scene.mouseDragged(e);
	}
	
	
	
	
	public void mouseReleased(MouseEvent e)
	{
		this.scene.mouseUp(e);
	}
}
