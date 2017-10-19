package com.tommetzger.mocha2d;





class MoveNodeByY extends Action 
{
	private double velY;
	private double destY;
	
	
	
	public MoveNodeByY(double y)
	{
		velY = y;
	}
	
	
	
	
	public void tick()
	{
		destY = this.node.position.y + velY;
		
		if (velY > 0)
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
