package com.mocha2d;





class MoveByY extends Action 
{
	private double velY;
	private double destY;
	private boolean destinationCalculated = false;
	
	
	
	public MoveByY(double y)
	{
		velY = y;
	}
	
	
	
	
	public void tick()
	{
		if (!destinationCalculated)
		{
			destY = this.node.position.y + velY;
			destinationCalculated = true;
		}
				
		if (velY > 0)
		{
			if (this.node.position.y >= destY)
			{
				this.actionComplete = true;
			}
			else
			{
				this.node.position.y++;
			}
		}
		else 
		{
			if (this.node.position.y <= destY)
			{
				this.actionComplete = true;
			}
			else
			{
				this.node.position.y--;
			}
		}
	}
}
