package com.tommetzger.mocha2d;

import java.awt.Rectangle;





public class PhysicsBody
{
	public boolean isDynamic; //effected by gravity
	
	
	public int collisionBitMask; //what it collides with
	public int categoryBitMask; //what collides with it

	public Rectangle body;
}
