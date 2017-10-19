package com.tommetzger.mocha2d;

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
	
	
	
	
	public static Action moveNodeByX(Node node, double x)
	{
		MoveNodeByX action = new MoveNodeByX(x);
		action.node = node;
		return action; 
	}
	
	
	
	
	public static Action moveNodeByY(Node node, double y)
	{
		MoveNodeByY action = new MoveNodeByY(y);
		action.node = node;
		return action; 
	}
	
	
	
	
	public static Action moveNodeToX(Node node, double x)
	{
		MoveNodeToX action = new MoveNodeToX(x);
		action.node = node;
		return action; 
	}
	
	
	
	
	public static Action moveNodeToY(Node node, double x)
	{
		MoveNodeToY action = new MoveNodeToY(x);
		action.node = node;
		return action; 
	}
	
	
	
	
	public void tick() 
	{
		
	}
}
