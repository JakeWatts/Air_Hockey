//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int x,int y){
	   super(x,y);
	   speed=5;
   }
   public Paddle(int x,int y, int z){
	   super(x,y);
	   speed=z;
   }
   public Paddle(int x, int y, int wid, int ht){
	   super(x,y,wid,ht);
	   speed=5;
   }
   public Paddle(int x, int y, int wid, int ht, Color col, int spd){
	   super(x,y,wid,ht,col);
	   speed=spd;
   }
   public Paddle(int x, int y, int wid, int ht, int spd){
	   super(x,y,wid,ht);
	   speed=spd;
   }



   public void moveUpAndDraw(Graphics window)
   {
	   super.draw(window,Color.WHITE);
	   setY(getY()-speed);
	   super.draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   super.draw(window,Color.WHITE);
	   setY(getY()+speed);
	   super.draw(window);

   }
   public void moveRightAndDraw(Graphics window)
   {
	   super.draw(window,Color.WHITE);
	   setX(getX()+speed);
	   super.draw(window);
   }
   public void moveLeftAndDraw(Graphics window)
   {
	   super.draw(window,Color.WHITE);
	   setX(getX()-speed);
	   super.draw(window);
   }
   public void setSpeed(int x){
	   speed=x;
   }
   //add get methods
   public int getSpeed(){
	   return speed;
   }
   
   //add a toString() method
   public String toString(){
	   return super.toString()+speed;
   }
}