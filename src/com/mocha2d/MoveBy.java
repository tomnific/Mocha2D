package com.mocha2d;





class MoveBy extends Action 
{
	private double velX;
	private double velY;
	private double destX;
	private double destY;
	private boolean destinationCalculated = false;
	private boolean xComplete = false;
	private boolean yComplete = false;
	
	
	
	public MoveBy(double x, double y)
	{
		velX = x;
		velY = y;
	}
	
	
	
	
	public void tick()
	{		
		if (!destinationCalculated)
		{
			destX = this.node.position.x + velX;
			destY = this.node.position.y + velY;
			destinationCalculated = true;
		}
				
		if (velX > 0)
		{
			if (this.node.position.x >= destX)
			{
				xComplete = true;
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
				xComplete = true;
			}
			else
			{
				this.node.position.x--;
			}
		}
		
		if (velY > 0)
		{
			if (this.node.position.y >= destY)
			{
				yComplete = true;
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
				yComplete = true;
			}
			else
			{
				this.node.position.y--;
			}
		}
		
		if(xComplete && yComplete)
		{
			this.actionComplete = true;
		}
	}
}
