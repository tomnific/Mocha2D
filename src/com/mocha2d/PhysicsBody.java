package com.mocha2d;

import java.awt.Rectangle;





public class PhysicsBody
{
	Rectangle body;
	
	public Node node;
	
	public boolean isDynamic = true; //effected by gravity
	public boolean affectedByGravity = true; //?
	
	public int collisionBitMask = 0; //what it collides with
	public int categoryBitMask = 0; //what collides with it
	
	
	
	
	public PhysicsBody(int collisionBitMask, int categoryBitMask)
	{	
		this.collisionBitMask = collisionBitMask;
		
		this.categoryBitMask = categoryBitMask;
	}
}
