package com.mocha2d;

import java.awt.Graphics;





class MoveByX extends Action 
{
	private double velX;
	private double destX;
	
	
	
	public MoveByX(double x)
	{
		velX = x;
	}
	
	
	
	
	public void tick()
	{
		destX = this.node.position.x + velX;
		
		if (velX > 0)
		{
			this.node.position.x++;
		}
		else
		{
			this.node.position.x--;
		}
		
		if (this.node.position.x == destX)
		{
			this.actionComplete = true;
		}
	}
}
