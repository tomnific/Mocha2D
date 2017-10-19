package com.tommetzger.mocha2d;





class MoveNodeToX extends Action
{
	private double destX;
	
	
	
	public MoveNodeToX(double x)
	{
		destX = x;
	}
	
	
	
	
	public void tick()
	{	
		if (destX > this.node.position.x)
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
