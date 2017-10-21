package com.mocha2d;





class MoveToY extends Action
{
	private double destY;
	
	
	
	public MoveToY(double y)
	{
		destY = y;
	}
	
	
	
	
	public void tick()
	{	
		if (destY > this.node.position.y)
		{
			this.node.position.y++;
		}
		else
		{
			this.node.position.y--;
		}
		
		if (this.node.position.y == destY)
		{
			this.actionComplete = true;
		}
	}
}
