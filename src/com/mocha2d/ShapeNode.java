package com.mocha2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;





public class ShapeNode extends Node 
{
	boolean isRectangle = false;
	boolean isRoundedRectangle = false;
	float cornerRadius = 0;
	Rectangle rectangle;
	
	boolean isCircle = false;
	float circleRadius = 0;
	
	boolean isEllipse = false;
	float ellipseWidth = 0;
	float ellipseHeight = 0;
	
	boolean isPolygon = false;
	int[] xPoints;
	int[] yPoints;
	int pointCount = 0;
	
	
	public Color fillColor = Color.BLACK;
	public Color strokeColor = Color.BLACK;
	
	public float lineWidth;
	public boolean isAntialiased;
	
	
	
	
	public ShapeNode(Rectangle rect)
	{
		isRectangle = true;
		
		this.rectangle = rect;
		
		this.position.x = this.rectangle.x;
		this.position.y = this.rectangle.y;
		this.size.width = this.rectangle.width;
		this.size.height = this.rectangle.height;
	}
	
	
	
	
	public ShapeNode(Rectangle rect, float cornerRadius)
	{
		isRoundedRectangle = true;
		
		this.rectangle = rect;
		
		this.position.x = this.rectangle.x;
		this.position.y = this.rectangle.y;
		this.size.width = this.rectangle.width;
		this.size.height = this.rectangle.height;
		
		this.cornerRadius = cornerRadius;
	}
	
	
	
	
	public ShapeNode(float circleOfRadius)
	{
		this.isCircle = true;
		this.circleRadius = circleOfRadius;
	}
	
	
	
	
	public ShapeNode(float ellipseWidth, float ellipseHeight)
	{
		this.isEllipse = true;
		this.ellipseWidth = ellipseWidth;
		this.ellipseHeight = ellipseHeight;
	}
	
	
	
	
	public ShapeNode(Point[] points, int count) //will need to change type later
	{
		this.isPolygon = true;
		
		this.xPoints = new int[count];
		this.yPoints = new int[count];
		
		this.pointCount = count;
		
		for (int i = 0; i < points.length; i++)
		{
			this.xPoints[i] = (int)points[i].x;
			this.yPoints[i] = (int)points[i].y;
		}
	}
	
	
	
	
	void tick()
	{
//		System.out.println("   -ShapeNode Tick");
//		this.position.x += velX;
		if(!this.realChildrenToAdd.isEmpty())
		{
			this.realChildren.addAll(this.realChildrenToAdd);
			this.realChildrenToAdd.clear();
		}
		
		this.children = realChildren.toArray(new Node[realChildren.size()]);
		
		if (!this.realChildren.isEmpty())
		{
			LinkedList<Node> fauxChildren = this.realChildren;
			LinkedList<Node> toBeRemoved = new LinkedList<Node>();
			for (Node node : fauxChildren) 
			{
				
				if (node.shouldBeRemoved)
				{
					toBeRemoved.add(node);
				}
				else
				{
					node.tick();
				}
			}
			
			this.realChildren.removeAll(toBeRemoved);
		}
		
		
		if (this.hasActions)
		{
			if (!this.actionsToAdd.isEmpty())
			{
				this.actions.addAll(this.actionsToAdd);
				this.actionsToAdd.clear();
			}
			for (Iterator<Action> childAction = actions.iterator(); childAction.hasNext();) 
			{
				Action action = childAction.next();
				if (!action.actionComplete)
				{
					action.tick();
				}
			}
		}
				
		if (this.hasPhysicsBody)
		{
			this.getPhysicsBody().body = this.getBounds();
		}
	}
	
	
	
	
	void render(Graphics graphics)
	{
		final Graphics g = graphics.create();
		
		
		if (!this.realChildren.isEmpty())
		{
			LinkedList<Node> fauxChildren = this.realChildren;
			for (Node node : fauxChildren) 
			{
				node.render(g);
			}
		}
		
		
		
		if (isRectangle)
		{
			g.setColor(this.strokeColor);
			g.drawRect((int)this.position.x, (int)this.position.y, (int)this.size.width, (int)this.size.height);
			
			g.setColor(this.fillColor);
			g.fillRect((int)this.position.x, (int)this.position.y, (int)this.size.width, (int)this.size.height);;
		}
		else if (isRoundedRectangle)
		{
			g.setColor(this.strokeColor);
			g.drawRoundRect((int)this.position.x, (int)this.position.y, (int)this.size.width, (int)this.size.height, (int)this.cornerRadius, (int)this.cornerRadius);
	
			g.setColor(this.fillColor);
			g.fillRoundRect((int)this.position.x, (int)this.position.y, (int)this.size.width, (int)this.size.height, (int)this.cornerRadius, (int)this.cornerRadius);;
		}
		else if (isCircle)
		{
			g.setColor(this.strokeColor);
			g.drawOval((int)this.position.x, (int)this.position.y, (int)this.circleRadius, (int)this.circleRadius);
			
			g.setColor(this.fillColor);
			g.fillOval((int)this.position.x, (int)this.position.y, (int)this.circleRadius, (int)this.circleRadius);
		}
		else if (isEllipse)
		{
			g.setColor(this.strokeColor);
			g.drawOval((int)this.position.x, (int)this.position.y, (int)this.ellipseWidth, (int)this.ellipseHeight);
			
			g.setColor(this.fillColor);
			g.fillOval((int)this.position.x, (int)this.position.y, (int)this.ellipseWidth, (int)this.ellipseHeight);
		}
		else if (isPolygon)
		{
			g.setColor(this.strokeColor);
			g.drawPolygon(this.xPoints, this.yPoints, this.pointCount);
			
			g.setColor(this.fillColor);
			g.fillPolygon(this.xPoints, this.yPoints, this.pointCount);
		}
		
		
		g.dispose();
	}
}
