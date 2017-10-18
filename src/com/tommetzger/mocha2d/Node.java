/**
 * @file Node.java
 * @brief The Node class is the most basic game object, and the building block of most other game objects
 * The Node class doesn't draw any visual content. It provides baseline behavior for all other node classes to use.
 * @author Tom Metzger
 * @date April 2017
 */

package com.tommetzger.mocha2d;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;





public class Node 
{
	public class Position
	{
		public double x;
		public double y;
		
		public Position ()
		{
			x = 0;
			y = 0;
		}
	}
	
	
	
	
	public boolean hasActions;
	LinkedList<Action> actions;
	
	
	public Position position = new Position();
	public double zPosition;
	
	public double zRotation;
	
	public double xScale;
	public double yScale;
	
	public double alpha;
	public boolean isVisible;
	
	public Rectangle frame;
	
	public String name;
	
	public PhysicsBody physicsBody;
	
	public Node[] children;
	
	LinkedList<Node> realChildren = new LinkedList<Node>();
		
	
	
	
	public Node ()
	{
		position.x = 0;
		position.y = 0;
		zPosition = 0;
	}
	
	
	
	public Node (double x, double y)
	{
		position.x = x;
		position.y = y;
		zPosition = 0; 
	}
	
	
	
	
	public void setScale(double scale)
	{
		xScale = scale;
		yScale = scale;
	}
	
	
	
	
	public void addChild(Node child)
	{
		realChildren.add(child);
		
		children = realChildren.toArray(new Node[realChildren.size()]);
	}
	
	
	
	
	public void removeChild(Node child)
	{
		realChildren.remove(child);
		
		children = (Node[]) realChildren.toArray();
	}
	
	
	
	
	public void removeChildren()
	{
		realChildren.clear();
		
		children = null; //ify if this is good
	}
	
	
	
	
	
//	public Rect getBounds()
//	{
//		return new Rect((int)this.position.x, (int)this.position.y, this.xScale, this.yScale);
//	}
	
	
	
	
	public boolean hasActions()
	{
		return hasActions;
	}
	
	
	
	
	public void runAction(Action action)
	{
		this.actions.add(action);
		hasActions = true;
	}
	
	
	
	
	
	void tick()
	{
		if (!this.realChildren.isEmpty())
		{
			for (Iterator<Node> childNode = this.realChildren.iterator(); childNode.hasNext();) 
			{
				Node node = childNode.next();
				
				node.tick();
				
				if (node.hasActions)
				{
					for (Iterator<Action> childAction = actions.iterator(); childAction.hasNext();) 
					{
						Action action = childAction.next();
						action.runAction();
					}
				}
			}
		}
		
		
		if (this.hasActions)
		{
			for (Iterator<Action> childAction = actions.iterator(); childAction.hasNext();) 
			{
				Action action = childAction.next();
				action.runAction();
			}
		}
	}
	
	
	
	
	void render(Graphics g)
	{
		if (!this.realChildren.isEmpty())
		{
			for (Iterator<Node> childNode = this.realChildren.iterator(); childNode.hasNext();) 
			{
				Node node = childNode.next();
				
				node.render(g);
				
				if (node.hasActions)
				{
					for (Iterator<Action> childAction = actions.iterator(); childAction.hasNext();) 
					{
						Action action = childAction.next();
						action.drawAction(g);
					}
				}
			}
		}
		
		
		if (this.hasActions)
		{
			for (Iterator<Action> childAction = actions.iterator(); childAction.hasNext();) 
			{
				Action action = childAction.next();
				action.drawAction(g);
			}
		}
	}
}