//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;
	private boolean b=true;
	private boolean c=true;
	private boolean d=true;
	private boolean e=true;

	public Ball()
	{
		super(300,200);
		xSpeed = -3;
		ySpeed = 3;
	}
	public boolean didCollideTop(Object obj){
		
		return false;
	}
	public boolean didCollideBottom(Object obj){
		Paddle o=(Paddle) obj;
		if(getY()+(getYSpeed())<=o.getSpeed()+o.getY()+o.getHeight()&&o.getY()-(getYSpeed())-o.getSpeed()<=getY()+getHeight()){
			if(getX()<o.getX()+o.getWidth()+o.getSpeed()&&o.getSpeed()+getX()>o.getX()&&d){
				return true;
			}
			else if(getX()+getWidth()>o.getX()-o.getSpeed()&&getX()+getHeight()<o.getX()+o.getWidth()&&d){
				return true;
			}
			d=false;
		}
		else
			d=true;
		return false;
	}
	public boolean didCollideLeft(Object obj){
		Paddle o=(Paddle) obj;
		if(getX()+(getXSpeed())<=o.getSpeed()+o.getX()+o.getWidth()&&o.getX()-(getXSpeed())-o.getSpeed()<=getX()+getWidth()){
			if(getY()<o.getY()+o.getHeight()&&getY()>o.getY()&&b){
				return true;
			}
			else if(getY()+getHeight()>o.getY()&&getY()+getHeight()<o.getY()+o.getHeight()&&b){
				return true;
			}
			b=false;
		}
		else
			b=true;
		return false;
	}
	public boolean didCollideRight(Object obj){
		Paddle o=(Paddle)obj;
		if(getX()+getWidth()+getXSpeed()>=o.getX()&&o.getX()+o.getWidth()-getXSpeed()>=getX()){
			if(getY()<o.getY()+o.getHeight()&&getY()>o.getY()&&c){
				return true;
			}
			else if(getY()+getHeight()>o.getY()&&getY()+getHeight()<o.getY()+o.getHeight()&&c){
				return true;
			}
			c=false;
		}
		else
			c=true;
		return false;
		}
	//add the other Ball constructors
	public Ball(int x, int y){
		super(x,y); xSpeed = 3; ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int ht){
		super(x,y,wid,ht); xSpeed = 3; ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int ht, Color col){
		super(x,y,wid,ht,col); xSpeed = 3; ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int ht, Color col, int xs, int ys){
		super(x,y,wid,ht,col); xSpeed = xs; ySpeed = ys;
	}

	
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
	public void setX(int x){
		super.setX(x);
	}
	public void setY(int x){
		super.setY(x);
	}
	public void setWidth(int x){
		super.setWidth(x);
	}
	public void setHeight(int x){
		super.setHeight(x);
	}
	public void setColor(Color x){
		super.setColor(x);
	}
	public void setXSpeed(int x){
		xSpeed = x;
	}
	public void setYSpeed(int x){
		ySpeed = x;
	}
	

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);

		//draw the ball at its new location
      window.setColor(getColor());
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{




		return false;
	}   

   //add the get methods
	public int getXSpeed(){
		return xSpeed;
	}
	public int getYSpeed(){
		return ySpeed;
	}
   //add a toString() method
}