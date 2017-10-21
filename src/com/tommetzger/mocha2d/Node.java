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
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.LinkedList;





public class Node 
{
	public class Position
	{
		public double x;
		public double y;
		
		public Position()
		{
			x = 0;
			y = 0;
		}
	}
	
	
	
	
	public class Size
	{
		public double width;
		public double height;
		
		public Size()
		{
			width = 32;
			height = 32;
		}
	}
	
	
	
	
	public boolean hasActions;
	LinkedList<Action> actions = new LinkedList<Action>();
	LinkedList<Action> actionsToAdd = new LinkedList<Action>();
	
	
	public Position position = new Position();
	public double zPosition = 0;
	
	public Size size = new Size();
//	private double xScale = 1;
//	private double yScale = 1;
	
	public double zRotation;
	
	
	public double alpha;
	public boolean isVisible;
	
	public Rectangle frame;
	
	public String name;
	
	private PhysicsBody physicsBody;
	boolean hasPhysicsBody = false;
	
	public Node[] children;
	
	private Node parent;
	boolean shouldBeRemoved = false;
	
	
	LinkedList<Node> realChildren = new LinkedList<Node>();
	LinkedList<Node> realChildrenToAdd = new LinkedList<Node>();
	
	ImageObserver imageObserver;
	View controllerView;
		
	
	
	
	public Node ()
	{
		
	}
	
	
	
	public Node (double x, double y)
	{
		position.x = x;
		position.y = y;
	}
	
	
	
	
//	public void setScale(double scale)
//	{
//		this.xScale = scale;
//		this.yScale = scale;
//		this.size.width = this.size.width * scale;
//		this.size.height = this.size.height * scale;
//	}
	
	
	
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)this.position.x, (int)this.position.y, (int)this.size.width, (int)this.size.height);
	}
	
	
	
	
	public PhysicsBody getPhysicsBody() 
	{
		return this.physicsBody;
	}



	public void setPhysicsBody(PhysicsBody physicsBody) 
	{
		this.physicsBody = physicsBody;
		this.physicsBody.node = this;
		this.physicsBody.body = this.getBounds();
		this.hasPhysicsBody = true;
	}



	public Node getParent()
	{
		return this.parent;
	}
	
	
	
	
	public void addChild(Node child)
	{
		child.parent = this;
		child.imageObserver = this.imageObserver;
		child.controllerView = this.controllerView;
		
		realChildrenToAdd.add(child);
		
//		children = realChildren.toArray(new Node[realChildren.size()]);
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
	
	
	
	
	public void removeFromParent()
	{
		this.parent = null;
		this.shouldBeRemoved = true;
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
		action.node = this;
//		this.actions.add(action);
		this.actionsToAdd.add(action);
		this.hasActions = true;
	}
	
	
	
	
	public void clearActions()
	{
		this.hasActions = false;
		this.actions.clear();
	}
	
	
	
	
	
	void tick()
	{
//		System.out.println("   +Node Tick");
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
			this.getPhysicsBody().body= this.getBounds();
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
		
		
		g.dispose();
	}
}