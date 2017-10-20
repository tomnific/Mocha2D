package com.mocha2d.testgame;

import java.awt.event.KeyEvent;

import com.tommetzger.mocha2d.*;





public class GameScene extends Scene 
{
	
	public SpriteNode player;
	public LabelNode score;
	public SpriteNode enemy;
	
	public int velX = 0;
	boolean runAction = false;

	
	
	@Override
	public void didMoveToView() 
	{
		player = new SpriteNode("/spaceship.png");
		
		player.name = "player";
		
		player.position.x = this.getHeight() / 2;
		player.position.y = this.getWidth() / 2;
		
		player.size.width = 50;
		player.size.height = 50;
		
		player.setPhysicsBody(new PhysicsBody(1, 0));
		
		this.addChild(player);
				
		
		score = new LabelNode("Score: ");
		
		score.setFont("res/anklepants.ttf");
		score.setFontSize(15);
		
		score.position.x = 5;
		score.position.y = 15;
		
		this.addChild(score);
		
		
		enemy = new SpriteNode("/spaceship.png");
		
		enemy.name = "enemy";
		
		enemy.position.x = 50;
		enemy.position.y = this.getWidth() / 2;
		
		enemy.size.width = 50;
		enemy.size.height = 50;
		
		enemy.setPhysicsBody(new PhysicsBody(3, 1));
		
		this.addChild(enemy);
	}




	@Override
	public void update() 
	{		
//		Action action = new Action(player);//Action.moveNodeByX(player, velX);
//		
//		if (runAction)
//		{
//		player.runAction(action);
//		}
//		System.out.println("PlayerX: " + player.position.x);
	}

	
	
	
	@Override
	public void keyDown(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		
		if(key == KeyEvent.VK_RIGHT)
		{
			Action action = Action.moveByX(3);
			
			player.runAction(action);
		}
		else if(key == KeyEvent.VK_LEFT)
		{
			Action action = Action.moveByX(-3);
			
			player.runAction(action);
		}
		else if(key == KeyEvent.VK_UP)
		{
			Action action = Action.moveByY(-3);
			
			player.runAction(action);
		}
		else if(key == KeyEvent.VK_DOWN)
		{
			Action action = Action.moveByY(3);
			
			player.runAction(action);
		}
		else if (key == KeyEvent.VK_D)
		{
			player.removeFromParent();
		}
	}

	
	
	
	@Override
	public void keyUp(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		
		if(key == KeyEvent.VK_RIGHT)
		{
			player.clearActions();
		}
		else if(key == KeyEvent.VK_LEFT)
		{
			player.clearActions();
		}
		else if(key == KeyEvent.VK_UP)
		{
			player.clearActions();
		}
		else if(key == KeyEvent.VK_DOWN)
		{
			player.clearActions();
		}
		else if (key == KeyEvent.VK_SPACE)
		{
			SpriteNode missile = new SpriteNode("/spaceship.png");
			missile.position.x = player.position.x;
			missile.position.y = player.position.y;

			this.addChild(missile);
			
			Action action = Action.moveToY(-25);
			
			missile.runAction(action);
		}
	}




	@Override
	public void didBeginContact(PhysicsContact contact) 
	{
		PhysicsBody firstBody = contact.bodyA;
		PhysicsBody secondBody = contact.bodyB;
		
		if (firstBody.collisionBitMask == secondBody.categoryBitMask)
		{
			secondBody.node.removeFromParent();
		}
	}
}
