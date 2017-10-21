package com.mocha2d;





public class PhysicsContact
{
	public PhysicsBody bodyA;
	public PhysicsBody bodyB;
	
	
	
	
	public PhysicsContact()
	{
		
	}
	
	
	
	
	public PhysicsContact(PhysicsBody bodyA, PhysicsBody bodyB)
	{
		this.bodyA = bodyA;
		this.bodyB = bodyB;
	}
}
