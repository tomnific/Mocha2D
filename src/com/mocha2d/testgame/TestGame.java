package com.mocha2d.testgame;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.tommetzger.mocha2d.*;





public class TestGame extends Canvas
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame containerView;
	
	
	
	
	public static void main(String[] args) 
	{
		containerView = new JFrame("Test Game");
		containerView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		containerView.setResizable(false);
		containerView.setLocationRelativeTo(null);
		containerView.setVisible(true);

		
		GameScene scene = new GameScene();
		View view = new View();
		
		view.setPreferredSize(new Dimension(320, 420));
		
		//Debug
		view.showsFPS = true;
		view.showsNodeCount = true;
		
		containerView.add(view);
		containerView.pack();
		
		view.presentScene(scene);
	}
}
