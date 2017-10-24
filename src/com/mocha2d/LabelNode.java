package com.mocha2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;





public class LabelNode extends Node 
{
	public String text = "";
	
	
	private Font font = new JLabel().getFont();
	private float fontSize = 32;
	private Color fontColor = Color.BLACK;
	
	
	
	
	public LabelNode()
	{
		
	}
	
	
	
	
	public LabelNode(String text)
	{
		this.text = text;
		
		Canvas tempCanvas = new Canvas();
		this.size.width = tempCanvas.getFontMetrics(this.font).stringWidth(this.text);
		this.size.height = this.fontSize;
	}
	
	
	
	
	public void setFont(String fontPath)
	{
		InputStream fontStream;
		try 
		{
			fontStream = new BufferedInputStream(new FileInputStream(fontPath));
			font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
			
			Canvas tempCanvas = new Canvas();
			this.size.width = tempCanvas.getFontMetrics(this.font).stringWidth(this.text);
			this.size.height = this.fontSize;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (FontFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void setFontSize(float fontSize)
	{
		this.fontSize = fontSize;
		this.font = this.font.deriveFont(fontSize);
	}
	
	
	
	
	public void setFontColor(Color color)
	{
		this.fontColor = color;
	}
	
	
	
	
	public Font getFont()
	{
		return this.font;
	}
	
	
	
	
	public float getFontSize()
	{
		return this.fontSize;
	}
	
	
	
	
	public Color getFontColor()
	{
		return this.fontColor;
	}
	
	
	
	
	
	void tick()
	{
		if (!this.realChildren.isEmpty())
		{
			LinkedList<Node> fauxChildren = this.realChildren;
			LinkedList<Node> toBeRemoved = new LinkedList<Node>();
			for (Node node : fauxChildren) 
			{
				
				if (node.shouldBeRemoved)
				{
					toBeRemoved.add(node);
				}
				else
				{
					node.tick();
				}
			}
			
			this.realChildren.removeAll(toBeRemoved);
		}
		
		
		if (this.hasActions)
		{
			for (Iterator<Action> childAction = actions.iterator(); childAction.hasNext();) 
			{
				Action action = childAction.next();
				if (!action.actionComplete)
				{
					action.tick();
				}
			}
		}
		
		if (this.hasPhysicsBody)
		{
			this.getPhysicsBody().body = this.getBounds();
		}
	}
	
	
	
	
	void render(Graphics graphics)
	{
		final Graphics2D g = (Graphics2D) graphics.create();
		
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		
		if (!this.realChildren.isEmpty())
		{
			LinkedList<Node> fauxChildren = this.realChildren;
			for (Node node : fauxChildren) 
			{
				node.render(g);
			}
		}
		
		if (this.font != null)
		{
			this.font = this.font.deriveFont(fontSize);
			g.setFont(this.font);
		}
		
		g.setColor(this.fontColor);
		g.drawString(this.text, (int)this.position.x, (int)this.position.y);
		
		
		g.dispose();
	}
}
