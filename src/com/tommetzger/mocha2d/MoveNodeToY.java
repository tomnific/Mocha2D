package com.tommetzger.mocha2d;





class MoveNodeToY extends Action
{
	private double destY;
	
	
	
	public MoveNodeToY(double y)
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
