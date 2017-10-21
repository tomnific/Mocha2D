package com.mocha2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;





public class Action 
{
	boolean actionComplete = false;
	
	Node node;
	
	
	
	
	public Action ()
	{
		
	}
	
	
	
	
	public static Action moveByX(double x)
	{
		MoveByX action = new MoveByX(x);
		return action; 
	}
	
	
	
	
	public static Action moveByY(double y)
	{
		MoveByY action = new MoveByY(y);
		return action; 
	}
	
	
	
	
	public static Action moveToX(double x)
	{
		MoveToX action = new MoveToX(x);
		return action; 
	}
	
	
	
	
	public static Action moveToY(double x)
	{
		MoveToY action = new MoveToY(x);
		return action; 
	}
	
	
	
	
	public void tick() 
	{
		
	}
}
