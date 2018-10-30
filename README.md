# Mocha2D
A SpriteKit-like game library for Java. 

## Getting Started
### Scenes
A `Scene` is the root node for all Mocha2D objects displayed in a view. It contains all of the `Nodes` and the rules for how they interact. These nodes provide the scene with content to pass up to the `View` for rendering.

First, you need to make your `Scene`. To do this, create a new Java class that is a subclass of `Scene`, like so:

```java
package com.yourorganization.yourproject;

import com.mocha2d.*;


public class GameScene extends Scene
{
}
```

Make sure you include the required methods so that your `Scene` looks something like:

```java
public class GameScene extends Scene
{
	@Override
	public void didMoveToView() 
	{
	}
	
	@Override
	public void mouseDown(MouseEvent e) 
	{
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
	}
	
	@Override
	public void mouseUp(MouseEvent e) 
	{
	}
	
	@Override
	public void keyDown(KeyEvent e) 
	{
	}
	
	@Override
	public void keyUp(KeyEvent e) 
	{
	}
	
	@Override
	public void update() 
	{
	}
	
	@Override
	public void didBeginContact(PhysicsContact contact) 
	{
	}
}
```

From here, all that's left is to add your `Nodes` and tell them what to do - the `View` will handle the rest!

### Views
A `View` is an object that displays the Mocha2D content, which is provided by the scene. It keeps track of all the objects in the `Scene`, calculates the physics, and renders the objects accordingly.

To start, you need to create a new class that is a subclass of the Java `Canvas`, like so:

```java
package com.yourorganization.yourproject;

import com.mocha2d.*;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Game extends Canvas
{
}
```

You'll notice there's some additional `import` statements. These will come in handy for the next step. The `View` lives inside of a `JFrame` (though if you have another preferred window type, you can use that too). So, the next step is to create the `JFrame`:

```java
public class Game extends Canvas
{
	private static final long serialVersionUID = 1L; //Required By Canvas
	static JFrame frame;
	
	
	public static void main(String[] args) 
	{
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //You can do what you want here
		frame.setResizable(false); //It's best practice not to resize it
		frame.setLocationRelativeTo(null); //You can do what you want here
		frame.setVisible(true); //It's gotta be visible to see the game
	}
}
```

Next, in the `main()` function after the `JFrame` stuff, you need to create an object for your custom `Scene` and a `View`, like this:

```java
GameScene scene = new GameScene();

View view = new View();
```

Then, there are some options that are helpful to give to the view:

```java
view.setPreferredSize(new Dimension(320, 420)); //you can set it to whatever width/height you want
		
//Debug - Optional
view.showsFPS = true; //Displays the FPS in the bottom left corner of the View
view.showsNodeCount = true; //Displays the number of Nodes in the View, next to the FPS
```

After that, just add the `View` to the `JFrame`:

```java
containerView.add(view);
containerView.pack();
```

Finally, present the scene (the game won't start until it's presented):

```java
view.presentScene(scene);
```

