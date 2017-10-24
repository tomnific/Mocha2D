package com.mocha2d;





class MoveByX extends Action 
{
	private double velX;
	private double destX;
	private boolean destinationCalculated = false;
	
	
	
	public MoveByX(double x)
	{
		velX = x;
	}
	
	
	
	
	public void tick()
	{
		if (!destinationCalculated)
		{
			destX = this.node.position.x + velX;
			destinationCalculated = true;
		}
				
		if (velX > 0)
		{
			if (this.node.position.x >= destX)
			{
				this.actionComplete = true;
			}
			else
			{
				this.node.position.x++;
			}
		}
		else 
		{
			if (this.node.position.x <= destX)
			{
				this.actionComplete = true;
			}
			else
			{
				this.node.position.x--;
			}
		}
	}
}
