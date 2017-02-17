import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class AirHockey extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Paddle rightgoal;
	private Paddle leftgoal;
	private boolean[] keys;
	private BufferedImage back;
	private boolean b=true;


	public AirHockey()
	{
		//set up all variables related to the game
		ball=new Ball();
		leftPaddle=new Paddle(70,10,50,50,Color.BLUE,2);
		rightPaddle=new Paddle(530,10,50,50,Color.BLUE,2);
		rightgoal=new Paddle(780,260,20,80,Color.YELLOW,0);
		leftgoal=new Paddle(20,260,20,80,Color.YELLOW,0);



		keys = new boolean[8];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		leftgoal.draw(graphToBack);
		rightgoal.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()<580&&ball.getY()>20))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}



		//see if the ball hits the left paddle
		if(ball.didCollideLeft(leftPaddle))
			ball.setXSpeed(-ball.getXSpeed());
		if(ball.didCollideBottom(leftPaddle))
			ball.setYSpeed(-ball.getYSpeed());
		if(ball.didCollideBottom(rightPaddle))
			ball.setYSpeed(-ball.getYSpeed());
		
		//see if the ball hits the right paddle
		if(ball.didCollideRight(rightPaddle))
			ball.setXSpeed(-ball.getXSpeed());
		if(ball.didCollideRight(rightgoal)){
			if(b)
				System.out.println("left scores!");
			b=false;
			}
		else
			b=true;
		if(ball.didCollideLeft(leftgoal)){
			if (b)
				System.out.println("right scores!");
			b=false;
			}
		else
			b=true;
		//see if the paddles need to be moved

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[4] == true)
		{
			leftPaddle.moveRightAndDraw(graphToBack);
		}
		if(keys[5] == true)
		{
			leftPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[6] == true)
		{
			rightPaddle.moveRightAndDraw(graphToBack);
		}
		if(keys[7] == true)
		{
			rightPaddle.moveLeftAndDraw(graphToBack);
		}












		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
			case 'D' : keys[4]=true; break;
			case 'A' : keys[5]=true; break;
			case 'L' : keys[6]=true; break;
			case 'J' : keys[7]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
			case 'D' : keys[4]=false; break;
			case 'A' : keys[5]=false; break;
			case 'L' : keys[6]=false; break;
			case 'J' : keys[7]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}