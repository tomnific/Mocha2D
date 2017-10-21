package com.tommetzger.mocha2d;

import java.awt.Color;
import java.awt.Rectangle;





public class ShapeNode extends Node 
{
	boolean isRectangle = false;
	boolean isCircle = false;
	boolean isEllipse = false;
	
	
	public Color fillColor = Color.BLACK;
	public Color strokeColor = Color.BLACK;
	
	public float lineWidth;
	public boolean isAntialiased;
	
	
	
	
	public ShapeNode(Rectangle rect)
	{
		
	}
	
	
	
	
	public ShapeNode(Rectangle rect, float cornerRadius)
	{
		
	}
	
	
	
	
	public ShapeNode(float circleOfRadius)
	{
		
	}
	
	
	
	
	public ShapeNode(float elipseWidth, float elipseHeight)
	{
		
	}
	
	
	
	
	public ShapeNode(Position[] positions, int count) //will need to change type later
	{
		
	}
	
	
	
	
	void render()
	{
		
	}
}
